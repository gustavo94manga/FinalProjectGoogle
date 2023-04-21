import { ProfileService } from './../../services/profile.service';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

user: User = new User();
selected: User | null = null;




constructor(
  private auth: AuthService,
  private route: ActivatedRoute,
  private router: Router,
  private profileService: ProfileService
){}









getUserInfo(){
  this.profileService.show().subscribe({
    next:(foundUser)=>{
     this.selected=foundUser;
     console.log(this.selected)
    },
    error:(fail)=>{
      console.log('ohh no');
    }
  })

}
















}
