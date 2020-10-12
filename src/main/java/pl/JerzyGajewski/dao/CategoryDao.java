package pl.JerzyGajewski.dao;


import org.springframework.stereotype.Repository;
import pl.JerzyGajewski.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Category category){
        if(category.getId() == null){
            this.em.persist(category);
        }else this.em.merge(category);
    }

    public Category findById(Long id){
        Category category = this.em.find(Category.class, id);
        return category;
    }

    public void delete(Category category){
        this.em.remove(this.em.contains(category)? category : this.em.merge(category));
    }

}
