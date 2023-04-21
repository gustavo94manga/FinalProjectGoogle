import { Trip } from 'src/app/models/trip';
import { Component } from '@angular/core';
import { User } from 'src/app/models/user';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  viewRoadtrips: boolean = false;
  selected: Trip | null = null;
  activeSlide = 0;
  user: User = new User;
  selectedUser: User | null = null;
  trips: Trip[] = [];
  private tripService tripServ;

  // selected: Trip | null = null;

  prevSlide() {
    this.activeSlide = (this.activeSlide - 1 +5) % 5;
  }

  nextSlide() {
    this.activeSlide = (this.activeSlide + 1 + 5) % 5;
  }


  displayTripImages(tripImage: Trip) {
    this.selected = tripImage;
  }

  displayAllRoadtrips(){
    this.tripServ.displayAllTrips();
  }



}
