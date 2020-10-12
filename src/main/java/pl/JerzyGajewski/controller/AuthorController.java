package pl.JerzyGajewski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.JerzyGajewski.entity.Author;
import pl.JerzyGajewski.service.interfaces.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String save(){
        Author author = new Author();
        this.authorService.save(author);

        return "Author";
    }

    @PutMapping("/find/{id}")
    @ResponseBody
    public Author findById(Long id){
        Author author = this.authorService.findById(id);
        return author;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        Author author = this.authorService.findById(id);
        this.authorService.delete(author);

        return "Deleted Author";
    }
}
