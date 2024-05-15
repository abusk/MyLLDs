package org.myllds.facebook.service;

import org.myllds.facebook.exception.PageNotFoundException;

import java.util.List;

public interface NewsFeedService {
    List<Integer> getNewsFeed(int userId);
    List<Integer> getNewsFeedPaginated(int userId, int pageNumber) throws PageNotFoundException;
}
