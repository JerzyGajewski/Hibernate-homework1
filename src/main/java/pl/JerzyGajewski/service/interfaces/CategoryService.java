package pl.JerzyGajewski.service.interfaces;

import pl.JerzyGajewski.entity.Category;

public interface CategoryService {
    public void save(Category category);

    public Category findById(Long id);

    public void delete(Category category);
}
