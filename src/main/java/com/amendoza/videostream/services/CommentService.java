package com.amendoza.videostream.services;

import com.amendoza.videostream.models.Comment;
import com.amendoza.videostream.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> findByVideoId(Long videoId){
        return repository.findByVideoId(videoId);
    }

    public Comment save(Comment comment){
        return repository.save(comment);
    }

}
