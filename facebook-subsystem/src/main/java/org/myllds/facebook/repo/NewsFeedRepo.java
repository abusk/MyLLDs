package org.myllds.facebook.repo;

import org.myllds.facebook.exception.PageNotFoundException;
import org.myllds.facebook.model.Post;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewsFeedRepo {
    private final PostRepo postRepo;
    private final FollowerRepo followerRepo;
    public NewsFeedRepo(PostRepo postRepo, FollowerRepo followerRepo) {
        this.postRepo = postRepo;
        this.followerRepo = followerRepo;
    }

    public List<Integer> getAllNewsFeeds(int userId) {
        List<Post> allPosts = new ArrayList<>();
        List<Integer> allFollowees = followerRepo.getAllFollowees(userId);
        for (Integer followee : allFollowees) {
            List<Post> allPost = postRepo.getAllPost(followee);
            if(allPost == null) {
                continue;
            }
            allPosts.addAll(allPost);
        }
        return allPosts.stream().sorted(Comparator.comparingLong(Post::getTimeStamp)).map(post -> post.getPostId()).toList();
    }
    public List<Integer> getNewsFeedPaginated(int userId, int pageNumber, int pageSize) throws PageNotFoundException {
        List<Post> allPosts = new ArrayList<>();
        List<Integer> allFollowees = followerRepo.getAllFollowees(userId);
        for (Integer followee : allFollowees) {
            List<Post> allPost = postRepo.getAllPost(followee);
            allPosts.addAll(allPost);
        }
        List<Integer> sortedPosts = allPosts.stream().sorted(Comparator.comparingLong(Post::getTimeStamp)).map(post -> post.getPostId()).toList();
        if(sortedPosts.size() < (pageNumber-1) * pageSize) {
            throw new PageNotFoundException("Page not exists");
        }
        List<Integer> pagedPost = new ArrayList<>();
        int currentIndex = (pageNumber-1) * pageSize;
        int nextIndex = pageNumber * pageSize;
        int limit = Math.min(nextIndex, sortedPosts.size());
        for(int i = currentIndex; i < limit; i++) {
            pagedPost.add(sortedPosts.get(i));
        }
        return pagedPost;
    }
}
