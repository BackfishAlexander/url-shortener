import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShortenerComponent } from './shortener/shortener.component'; 
import { RedirectComponent } from './redirect/redirect.component';

const routes: Routes = [
  { path: '', component: ShortenerComponent },
  { path: ':id', component: RedirectComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
