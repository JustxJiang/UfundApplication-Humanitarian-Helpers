import { Component } from '@angular/core';
import {  FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-forgotpassword',
  standalone: true,
  imports: [ReactiveFormsModule,NgIf],
  templateUrl: './forgotpassword.component.html',
  styleUrl: './forgotpassword.component.css'
})
export class ForgotpasswordComponent {
  restPasswordForm!: FormGroup;
  message: string | null= null;
  
  onSubmit(){
    if(this.restPasswordForm.valid){
      const email = this.restPasswordForm.value.email;
      this.message = `A link has been sent to your ${email} Please follow the instruction in the email to reset your password.`;
      this.restPasswordForm.reset();
    }
  }
}