import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-create-account',
  standalone: true,
  imports: [],
  templateUrl: './create-account.component.html',
  styleUrl: './create-account.component.css'
})
export class CreateAccountComponent {
  password : string = '';

  formSubmit:boolean = false;
  // submitting form 
  submitForm(form:NgForm){
    this.formSubmit = true
  }
}
