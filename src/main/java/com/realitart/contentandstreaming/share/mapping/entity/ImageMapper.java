package com.realitart.contentandstreaming.share.mapping.entity;


import com.realitart.contentandstreaming.Domain.Image;
import com.realitart.contentandstreaming.Dtos.ImageCreateDTO;
import com.realitart.contentandstreaming.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ImageMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public Page<Image> modelListToPage(List<Image> modelList, Pageable pageable) {
        return new PageImpl<>(modelList, pageable, modelList.size());
    }
    public Image toModel(ImageCreateDTO resource) {
        return mapper.map(resource, Image.class);
    }

}
