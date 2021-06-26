package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookStorage storage;

    @GetMapping(value = "/books")
    public String BookForm(Model model) {
        model.addAttribute("books", storage.get());
        return "books";
    }
}
