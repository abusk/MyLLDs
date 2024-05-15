package org.myllds.facebook.repo;

import org.myllds.facebook.exception.NoFollowerFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FollowerRepo {
    private Map<Integer, List<Integer>> followeeToFollowers;
    private Map<Integer, List<Integer>> followerToFollowees;
    public FollowerRepo() {
        followeeToFollowers = new ConcurrentHashMap<>();
        followerToFollowees = new ConcurrentHashMap<>();
    }
    public void addFollow(int followerId, int followeeId) {
        List<Integer> followers = followeeToFollowers.getOrDefault(followeeId, new ArrayList<>());
        followers.add(followerId);
        followeeToFollowers.put(followeeId, followers);
        List<Integer> followees = followerToFollowees.getOrDefault(followerId, new ArrayList<>());
        followees.add(followeeId);
        followerToFollowees.put(followerId, followees);
    }

    public void removerFollow(int followerId, int followeeId) throws NoFollowerFoundException {
        List<Integer> followers = followeeToFollowers.getOrDefault(followeeId, new ArrayList<>());
        if (!followers.contains(followerId)) {
            throw new NoFollowerFoundException("No follower found!");
        }
        followers.remove(Integer.valueOf(followerId));
        followeeToFollowers.put(followeeId, followers);
        List<Integer> followees = followerToFollowees.getOrDefault(followerId, new ArrayList<>());
        followees.remove(Integer.valueOf(followeeId));
        followerToFollowees.put(followerId, followees);
    }

    public List<Integer> getAllFollowees(int followerId) {
        return followerToFollowees.get(followerId);
    }
}
