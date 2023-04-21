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
    }

  })
}









}
