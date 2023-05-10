import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {AngularFireModule} from "@angular/fire/compat";
import {environment} from "../environments/environment";
import {AngularFireStorageModule} from "@angular/fire/compat/storage";
import {AngularFireDatabaseModule} from "@angular/fire/compat/database";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { NewFeedComponent } from './new-feed/new-feed.component';
import {NgImageSliderModule} from "ng-image-slider";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NewFeedComponent
  ],
    imports: [
        ToastrModule.forRoot({
            timeOut: 100000,
            positionClass: 'toast-top-right',
            preventDuplicates: true,
        }),
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule,
        AngularFireStorageModule,
        AngularFireDatabaseModule,
        HttpClientModule,
        AngularFireModule.initializeApp(environment.firebaseConfig),
        ReactiveFormsModule,
        FormsModule,
        BrowserAnimationsModule,
        NgImageSliderModule,

    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
