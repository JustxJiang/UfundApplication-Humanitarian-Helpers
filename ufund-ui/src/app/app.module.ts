import { NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';  // Adjust the path if necessary
import { SigninComponent } from './signin/signin.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,  // Declare your root component
    HomeComponent,
    SigninComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],  // Bootstrap your root component
})
export class AppModule { }