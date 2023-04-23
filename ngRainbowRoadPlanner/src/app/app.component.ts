import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'ngRainbowRoadPlanner';
  lat = 39.6087;
  lng = -104.90271;
  map: any;

  @ViewChild('mapContainer', { static: false }) mapContainer!: ElementRef;

  constructor(private auth: AuthService) {}

  ngOnInit() {
    this.initMap();
  }

  initMap(): void {
    const mapOptions = {
      center: new google.maps.LatLng(this.lat, this.lng),
      zoom: 12,
    };
    this.map = new google.maps.Map(this.mapContainer.nativeElement, mapOptions);

    const marker = new google.maps.Marker({
      position: new google.maps.LatLng(this.lat, this.lng),
      map: this.map,
    });
  }
}
