import { ProfileService } from './../../services/profile.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Trip } from 'src/app/models/trip';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { TripService } from 'src/app/services/trip.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{

user: User = new User();
selected: User | null = null;
username: string ='';
editUser: User | null = null;
userTrip: Trip | null = null;


constructor(
  private auth: AuthService,
  private route: ActivatedRoute,
  private router: Router,
  private profileService: ProfileService,
  private tripService: TripService
){}

ngOnInit(): void {
  //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
  //Add 'implements OnInit' to the class.
  this.getLoggedInUserInfo();
  this.showUserTrips();
}

reload(){
this.getLoggedInUserInfo();
this.editUser=null;


}

showUserTrips(){
  this.profileService.getUserTrips().subscribe({
    next:(trips)=>{
      if(this.selected !=null){
        this.selected.trips=trips;
      }
    }
  })
}


getSingleTripById(id: number) {
  this.tripService.getSingleTrip(id).subscribe((trip) =>{

  });
}


getLoggedInUserInfo(){
   this.auth.getLoggedInUser().subscribe({
    next:(foundUser)=>{
      this.username =foundUser.username;
      console.log(this.selected)
      this.profileService.show(this.username).subscribe({
        next:(foundUser)=>{
         this.selected=foundUser;
          console.log(this.selected)
          this.profileService.getUserTrips().subscribe({
            next:(trips)=>{
              if(this.selected !=null){
                this.selected.trips=trips;
              }
            }
          })
        },
        error:(fail)=>{
          console.log('ohh no');
        }
      })
     },
     error:(fail)=>{
       console.log('ohh no');
     }
   });
}

setEditUser(){
  this.editUser = Object.assign({}, this.selected)
}
cancelEdit(){
  this.editUser=null;

}

editProfile(user:User){
  this.profileService.update(user).subscribe({
    next: (user) =>{
      // console.log(user)

      this.reload();
    },
    error: (failure) => {
      console.error('Error getting edit prifile');
      console.error(failure);
    }
})
}














}
