package org.myllds.facebook.service;

import org.myllds.facebook.exception.NoFollowerFoundException;

public interface FollowService {
    void follow(int followerId, int followeeId);
    void unfollow(int followerId, int followeeId) throws NoFollowerFoundException;
}
