package com.jetbrains.fira.photo.clone.service;

import com.jetbrains.fira.photo.clone.model.Photo;
import com.jetbrains.fira.photo.clone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

@Service

public class PhotosService {

    private final PhotozRepository photozRepository;

    public PhotosService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public Photo remove(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public Photo save(String filename, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(filename);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }


}
