package org.myllds.facebook.repo;

import org.myllds.facebook.exception.PostNotFoundException;
import org.myllds.facebook.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostRepo {
    private Map<Integer, List<Post>> userPosts;
    public PostRepo() {
        this.userPosts = new ConcurrentHashMap<>();
    }
    public void addPost(int userId, Post post) {
        List<Post> posts = userPosts.getOrDefault(userId, new ArrayList<>());
        posts.add(post);
        userPosts.put(userId, posts);
    }

    public List<Post> getAllPost(int userId) {
        return userPosts.get(userId);
    }

    public void deletePost(int usertId, int postId) throws PostNotFoundException {
        List<Post> posts = userPosts.get(usertId);
        Post foundPost = null;
        for (Post post : posts) {
            if (postId == post.getPostId()) {
                foundPost = post;
            }
        }
        if(foundPost == null) {
            throw new PostNotFoundException("Post not found to delete");
        }
        posts.remove(foundPost);
        userPosts.put(usertId, posts);
    }
}
