import { User } from 'src/app/models/user';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trip } from 'src/app/models/trip';
import { AuthService } from 'src/app/services/auth.service';
import { TripService } from 'src/app/services/trip.service';
import { FormControl } from '@angular/forms';
import { MapGeocoder } from '@angular/google-maps';
import { Address } from 'src/app/models/address';
import { Destination } from 'src/app/models/destination';
import { GeoResultToAddressPipe } from 'src/app/pipes/geo-result-to-address.pipe';
import { DestinationService } from 'src/app/services/destination.service';
import { AddressService } from 'src/app/services/address.service';
import { Vehicle } from 'src/app/models/vehicle';
import { Comment } from 'src/app/models/comment';
import { VehicleService } from 'src/app/services/vehicle.service';
import { CommentService } from 'src/app/services/comment.service';

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css'],
})
export class TripComponent implements OnInit {
  selected: Trip | null = null;
  newTrip: Trip = new Trip();
  vehicles: Vehicle[] = [];
  trips: Trip[] = [];
  currentTrips: Trip[] = [];
  pastTrips: any[] = [];
  vehicle: Vehicle | null = new Vehicle();
  @Input() profileTrip: Trip | null = null;
  startDestination = new FormControl('');
  endDestination = new FormControl('');
  newComment: Comment = new Comment();
  editComment: Comment | null = null;
  comments: Comment[] = [];
  selectedComment: Comment | null = null;

  constructor(
    private tripService: TripService,
    private auth: AuthService,
    private route: ActivatedRoute,
    private router: Router,
    private geocoder: MapGeocoder,
    private addrPipe: GeoResultToAddressPipe,
    private destService: DestinationService,
    private addressService: AddressService,
    private vehicleService: VehicleService,
    private commentService: CommentService
  ) {
    // this.newTrip.roundTrip = ''//;
    // this.newTrip.vehicle = '';
  }

  ngOnInit() {
    {
      this.reload();
    }
  }

  loggedIn() {
    return this.auth.checkLogin();
  }

  getSingleTripById(id: number) {
    this.tripService.getSingleTrip(id).subscribe((trip) => {
      this.selected = trip;
      this.reloadComment(trip.id);
    });
  }

  getVehicles(): void {
    this.vehicleService.getVehicles().subscribe((vehicles) => {
      console.log(vehicles);
      this.vehicles = vehicles;
    });
  }

  getCurrentTrips() {
    const now = new Date().getTime();
    this.tripService.getTrips().subscribe({
      next: (trips) => {
        this.currentTrips = trips.filter((trip) => {
          const endDate = new Date(trip.endDate).getTime();
          return endDate >= now;
        });
      },
      error: (err) => console.error(err),
    });
  }

  getPastTrips() {
    const now = new Date().getTime();
    this.tripService.getTrips().subscribe({
      next: (trips) => {
        this.pastTrips = trips.filter((trip) => {
          const endDate = new Date(trip.endDate).getTime();
          return endDate < now;
        });
      },
      error: (err) => console.error(err),
    });
  }

  createTrip(trip: Trip) {
    // console.log(this.vehicle)
    // trip.vehicle=this.vehicle;
    // console.log(trip.vehicle)
    this.auth.getLoggedInUser().subscribe({
      next: (user) => {
        trip.user = user;
        this.tripService.create(trip).subscribe({
          next: (madeTrip) => {
            this.selected = madeTrip;
            console.log(madeTrip);
          },
        });
      },
    });
  }

  clearTripDestinations() {
    this.newTrip.startDestination = null;
    this.newTrip.endDestination = null;
  }

  handleMapClick(mapEvent: google.maps.MapMouseEvent) {
    let lat = mapEvent.latLng;
    // console.log(lat);
    this.geocoder.geocode({ location: lat }).subscribe({
      next: (result) => {
        // console.log(result);
        let address = new Address();
        let geoAddress: any = result.results[0].address_components;
        address = this.addrPipe.transform(geoAddress);
        this.addressService.create(address).subscribe({
          next: (newAddress) => {
            console.log(newAddress);

            let dest = new Destination();
            dest.address = newAddress;
            dest.name = newAddress.city;
            console.log(dest);

            if (this.newTrip.startDestination == null) {
              this.destService.create(dest).subscribe({
                next: (madeDest) => {
                  this.newTrip.startDestination = madeDest;
                  // console.log(madeDest)
                },
              });
            } else if (this.newTrip.endDestination == null) {
              this.destService.create(dest).subscribe({
                next: (madeDest) => {
                  this.newTrip.endDestination = madeDest;
                  // console.log(madeDest)
                },
              });
            } else {
              this.clearTripDestinations();
            }

            console.log(this.newTrip);
          },
        });
      },
    });
  }

  // initiateComment() {
  //   let commentIdString = this.route.snapshot.paramMap.get('id');
  //   if (commentIdString) {
  //     let id = parseInt(commentIdString)
  //     if(isNaN(id)) {
  //       this.router.navigateByUrl('invalidId');
  //     }
  //     else {
  //       this.commentService.show(id).subscribe({
  //         next: (comment) => {
  //           this.selectedComment = comment;
  //         },
  //         error: (fail) => {
  //           this.router.navigateByUrl('Comment Not Found');
  //         }
  //       })
  //     }
  //   }
  // }

  displayComment(comment: Comment) {
    this.newComment = comment;
  }

  displayTable() {
    this.selected = null;
  }

  createComment(comment: Comment, tripId: number): void {
    this.auth.getLoggedInUser().subscribe((user) => {
      comment.user = user;
      comment.trip = this.selected;
      this.commentService.create(comment, tripId).subscribe({
        next: (madeComment) => {
          this.newComment = new Comment();
          if (this.selected) {

            this.reloadComment(this.selected.id);
          }
          },
          error: (fail) => {
            console.error('Error creating comment');
          },
        });

    });
  }

  setEditComment() {
    this.editComment = Object.assign({}, this.selectedComment);
  }

  updateComment(comment: Comment, tripId: number, goToDetail = true) {
    this.commentService.update(comment, tripId).subscribe({
      next: (updatedComment) => {
        this.editComment = null;

        if (goToDetail) {
          this.selectedComment = updatedComment;
        }
        this.reload();
      },
      error: (fail) => {
        console.error('Error updating comment');
        console.log(fail);
      },
    });
  }

  deleteComment(id: number, tripId: number) {
    console.log(tripId, id);
    this.commentService.destroy(id, tripId).subscribe({
      next: (result) => {
        this.reloadComment(tripId);
      },
      error: (fail) => {
        console.error('Error deleting comment');
        console.error(fail);
      },
    });
  }
  reloadComment(id: number) {
    this.commentService.index(id).subscribe({
      next: (retrievedComments) => {
        this.comments = retrievedComments;
      },
      error: (fail) => {
        console.error('Error getting comment list from service');
        console.error(fail);
      },
    });
  }

  reload() {
    this.getVehicles();
    this.getPastTrips();
    this.getCurrentTrips();
  }
}
