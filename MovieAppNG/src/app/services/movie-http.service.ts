import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/Movie';

@Injectable({
  providedIn: 'root'
})
export class MovieHttpService {

  constructor(private http :HttpClient) { }

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllMovies() :Observable<Movie[]> {
    return this.http.get<Movie[]>('http://localhost:7000/movies');
  }

  addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>('http://localhost:7000/movies', movie, { headers :this.headers });
  }
}
