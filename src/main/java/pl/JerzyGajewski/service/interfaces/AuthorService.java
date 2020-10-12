package pl.JerzyGajewski.service.interfaces;

import pl.JerzyGajewski.entity.Author;

public interface AuthorService {
    public void save(Author author);

    public Author findById(Long id);

    public void delete(Author author);
}
