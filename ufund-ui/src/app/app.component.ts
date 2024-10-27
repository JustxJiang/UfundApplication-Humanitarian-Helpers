import { Component } from '@angular/core';
import { NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SigninComponent } from './signin/signin.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { RouterModule} from '@angular/router';

@Component({
  selector: 'app-root',
  standalone : true,
  imports: [BrowserModule, SigninComponent,HomeComponent, RouterModule, AppRoutingModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ufund-ui';
}
