package com.realitart.contentandstreaming.Service.Impl;

import com.realitart.contentandstreaming.Domain.Image;
import com.realitart.contentandstreaming.Domain.repositories.IImageRepository;
import com.realitart.contentandstreaming.Service.IImageService;
import com.realitart.contentandstreaming.share.exceptions.ResourceNotFoundException;
import com.realitart.contentandstreaming.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {
    private static final String ENTITY = "Image";

    @Autowired
    IImageRepository _imageRepo;
    @Override
    public OperationResponse createImage(Image request) {
        try{
            _imageRepo.save(request);
            return new OperationResponse(true, "Image creado correctamente");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al crear el image", e);
        }
    }

    @Override
    public OperationResponse updateImage(Long imageId, Image request) {
        return _imageRepo.findById(imageId).map(
                image -> {
                    if(request.getName() != null) image.setName(request.getName());
                    if(request.getUrl() != null) image.setUrl(request.getUrl());
                    if(request.getEnable() != null) image.setEnable(request.getEnable());
                    _imageRepo.save(image);

                    return new OperationResponse(true, "Image actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, imageId));
    }

    @Override
    public OperationResponse deleteImage(Long imageId) {
        try{
            _imageRepo.deleteById(imageId);
            return new OperationResponse(true, "Image eliminado correctamente");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al eliminar el image", e);
        }
    }

    @Override
    public Image getImage(Long imageId) {

        try {
            return _imageRepo.findById(imageId).get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el image", e);
        }
    }

    @Override
    public List<Image> getImages() {
        try {
            return _imageRepo.findAll();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los images", e);
        }
    }
}
