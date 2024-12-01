import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {  FormGroup, ReactiveFormsModule , FormBuilder, Validators} from '@angular/forms';

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

  constructor(private fb: FormBuilder) {
    this.resetPasswordForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]]
    });
  }

  onSubmit(){
    if(this.resetPasswordForm.valid){
      const email = this.resetPasswordForm.value.email;
      alert(`A link has been sent to ${email}. Please follow the instruction in the email to reset your password.`);
      this.resetPasswordForm.reset();
    }
  }

  closeNotification(){
    this.message = null;
  }
}