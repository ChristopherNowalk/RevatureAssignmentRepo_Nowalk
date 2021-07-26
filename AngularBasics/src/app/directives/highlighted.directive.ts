import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlighted]'
})
export class HighlightedDirective {

  constructor(el :ElementRef) {
    el.nativeElement.style.backgroundColor = "yellow";
  }

}
