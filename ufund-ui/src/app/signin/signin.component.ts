import { Component } from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms'
import { CommonModule } from '@angular/common';
import { RouterModule, Router} from '@angular/router';

@Component({
  selector: 'app-signin',
  standalone: true,
  imports:[CommonModule, FormsModule, RouterModule],
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
  // Added some fields to temp hold necessary data
  username: string = '';
  password : string = '';
  showPassword:boolean = false;
  isAdmin: boolean = false;
  isLoggedIn: boolean = false;

  constructor(private router: Router) {}

  togglePasswordVisbility():void{
    this.showPassword = !this.showPassword;
  }
  formSubmit:boolean = false;
  // submitting form 
  submitForm(form:any){

    // Here we set the object types collected by the form
    const {username, password} = form.value;

    // Some simple logic to conver the username to lowercase, and check if
    // the user logging in is the admin account
    if (username.toLowerCase() === "admin" && password === "admin") {
      // We can then set these fields to true if so
      this.isAdmin = true;
      this.isLoggedIn = true;
      // Page alert to let you know the login was successful
      alert("Admin has logged in!")
      // Redirect the user to a page
      this.router.navigate(['/needs']);
    }

    else {
      // Applies to all helpers
      // Will receive the non-admin flair
      this.isAdmin = false;
      this.isLoggedIn = true;
      // Page alert
      alert("Helper has logged in.")
      // Sends directly to the helper "portal"
      this.router.navigate(['/needs']);
    }
  }
}
