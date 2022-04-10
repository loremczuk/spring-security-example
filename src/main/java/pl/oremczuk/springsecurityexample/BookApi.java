package pl.oremczuk.springsecurityexample;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookApi {

    private List<Book> bookList;

    public BookApi () {
        bookList = new ArrayList<>();
        bookList.add(new Book("W pustyni i w puszczy","Henryk Sienkiewicz"));
        bookList.add(new Book("Pan Tadeusz", "Adam Mickiewicz"));

    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookList;
    }

    @PostMapping("/books")
    public boolean addBooks(@RequestBody Book book) {

        return bookList.add(book);

    }

    @DeleteMapping("/books")
    public void deleteBook (@RequestParam int index) {
        bookList.remove(index);
    }

}
