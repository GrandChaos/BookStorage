package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookStorage storage;

    @GetMapping("/books")
    public String bookForm(Model model) {
            model.addAttribute("empty", storage.isEmpty());
            model.addAttribute("books", storage.getBooks());
        return "books";
    }

    @GetMapping("books/add")
    public String bookAdd(Model model) {
        model.addAttribute("book", new TempBook("", "",""));
        return "add";
    }

    @PostMapping("/books/add")
    public String bookAdd(@ModelAttribute TempBook book, Model model){
        model.addAttribute("book", book);
        storage.add(book.getName(), book.getAuthor(), book.getYear());
        return "add";
    }

    @RequestMapping("books/del")
    public String bookDel(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model){
        model.addAttribute("books", storage.getBooks());
        storage.delete(id);
        return "del";
    }
}
