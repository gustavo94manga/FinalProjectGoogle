import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { SignupComponent } from '../signup/signup.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  isCollapsed = false;

  constructor(private modalService: NgbModal, private auth: AuthService) {}

  showSignupModal() {
    const modalRef = this.modalService.open(SignupComponent);
  }

  loggedIn(): boolean {
    return this.auth.checkLogin();
  }
}
