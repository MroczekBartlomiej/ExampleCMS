package dev.bartmroczek.stackoferflow;

import dev.bartmroczek.stackoferflow.PostResponse.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void findAllPost() {

        List<PostResponse> post = postService.getPost();
    }
}
