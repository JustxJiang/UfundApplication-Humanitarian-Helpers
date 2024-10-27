import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';

export const routes: Routes = [
  {path: 'app', component: AppComponent},
  {path: 'signin', component: SigninComponent},
  {path: '', redirectTo: '/app,', pathMatch: 'full'},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
