package org.myllds.facebook.service.impl;

import org.myllds.facebook.exception.PageNotFoundException;
import org.myllds.facebook.repo.NewsFeedRepo;
import org.myllds.facebook.service.NewsFeedService;

import java.util.List;

public class NewsFeedServiceImpl implements NewsFeedService {

    private final NewsFeedRepo newsFeedRepo;

    public NewsFeedServiceImpl(NewsFeedRepo newsFeedRepo) {
        this.newsFeedRepo = newsFeedRepo;
    }

    @Override
    public List<Integer> getNewsFeed(int userId) {
        return newsFeedRepo.getAllNewsFeeds(userId);
    }

    @Override
    public List<Integer> getNewsFeedPaginated(int userId, int pageNumber) throws PageNotFoundException {
        return newsFeedRepo.getNewsFeedPaginated(userId, pageNumber, 20);
    }
}
