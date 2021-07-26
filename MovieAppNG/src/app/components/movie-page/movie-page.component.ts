import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { MovieHttpService } from 'src/app/services/movie-http.service';
import { Movie } from '../../models/Movie';

@Component({
  selector: 'app-movie-page',
  templateUrl: './movie-page.component.html',
  styleUrls: ['./movie-page.component.css']
})
export class MoviePageComponent implements OnInit {

  constructor(private movieHttp :MovieHttpService) { }

  ngOnInit(): void {
  }

  fakeMovieList :Array<any> = [
    {"id":1, "title":"The Avengers", "price":5.00, "availabile":true, "returnDate":0},
    {"id":2, "title":"Black Widow", "price":30.00, "availabile":true, "returnDate":0}
  ]

  movieList :Movie[] = [];
  title :string = "";
  price :number = 0;
  available: boolean = true;

  displayAllMovies() {

    this.movieHttp.getAllMovies().subscribe(
      (response) => {
        console.log(response);
        this.movieList = response;
      }
    );

  }

  addMovie() {

    console.log(this.title);
    console.log(this.price);
    console.log(this.available);

    this.movieHttp.addMovie(new Movie(0, this.title, this.price, this.available, 0, 0, 0)).subscribe(
     (response) => {
       console.log(response);
       this.movieList.push(response);
     }
    );
  }
}
