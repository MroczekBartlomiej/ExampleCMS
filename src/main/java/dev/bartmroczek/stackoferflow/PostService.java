package dev.bartmroczek.stackoferflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Long createPost(PostRequest postRequest) {

        Post post = new Post();
        Comment comment = new Comment();

        post.setTitle(postRequest.titile);
        post.setContent(postRequest.conntent);
        post.setComments(Collections.singletonList(comment));

        comment.setPost(post);
        comment.setContent(postRequest.commentRequest.content);

        return postRepository.save(post).getId();
    }


}
