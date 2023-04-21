import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trip } from 'src/app/models/trip';
import { AuthService } from 'src/app/services/auth.service';
import { TripService } from 'src/app/services/trip.service';

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent {


selected: Trip | null = null;
newTrip: Trip = new Trip();



constructor(private tripService: TripService,
  private auth: AuthService,
  private route: ActivatedRoute,
  private router: Router,){

}


createTrip(trip: Trip){
  this.tripService.create(trip).subscribe({
    next:(madeTrip)=>{
      this.selected=madeTrip;
      console.log(madeTrip)
    },
    error: (failure) => {
      console.error('Error create trip');
      console.error(failure);
    }

  })
}

updateTrip(trip: Trip){
  this.tripService.update(trip).subscribe({
    next:(updated)=>{
    this.selected=updated;
    },
    error: (failure) => {
      console.error('Error update trip');
      console.error(failure);
    }
  })
}









}
