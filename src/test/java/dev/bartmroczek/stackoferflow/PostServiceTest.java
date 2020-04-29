package dev.bartmroczek.stackoferflow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private  PostService postService;

    @Test
    void cretePost() {

        CommentRequest commentRequest = new CommentRequest();
        commentRequest.content = "First comment";

        PostRequest postRequest = new PostRequest();
        postRequest.titile = "First post";
        postRequest.conntent = "Post conntent";
        postRequest.commentRequest = commentRequest;

        postService.createPost(postRequest);
    }
}
