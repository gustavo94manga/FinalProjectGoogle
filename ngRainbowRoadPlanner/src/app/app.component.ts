import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ngRainbowRoadPlanner';
  lat = 51.678418;
  lng = 7.809007;

  constructor(private auth: AuthService) {}
  ngOnInit() {
    // DELETE LATER!!!
  }
}
