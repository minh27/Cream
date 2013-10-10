package com.example.CREAM;

/**
 * Created with IntelliJ IDEA.
 * User: Minh
 * Date: 9/10/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    private long id;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return comment;
    }
}
