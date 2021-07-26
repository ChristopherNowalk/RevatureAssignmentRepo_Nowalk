import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    setInterval(() => {
      this.currentTime = Date.now();
    }, 1)
  }

  money :number | undefined;
  time :number | undefined;

  currentTime: number | undefined;

}
