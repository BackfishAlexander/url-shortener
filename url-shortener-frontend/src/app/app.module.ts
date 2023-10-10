import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ShortenerComponent } from './shortener/shortener.component';

// Angular Material Imports:
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { RedirectComponent } from './redirect/redirect.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    ShortenerComponent,
    RedirectComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule, 
    MatToolbarModule,        
    MatInputModule,          
    MatButtonModule,        
    MatCardModule,
    HttpClientModule,
    AppRoutingModule        
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
