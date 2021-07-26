import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'My Angular Basics';
  //this is interplation ex: we are making a variable here
  hello :string = "Hello World";
  website :string = "https://www.google.com/";
  url :string = "";
  endpoint :string = "";
  showParagraph :boolean = false;
  superSmashCharacters :Array<string> = ["Fox","Samus","Link","Peach","Zelda"];

  newCharacter :string = "";
  showError :boolean = false;

  //we are making a function here 
  testFunction() {
    console.log("Tested calling a function");
    this.hello += " to Everyone!"
  }

  saySomething() {
    this.hello = (this.hello == "Hello World") ? "Goodbyte World" : "Hello World";
  }

changeWebsite() {
  this.website = (this.website == "https://www.google.com/") ? "https://www.reddit.com/" : "https://www.google.com/";
}

setEndpoint() {
  this.endpoint = "http://www." + this.url + ".com/"
}

setUrl() {
  this.url = "google"
  this.setEndpoint();
}

toggleText() {
  this.showParagraph = !this.showParagraph;
}

addCharacter() {
  //the this.newCharacter works because an empty string is a falsy value
  if(this.newCharacter && !this.superSmashCharacters.includes(this.newCharacter)) {
    this.superSmashCharacters.push(this.newCharacter);
    this.clearText();  
  } else if(this.newCharacter) {
    this.showError = true;
    alert("Character already in list!");
  }

}

clearText() {
  this.newCharacter = "";
  this.showError = false;
}

removeCharacter() {
  this.superSmashCharacters.pop();
}

clearAll() {
  this.superSmashCharacters = [];
}

deleteCharacter(character :string) {
  let index :number = this.superSmashCharacters.indexOf(character);

  if(index > -1) {
    this.superSmashCharacters.splice(index , 1);
  }
}

}
