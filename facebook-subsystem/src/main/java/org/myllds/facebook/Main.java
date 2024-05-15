package org.myllds.facebook;

import org.myllds.facebook.exception.NoFollowerFoundException;
import org.myllds.facebook.exception.PageNotFoundException;
import org.myllds.facebook.repo.FollowerRepo;
import org.myllds.facebook.repo.NewsFeedRepo;
import org.myllds.facebook.repo.PostRepo;
import org.myllds.facebook.service.FollowService;
import org.myllds.facebook.service.NewsFeedService;
import org.myllds.facebook.service.PostService;
import org.myllds.facebook.service.impl.FollowServiceImpl;
import org.myllds.facebook.service.impl.NewsFeedServiceImpl;
import org.myllds.facebook.service.impl.PostServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws NoFollowerFoundException, PageNotFoundException {
        PostRepo postRepo = new PostRepo();
        PostService postService = new PostServiceImpl(postRepo);
        postService.post(11, 111);
        postService.post(22, 222);
        postService.post(22, 333);
        postService.post(33, 444);
        postService.post(33, 555);
        postService.post(44, 666);
        postService.post(55, 777);

        FollowerRepo followerRepo = new FollowerRepo();
        FollowService followService = new FollowServiceImpl(followerRepo);
        followService.follow(11, 22);
        followService.follow(22, 33);
        followService.follow(22, 11);
        followService.follow(22, 44);
        followService.follow(22, 55);
        followService.follow(33, 22);
        followService.follow(33, 55);
        followService.follow(33, 11);
        followService.unfollow(33, 22);

        NewsFeedRepo newsFeedRepo = new NewsFeedRepo(postRepo, followerRepo);
        NewsFeedService newsFeedService = new NewsFeedServiceImpl(newsFeedRepo);
        List<Integer> newsFeed = newsFeedService.getNewsFeed(33);
        System.out.println("All news feed for user : [33] :" + newsFeed.toString());
        List<Integer> newsFeedPaginated = newsFeedService.getNewsFeedPaginated(33, 1);
        System.out.println("All paginated news feed for user : [33] :" + newsFeedPaginated.toString());
    }
}