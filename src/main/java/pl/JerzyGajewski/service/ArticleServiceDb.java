package pl.JerzyGajewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.JerzyGajewski.dao.ArticleDao;
import pl.JerzyGajewski.entity.Article;
import pl.JerzyGajewski.service.interfaces.ArticleService;

@Service
@Primary
public class ArticleServiceDb implements ArticleService {
    private ArticleDao articleDao;


    @Autowired
    public ArticleServiceDb(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void save(Article article) {
        this.articleDao.save(article);
    }

    @Override
    public Article findById(Long id) {
        return this.articleDao.findById(id);
    }

    @Override
    public void delete(Article article) {
        this.articleDao.delete(article);
    }
}
