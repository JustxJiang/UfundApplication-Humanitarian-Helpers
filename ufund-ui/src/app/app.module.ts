import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule , ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';
//import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
// import { InMemoryDataService } from './in-memory-data.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CupboardDetailComponent } from './cupboard-detail/cupboard-detail.component';
import { CupboardComponent } from './cupboard/cupboard.component';
import { CupboardSearchComponent } from './cupboard-search/cupboard-search.component';
import { MessagesComponent } from './messages/messages.component';
import { SigninComponent } from './signin/signin.component';
import { HomeComponent } from './home/home.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
//import { AdoptionComponent } from './adoption/adoption.component';

@NgModule({ declarations: [
        AppComponent,
        CupboardComponent,
        CupboardDetailComponent,
        MessagesComponent,
        CupboardSearchComponent,
        //AdoptionComponent,
    ],
    bootstrap: [AppComponent],
    imports: [BrowserModule,
        HttpClientModule,
        FormsModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HomeComponent,
        SigninComponent,
        ForgotpasswordComponent,
        // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
        // and returns simulated server responses.
        // Remove it when a real server is ready to receive requests.
        // HttpClientInMemoryWebApiModule.forRoot(
        //   InMemoryDataService, { dataEncapsulation: false }
        // )
    ], providers: [provideHttpClient(withFetch())] })
export class AppModule { }