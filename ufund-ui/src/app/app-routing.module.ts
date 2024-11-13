import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { CupboardComponent } from './cupboard/cupboard.component';
import { CupboardDetailComponent } from './cupboard-detail/cupboard-detail.component';
import { SigninComponent } from './signin/signin.component';
//import { HomeComponent } from './home/home.component';
//import { CupboardComponent } from './cupboard/cupboard.component';
//import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { AdoptionComponent } from './adoption/adoption.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path: 'app', component: HomeComponent}, // HomeComponent instead of AppComponent
  {path: 'signin', component: SigninComponent},
  {path: 'cupboard', component: CupboardComponent},
  {path: 'forgotpassword', component: ForgotpasswordComponent},
  {path: 'adoption', component: AdoptionComponent},
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: CupboardDetailComponent },
  { path: 'needs', component: CupboardComponent },

  //{path: 'app', component: HomeComponent}, // HomeComponent instead of AppComponent (deprecated)
  //{path: 'cupboard', component: CupboardComponent},
  //{path: 'forgotpassword', component: ForgotpasswordComponent},
  {path: '', redirectTo: '/app', pathMatch: 'full'},
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
