package pl.JerzyGajewski.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 200)
    String title;
    @ManyToOne
    private Author author;

    @OneToMany
    private List<Category> categoryList = new ArrayList<>();
    @Column(columnDefinition = "TEXT")
    String content;
@PrePersist
    public void created(){}
@PreUpdate
public void updated(){}
}
