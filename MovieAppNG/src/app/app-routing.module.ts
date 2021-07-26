import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { MoviePageComponent } from './components/movie-page/movie-page.component';

const routes: Routes = [
  {path :'about', component: AboutComponent},
  {path :'contact', component :ContactUsComponent},
  {path :'movies', component :MoviePageComponent},
  {path :'', redirectTo: '/about', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
