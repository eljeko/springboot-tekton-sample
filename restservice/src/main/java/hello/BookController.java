package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RestController
public class BookController {


    @RequestMapping("/")
    public String index() {
        return "Default: Greetings from Book Service";
    }

    @CrossOrigin
    @RequestMapping(value = "/books",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Book> books() {
        List<Book> books = new ArrayList<Book>();

        books.add(new Book(1, "The Lord of The rings", "The Lord of the Rings by J.R.R. Tolkien tells the story of the War of the Ring in the fictional world of Middle-earth.", "J.R.R. Tolkien", 20));
        books.add(new Book(2, "2001: A Space Odyssey", "2001: A Space Odyssey. In the beginning of the novel, the early ancestors of humans encounter the monolith on Earth. After they interact with the monolith, their intelligence, or at least their way of thinking, takes a leap. They begin to develop tools, which let them move up the food chain.", " Arthur C. Clarke", 25));
        books.add(new Book(3, "Dune", "Dune is set in the distant future amidst a feudal interstellar society in which various noble houses control planetary fiefs. It tells the story of young Paul Atreides, whose family accepts the stewardship of the planet Arrakis.", "Frank Herbert", 23));
        books.add(new Book(4, "Title", "Description", "The Author", 32));
        return books;
    }

}