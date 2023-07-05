import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        init();
    }
    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Оруэл", "1984", 2021));
        books.add(new Book("Булгаков", "Мастер и Маргарита", 1991));
        books.add(new Book("Пушкин", "Руслан и Людмила", 1812));



        readers = new ArrayList<>();
        readers.add(new Reader("Иванов Иван Иванович", "ivanov.email@test.ru", true));
        readers.add(new Reader("Потапенко Никита Павлович", "potap.nickit@yandex.ru", false));

        readers.get(0).getBooks().add(books.get(1));
        readers.get(0).getBooks().add(books.get(1));
        readers.get(1).getBooks().add(books.get(1));

    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}
