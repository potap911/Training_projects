import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String fio;
    private String email;
    private boolean subscriber;
    private List<Book> books;

    public Reader(String fio, String email, boolean subscriber) {
        this.fio = fio;
        this.email = email;
        this.subscriber = subscriber;
        this.books = new ArrayList<>();
    }

    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }

    public boolean isSubscriber() {
        return subscriber;
    }

    public List<Book> getBooks() {
        return books;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Reader reader = (Reader) o;
        return fio.equals(reader.fio);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
