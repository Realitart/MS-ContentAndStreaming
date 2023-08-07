package com.realitart.contentandstreaming.share.mapping.entity;


import com.realitart.contentandstreaming.Domain.Audio;
import com.realitart.contentandstreaming.Dtos.AssetCreateDTO;
import com.realitart.contentandstreaming.Dtos.AudioCreateDTO;
import com.realitart.contentandstreaming.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AudioMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public Page<Audio> modelListToPage(List<Audio> modelList, Pageable pageable) {
        return new PageImpl<>(modelList, pageable, modelList.size());
    }
    public Audio toModel(AudioCreateDTO resource) {
        return mapper.map(resource, Audio.class);
    }

}
