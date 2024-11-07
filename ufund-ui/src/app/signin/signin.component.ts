import { Component } from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms'
import { CommonModule } from '@angular/common';
import { RouterModule} from '@angular/router';

@Component({
  selector: 'app-signin',
  standalone: true,
  imports:[CommonModule, FormsModule, RouterModule],
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
  password : string = '';
  showPassword:boolean = false;

  togglePasswordVisbility():void{
    this.showPassword = !this.showPassword;
  }
  formSubmit:boolean = false;
  // submitting form 
  submitForm(form:NgForm){
    this.formSubmit = true
  }
}
