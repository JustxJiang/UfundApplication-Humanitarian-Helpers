import {Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { HomeComponent } from './home/home.component';
import { CupboardComponent } from './cupboard/cupboard.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { AdoptionComponent } from './adoption/adoption.component';

export const routes: Routes = [
  {path: 'app', component: HomeComponent}, // HomeComponent instead of AppComponent
  {path: 'signin', component: SigninComponent},
  {path: 'cupboard', component: CupboardComponent},
  {path: 'forgotpassword', component: ForgotpasswordComponent},
  {path: 'adoption', component: AdoptionComponent},
  {path: '', redirectTo: '/app', pathMatch: 'full'},
];
