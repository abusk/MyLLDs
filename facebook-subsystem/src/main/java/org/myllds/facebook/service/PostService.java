package org.myllds.facebook.service;

public interface PostService {
    void post(int uerId, int postId);
    void deletePost(int userId, int postId);
}
