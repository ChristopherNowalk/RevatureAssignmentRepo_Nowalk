export class Movie {

    id :number | undefined;
    title :string | undefined;
    price :number | undefined;
    available :boolean | undefined;
    returnDate :number | undefined;
    directorId :number | undefined;
    genreId :number | undefined;

    constructor(id :number, title: string, price :number, available :boolean, returnDate :number, directorId :number, genreId :number) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.available = available;
        this.returnDate = returnDate;
        this.directorId = directorId;
        this.genreId = genreId;
    }

}