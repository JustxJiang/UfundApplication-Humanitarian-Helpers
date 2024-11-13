import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {  FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  standalone: true,
  imports:[ReactiveFormsModule, CommonModule],
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent {
  resetPasswordForm!: FormGroup;
  message: string | null= null;
  
  onSubmit(){
    if(this.resetPasswordForm.valid){
      const email = this.resetPasswordForm.value.email;
      this.message = `A link has been sent to your ${email} Please follow the instruction in the email to reset your password.`;
      this.resetPasswordForm.reset();
    }
  }
}