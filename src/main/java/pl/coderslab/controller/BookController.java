package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.object.Book;
@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {


    @RequestMapping("/helloBook")
    public Book helloBook() {
        log.debug("new book object");
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

}
