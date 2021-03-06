package pl.JerzyGajewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.JerzyGajewski.dao.AuthorDao;
import pl.JerzyGajewski.entity.Author;
import pl.JerzyGajewski.service.interfaces.AuthorService;

@Service
@Primary
public class AuthorServiceDb implements AuthorService {

    private AuthorDao authorDao;

    @Autowired
    public AuthorServiceDb(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public void save(Author author) {
        this.authorDao.save(author);
    }

    @Override
    public Author findById(Long id) {
        return this.authorDao.findById(id);
    }

    @Override
    public void delete(Author author) {
        this.authorDao.delete(author);
    }
}
