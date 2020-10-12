package pl.JerzyGajewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.JerzyGajewski.dao.CategoryDao;
import pl.JerzyGajewski.entity.Category;
import pl.JerzyGajewski.service.interfaces.CategoryService;

@Service
@Primary
public class CategoryServiceDb implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceDb(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void save(Category category) {
        this.categoryDao.save(category);
    }

    @Override
    public Category findById(Long id) {
        return this.categoryDao.findById(id);
    }

    @Override
    public void delete(Category category) {
        this.categoryDao.delete(category);
    }
}
