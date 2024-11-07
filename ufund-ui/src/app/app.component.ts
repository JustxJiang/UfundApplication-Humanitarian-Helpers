import { Component } from '@angular/core';
import { SigninComponent } from './signin/signin.component';
import { HomeComponent } from './home/home.component';
import { CupboardComponent } from './cupboard/cupboard.component';
import { RouterModule} from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone : true,
  imports: [CommonModule, SigninComponent,HomeComponent, CupboardComponent, RouterModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ufund-ui';
}
