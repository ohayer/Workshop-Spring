package pl.coderslab.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Book {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

}
