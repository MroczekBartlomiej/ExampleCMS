package dev.bartmroczek.stackoferflow;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue()
    private Long id;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Post post;

    public Comment() {
        System.out.println("Comment constructor executed.");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post students) {
        this.post = students;
    }
}