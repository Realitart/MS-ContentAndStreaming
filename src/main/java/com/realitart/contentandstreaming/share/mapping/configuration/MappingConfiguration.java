package com.realitart.contentandstreaming.share.mapping.configuration;


import com.realitart.contentandstreaming.share.mapping.entity.AssetMapper;
import com.realitart.contentandstreaming.share.mapping.entity.AudioMapper;
import com.realitart.contentandstreaming.share.mapping.entity.ImageMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public AssetMapper UserMapper() {
        return new AssetMapper();
    }
    @Bean
    public AudioMapper AudioMapper() {
        return new AudioMapper();
    }
    @Bean
    public ImageMapper ImageMapper() {
        return new ImageMapper();
    }

}
