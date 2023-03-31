package pl.coderslab.object;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
    public Book() {}

}
