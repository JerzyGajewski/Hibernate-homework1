package pl.JerzyGajewski.service.interfaces;

import pl.JerzyGajewski.entity.Article;

public interface ArticleService {
    public void save(Article article);

    public Article findById(Long id);

    public void delete(Article article);
}
