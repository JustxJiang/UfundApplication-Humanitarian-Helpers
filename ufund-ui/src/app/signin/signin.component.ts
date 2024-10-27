import { Component } from '@angular/core';
import UserController}
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
  

  formSubmit:boolean = false;
  // submitting form 
  submitForm(form:NgForm){
    this.formSubmit = true

  }
}
