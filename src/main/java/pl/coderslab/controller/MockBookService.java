package pl.coderslab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.coderslab.object.Book;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/books")
public class MockBookService {
    private static Long nextId = 4L;
    private List<Book> list;

    //example of Books
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

//    @GetMapping(value = "/list", produces = "text/html; charset=utf-8")

    //    public String getBookList(Model model) {
//       model.addAttribute("list",list);
//       return "list";
//    }
    @GetMapping(value = "/list", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String getBookList() {
        return list.toString();
    }

    @GetMapping(value = "/list/{id}", produces = "text/html; charset")
    @ResponseBody
    public String showBookListById(@PathVariable Long id) {
        return list.get(Math.toIntExact(id - 1)).toString();
    }

    @RequestMapping(value = "/add", produces = "text/html; charset=utf-8")
    public String hello() {
        return "addBook";
    }

    @PostMapping(value = "/add", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String addBook(@RequestParam String isbn, @RequestParam String title,
                          @RequestParam String author, @RequestParam String publisher,
                          @RequestParam String type) {
        list.add(new Book(nextId++, isbn, title, author, publisher, type));
        String message = "Gratulacje, dodałeś książkę. Teraz możesz przejść na stronę, aby ją wyświetlić " +
                "<a href=\"http://localhost:8080/books/list\">Lista książek</a>";
        return message;
    }


    @DeleteMapping("list/{id}")
    public String removeBook(@PathVariable Long id) {
        list.remove(id);

        return list.toString();
    }

    @PutMapping("list/{id}")
    @ResponseBody
    public String updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (list.get(Math.toIntExact(id)) != null) {
            list.add(book);
        }
        return list.toString();
    }

    @PostMapping("list")
    @ResponseBody
    public String addBook2(@RequestBody Book book) {
        book.setId(nextId++);
        list.add(book);
        return list.toString();
    }
}
