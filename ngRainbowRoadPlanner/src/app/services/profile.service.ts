

import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { User } from '../models/user';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

//private baseUrl = 'http://localhost:8090/'; // adjust port to match server
private url = environment.baseUrl + 'api/users/';

constructor(private http: HttpClient, private datePipe: DatePipe, private auth: AuthService) { }

username ='admin';


getHttpOptions() {
  let options = {
    headers: {
      Authorization: 'Basic ' + this.auth.getCredentials(),
      'X-Requested-With': 'XMLHttpRequest',
    },
  };
  return options;
}

show():Observable <User>{
return this.http.get<User>(this.url+this.username, this.getHttpOptions() ).pipe(
  catchError((err: any) => {
    console.log(err);
    return throwError(
      () => new Error('ProfileSrvc(): error retrieving User: ' + err)
    );
  })
);


}













}
