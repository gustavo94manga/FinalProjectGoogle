import { Trip } from 'src/app/models/trip';
import { Component } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  selected: Trip | null = null;
  activeSlide = 0;

  prevSlide() {
    this.activeSlide = (this.activeSlide - 1 +5) % 5;
  }

  nextSlide() {
    this.activeSlide = (this.activeSlide + 1 + 5) % 5;
  }

  displayTripImages(tripImage: Trip) {
    this.selected = tripImage;
  }


}
