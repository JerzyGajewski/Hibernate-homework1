package pl.JerzyGajewski.dao;


import org.springframework.stereotype.Repository;
import pl.JerzyGajewski.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Author author){
        if(author.getId() == null){
            this.em.persist(author);
        }else this.em.merge(author);
    }

    public Author findById(Long id){
        Author author = this.em.find(Author.class, id);
        return author;
    }
    public void delete(Author author){
        this.em.remove(this.em.contains(author) ? author : this.em.merge(author));
    }
}
