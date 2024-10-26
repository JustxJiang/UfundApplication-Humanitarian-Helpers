import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
  

  formsubmit:boolean = false;
  // submitting form 
  submitForm(form:NgForm){
    this.formsubmit = true;
    if(form.valid){
    }
  }
}
