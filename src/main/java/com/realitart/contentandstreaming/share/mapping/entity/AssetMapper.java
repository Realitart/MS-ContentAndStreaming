package com.realitart.contentandstreaming.share.mapping.entity;


import com.realitart.contentandstreaming.Domain.Asset;
import com.realitart.contentandstreaming.Dtos.AssetCreateDTO;
import com.realitart.contentandstreaming.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AssetMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public Page<Asset> modelListToPage(List<Asset> modelList, Pageable pageable) {
        return new PageImpl<>(modelList, pageable, modelList.size());
    }
    public Asset toModel(AssetCreateDTO resource) {
        return mapper.map(resource, Asset.class);
    }

}
