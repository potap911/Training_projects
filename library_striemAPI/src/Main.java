import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;


public class Main {
    public static void main(String[] args) {

        // sorted() Сртировка
        Library library = new Library();

        List listSorted = library.getBooks().stream()
                .sorted(Comparator.comparing(Book::getIssueYear))
                .collect(Collectors.toList());

        // map() Извлечение объекта
        List<EmailAddress> addresses = library.getReaders().stream()
                .map(Reader::getEmail)
                .map(EmailAddress::new)
                .collect(Collectors.toList());

        // filter() Фильтр
        List<EmailAddress> addressesAgree = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmail).map(EmailAddress::new)
                .collect(Collectors.toList());

        // flatMap() преобразование и создания линейного списка
        List<Book> bookList = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        // anyMatch() подтверждение наличия элемента
        boolean match = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .allMatch(book -> "Оруэл".equals(book.getAuthor()));

        // reduce() сокращение стрима до одного параметра
        Integer reduce = library.getReaders().stream()
                .map(reader -> reader.getBooks().size())
                .reduce(0, (max, size) -> size > max ? size : max);

        // collect() + Collectors.groupingBy() и Collectors.mapping()
        Map<String, List<EmailAddress>> map = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(groupingBy(r -> r.getBooks().size() > 2 ? "TOO_MUCH" : "OK",
                        mapping(r -> new EmailAddress(r.getEmail()), Collectors.toList())));


        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR));

    }


}