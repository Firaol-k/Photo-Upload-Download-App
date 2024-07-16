package com.jetbrains.fira.photo.clone.web;

import com.jetbrains.fira.photo.clone.model.Photo;
import com.jetbrains.fira.photo.clone.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotoController{


   final private PhotosService photosService;

    public PhotoController(@Autowired PhotosService photosService) {
        this.photosService = photosService;
    }

//    private List<Photo> db = List.of(new Photo("1","Hello"));

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photosService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photosService.get(id);
        if (photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
        photosService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        Photo photo = photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        //System.out.println(photo);
        return  photo;
    }
}
