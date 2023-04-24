import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trip } from 'src/app/models/trip';
import { AuthService } from 'src/app/services/auth.service';
import { TripService } from 'src/app/services/trip.service';
import { FormControl } from '@angular/forms';
import {
  MapDirectionsService,
  MapGeocoder,
  MapInfoWindow,
  MapMarker,
} from '@angular/google-maps';
import { Address } from 'src/app/models/address';
import { Destination } from 'src/app/models/destination';
import { GeoResultToAddressPipe } from 'src/app/pipes/geo-result-to-address.pipe';
import { DestinationService } from 'src/app/services/destination.service';
import { AddressService } from 'src/app/services/address.service';
import { Vehicle } from 'src/app/models/vehicle';
import { VehicleService } from 'src/app/services/vehicle.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css'],
})
export class TripComponent implements OnInit {
  selected: Trip | null = null;
  newTrip: Trip = new Trip();
  vehicle: Vehicle[] = [];
  trips: Trip[] = [];
  currentTrips: Trip[] = [];
  pastTrips: any[] = [];
  map: any;
  lat = 39.6087;
  lng = -104.90271;
  directions: Observable<google.maps.DirectionsResult | undefined> | null =
    null;

  @ViewChild('mapContainer', { static: false }) mapContainer!: ElementRef;
  @ViewChild(MapInfoWindow, { static: false }) infoWindow!: MapInfoWindow;
  @ViewChild(MapMarker, { static: false }) marker!: MapMarker;

  public origin!: google.maps.LatLngLiteral;
  public destination!: google.maps.LatLngLiteral;
  public directionsService = new google.maps.DirectionsService();
  public directionsRenderer!: google.maps.DirectionsRenderer;

  public startDestination: google.maps.LatLngLiteral | null = null;
  public endDestination: google.maps.LatLngLiteral | null = null;

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
    private directionService: MapDirectionsService
  ) {
    // this.newTrip.roundTrip = '';
    // this.newTrip.vehicle = '';
  }

  ngOnInit() {
    {
      this.getVehicles();
      this.getPastTrips();
      this.getCurrentTrips();
      // this.initMap();
      this.directionsRenderer = new google.maps.DirectionsRenderer();
    }
  }

  getSingleTripById(id: number) {
    this.tripService.getSingleTrip(id).subscribe((trip) => {
      this.selected = trip;
    });
  }

  getVehicles(): void {
    this.vehicleService.getVehicles().subscribe((vehicle) => {
      console.log(vehicle);
      this.vehicle = vehicle;
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
    let lat = mapEvent.latLng!;
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
                  this.startDestination = { lat: lat.lat(), lng: lat.lng() };
                },
              });
            } else if (this.newTrip.endDestination == null) {
              this.destService.create(dest).subscribe({
                next: (madeDest) => {
                  this.newTrip.endDestination = madeDest;
                  // Get directions here
                  this.endDestination = { lat: lat.lat(), lng: lat.lng() };
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

  renderRoute() {
    if (this.startDestination && this.endDestination) {
      this.directionsService.route(
        {
          origin: this.startDestination,
          destination: this.endDestination,
          travelMode: google.maps.TravelMode.DRIVING,
        },
        (response, status) => {
          if (status === 'OK') {
            this.directionsRenderer.setDirections(response);
            this.directionsRenderer.setMap(this.map);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        }
      );
    }
  }

  // initMap(): void {
  //   const mapOptions = {
  //     center: new google.maps.LatLng(this.lat, this.lng),
  //     zoom: 8,
  //   };
  //   this.map = new google.maps.Map(this.mapContainer.nativeElement, mapOptions);

  //   const marker = new google.maps.Marker({
  //     position: new google.maps.LatLng(this.lat, this.lng),
  //     map: this.map,
  //   });
  // }
}
