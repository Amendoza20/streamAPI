package com.amendoza.videostream.services;

import com.amendoza.videostream.models.Video;
import com.amendoza.videostream.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository repository;
    private S3Service s3;

    public Iterable<Video> index(){
        return repository.findAll();
    }

    public Video findByName(String videoName){
        List<Video> list = repository.findByVideoName(videoName);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public Video create(MultipartFile multipartFile, String videoName, String videoDescription){
        Video video = new Video(videoName, videoDescription, null);
        video = repository.save(video);
        File file = null;
        try{
            file = S3Service.convertToFile(multipartFile, video.getVideoId());
            String location = S3Service.upload(file);
            video.setLocation(location);
        }catch(Exception e){
            System.out.println("Error Occurred in S3 Storage");
            e.printStackTrace();
        }finally{
            if(file != null) file.delete();
        }
        return update(video.getVideoId(), video);
    }

    public Video update(Long videoId, Video video) {
        Video ogVideo = repository.findById(videoId).orElse(null);
        if (ogVideo == null) {
            return null;
        }
        ogVideo.setVideoDescription(video.getVideoDescription());
        ogVideo.setLocation(video.getLocation());
        ogVideo.setVideoName(video.getVideoName());
        return repository.save(video);
    }
    public boolean delete(Long videoId){
        repository.deleteById(videoId);
        return true;
    }

}
