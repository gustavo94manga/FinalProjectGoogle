import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  activeSlide = 0;
  // selected: Trip | null = null;

  prevSlide() {
    this.activeSlide = (this.activeSlide - 1 +5) % 5;
  }

  nextSlide() {
    this.activeSlide = (this.activeSlide + 1 + 5) % 5;
  }


}
