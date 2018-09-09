package lukaszSolarski.springframework.spring5webapp.controllers;

import lukaszSolarski.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
Controller gets the data model and can pass it to the view.
It's Strping bean now
 */
@Controller
public class BookController {

    private BookRepository bookRepository;

    /*
    This constructor makes that spring will auto wire BookRepository in for automatically
     */
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /*
    Method will be invoked when you type in url [app_url]/books
    Spring MVC is going to pass an instance of the model
    Adds attribute "books" to the model and it will contain all books. Books will be get from database using Hibernate
     */
    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());

        //it tells Spring MVC to associate this method with "books" view
        return "books";
    }
}
