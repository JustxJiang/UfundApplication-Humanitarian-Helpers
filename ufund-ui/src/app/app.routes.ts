import {Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
  {path: 'app', component: HomeComponent}, // HomeComponent instead of AppComponent
  {path: 'signin', component: SigninComponent},
  {path: '', redirectTo: '/app', pathMatch: 'full'},
];
