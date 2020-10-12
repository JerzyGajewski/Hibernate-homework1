package pl.JerzyGajewski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.JerzyGajewski.entity.Article;
import pl.JerzyGajewski.service.interfaces.ArticleService;

@Controller
@RequestMapping("/article")
public class AtricleController {
    private ArticleService articleService;

    @Autowired
    public AtricleController(ArticleService articleService) {
        this.articleService = articleService;
    }

@GetMapping("/add")
    @ResponseBody
public String saveArticle(){
        Article article = new Article();
this.articleService.save(article);

return "Article";
}

@PutMapping("/find/{id}")
    @ResponseBody
    public Article findById(Long id){
        Article article = this.articleService.findById(id);
        return article;
}

@DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(Long id){
        Article article = this.articleService.findById(id);
        this.articleService.delete(article);

        return "Delete Article";
}
}
