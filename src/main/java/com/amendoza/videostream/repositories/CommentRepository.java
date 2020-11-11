package com.amendoza.videostream.repositories;

import com.amendoza.videostream.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByVideoId(Long videoId);
}
