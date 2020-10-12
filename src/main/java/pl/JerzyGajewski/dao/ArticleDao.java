package pl.JerzyGajewski.dao;

import org.springframework.stereotype.Repository;
import pl.JerzyGajewski.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDao {
@PersistenceContext
    private EntityManager em;


public void save(Article article){
if(article.getId() == null){
    this.em.persist(article);
}else this.em.merge(article);
}
public Article findById(Long id){
    Article article = this.em.find(Article.class, id);
    return article;
}

public void delete(Article article){
this.em.remove(this.em.contains(article) ? article : this.em.merge(article));
}


}
