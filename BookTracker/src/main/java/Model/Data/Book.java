package Model.Data;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public record Book(
        String Title,
        String Author,
        int Pagecount,
        Language language,
        EnumSet<Genre> Genre

) {
    public Book(String Title, String Author, int Pagecount, Language language, EnumSet<Genre> Genre) {
        this.Title = Title;
        this.Author = Author;
        this.Pagecount = Pagecount;
        this.language = language;
        this.Genre = Genre;
    }

    public Book(String title, String author, int pagecount, Language language) {
        this(title, author, pagecount, language, null);
    }

    public Book(String title, String author, int pagecount, EnumSet<Model.Data.Genre> genre) {
        this(title, author, pagecount, Language.EN, genre);
    }

    public Book(String title, String author, EnumSet<Model.Data.Genre> genre) {
        this(title, author, -1, Language.EN, genre);
    }

    public Book(Book oldBook, EnumSet<Genre> genre) {
        this(oldBook.Title, oldBook.Author, oldBook.Pagecount, oldBook.language, genre);
    }

    //TODO Stringbuilder
    @Override
    public String toString() {
        StringBuilder genreString = new StringBuilder();
        if(Genre != null){
            for (Genre g : Genre
            ) {
                if(genreString.length()>0) genreString.append(",");
                genreString.append(g.toString());
            }
        }
        return Title + "|" + Author + "|" + Pagecount + "|" + language + "|" + genreString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Title.equals(book.Title) && Author.equals(book.Author) && language == book.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Title, Author, language);
    }
}
