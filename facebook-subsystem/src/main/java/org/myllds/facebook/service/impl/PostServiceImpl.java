package org.myllds.facebook.service.impl;

import org.myllds.facebook.model.Post;
import org.myllds.facebook.repo.PostRepo;
import org.myllds.facebook.service.PostService;

public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public void post(int uerId, int postId) {
        Post post = new Post(postId);
        postRepo.addPost(uerId, post);
    }

    @Override
    public void deletePost(int userId, int postId) {
    }
}
