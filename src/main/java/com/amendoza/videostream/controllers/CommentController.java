package com.amendoza.videostream.controllers;

import com.amendoza.videostream.models.Comment;
import com.amendoza.videostream.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:4200")
public class CommentController {

    @Autowired
    private CommentService service;

    @GetMapping("/comment/{videoId}")
    public ResponseEntity<List<Comment>> getCommentsByVideo(@PathVariable Long videoId) {
        return new ResponseEntity<>(service.findByVideoId(videoId), HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(service.save(comment), HttpStatus.OK);
    }
}
