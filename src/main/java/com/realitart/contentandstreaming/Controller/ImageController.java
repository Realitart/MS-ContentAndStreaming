package com.realitart.contentandstreaming.Controller;

import com.realitart.contentandstreaming.Domain.Image;
import com.realitart.contentandstreaming.Dtos.ImageCreateDTO;
import com.realitart.contentandstreaming.Service.IImageService;
import com.realitart.contentandstreaming.share.mapping.entity.ImageMapper;
import com.realitart.contentandstreaming.share.response.OperationResponse;
//import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    IImageService imageService;
    @Autowired
    private ImageMapper mapper;

    @PostMapping()
    //@Operation(summary = "Create a new image")
    OperationResponse createImage(@Valid @RequestBody ImageCreateDTO request){
        return imageService.createImage(mapper.toModel(request));
    }

    @PutMapping("/{imageId}")
    //@Operation(summary = "Update a image")
    OperationResponse updateImage(@PathVariable Long imageId,@RequestBody ImageCreateDTO request){
        return imageService.updateImage(imageId,mapper.toModel(request));
    }

    @DeleteMapping("/{imageId}")
    //@Operation(summary = "Delete a image")
    OperationResponse deleteImage(@PathVariable Long imageId){
        return imageService.deleteImage(imageId);
    }

    @GetMapping("/{imageId}")
    //@Operation(summary = "Get a image by id")
    ResponseEntity<Image> getImageData(@PathVariable Long imageId){
        return ResponseEntity.ok(imageService.getImage(imageId));
    }

    @GetMapping()
    //@Operation(summary = "Get all images")
    ResponseEntity<Page<Image>> getAllImages(Pageable pageable){
        return ResponseEntity.ok(mapper.modelListToPage(imageService.getImages(),pageable));
    }
}
