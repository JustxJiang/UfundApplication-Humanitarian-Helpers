import {Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { HomeComponent } from './home/home.component';
import { CupboardComponent } from './cupboard/cupboard.component';

export const routes: Routes = [
  {path: 'app', component: HomeComponent}, // HomeComponent instead of AppComponent
  {path: 'signin', component: SigninComponent},
  {path: '/cupboard', component: CupboardComponent},
  {path: '', redirectTo: '/app', pathMatch: 'full'},
];
