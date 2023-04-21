import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';
import { Destination } from '../models/destination';

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

//private baseUrl = 'http://localhost:8090/'; // adjust port to match server
private url = environment.baseUrl + 'api/destinations';

constructor(private http: HttpClient, private auth: AuthService) { }


getHttpOptions() {
  let options = {
    headers: {
      Authorization: 'Basic ' + this.auth.getCredentials(),
      'X-Requested-With': 'XMLHttpRequest',
    },
  };
  return options;
}




show():Observable<Destination[]>{
  return this.http.get


}








}
