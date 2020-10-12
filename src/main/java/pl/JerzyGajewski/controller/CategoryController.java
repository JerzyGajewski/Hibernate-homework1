package pl.JerzyGajewski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.JerzyGajewski.entity.Category;
import pl.JerzyGajewski.service.interfaces.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveCategory() {
        Category category = new Category();

        return "Category";
    }

    @PutMapping("/find/{id}")
    @ResponseBody
    public Category findById(Long id) {
        Category category = this.categoryService.findById(id);
        return category;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Category category = this.categoryService.findById(id);
        this.categoryService.delete(category);
        return "Deleted category";
    }


}
