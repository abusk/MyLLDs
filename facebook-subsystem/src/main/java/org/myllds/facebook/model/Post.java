package org.myllds.facebook.model;

public class Post {
    private int postId;
    private long timeStamp;
    public Post(int postId) {
        this.postId = postId;
        this.timeStamp = System.currentTimeMillis();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
