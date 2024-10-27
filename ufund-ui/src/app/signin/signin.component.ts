import { Component } from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms'

@Component({
  selector: 'app-signin',
  standalone: true,
  imports:[],
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
