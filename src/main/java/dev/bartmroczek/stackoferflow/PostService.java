package dev.bartmroczek.stackoferflow;

import dev.bartmroczek.stackoferflow.PostResponse.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PostResponse> getPost() {

        return postRepository.findAll().stream()
                .map(this::mapToPostResponse)
                .collect(Collectors.toList());
    }

    private PostResponse mapToPostResponse(Post post) {

        PostResponse postResponse = new PostResponse();
        postResponse.id = post.getId();
        postResponse.titile = post.getTitle();
        postResponse.conntent = post.getContent();

        List<Comment> comments = post.getComments();
        postResponse.comments = comments.stream()
                .map(this::mapToCommentResponse)
                .collect(Collectors.toList());

        return postResponse;
    }

    private CommentResponse mapToCommentResponse(Comment comment) {

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.id = comment.getId();
        commentResponse.content = comment.getContent();
        commentResponse.post = new SimpleResponse(comment.getPost().getId(), comment.getPost().getTitle());
        return commentResponse;
    }
}
