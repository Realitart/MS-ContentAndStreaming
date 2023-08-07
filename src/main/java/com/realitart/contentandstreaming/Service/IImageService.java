package com.realitart.contentandstreaming.Service;

import com.realitart.contentandstreaming.Domain.Image;
import com.realitart.contentandstreaming.share.response.OperationResponse;

import java.util.List;

public interface IImageService {
    OperationResponse createImage(Image request);

    OperationResponse updateImage(Long imageId, Image request);

    OperationResponse deleteImage(Long imageId);

    Image getImage(Long imageId);

    List<Image> getImages();
}
