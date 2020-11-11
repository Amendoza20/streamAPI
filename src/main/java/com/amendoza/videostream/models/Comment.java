package com.amendoza.videostream.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;
    private String text;
    private Long userId;
    private Date date;
    private Long videoId;

    public Comment() {
    }

    public Comment(Long id, String text, Long userId, Date date, Long videoId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.date = date;
        this.videoId = videoId;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
}
