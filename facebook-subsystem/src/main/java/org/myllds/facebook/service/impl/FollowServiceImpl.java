package org.myllds.facebook.service.impl;

import org.myllds.facebook.exception.NoFollowerFoundException;
import org.myllds.facebook.repo.FollowerRepo;
import org.myllds.facebook.service.FollowService;

public class FollowServiceImpl implements FollowService {

    private final FollowerRepo followerRepo;

    public FollowServiceImpl(FollowerRepo followerRepo) {
        this.followerRepo = followerRepo;
    }

    @Override
    public void follow(int followerId, int followeeId) {
        followerRepo.addFollow(followerId, followeeId);
    }

    @Override
    public void unfollow(int followerId, int followeeId) throws NoFollowerFoundException {
        followerRepo.removerFollow(followerId, followeeId);
    }
}
