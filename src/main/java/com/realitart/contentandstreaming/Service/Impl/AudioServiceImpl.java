package com.realitart.contentandstreaming.Service.Impl;

import com.realitart.contentandstreaming.Domain.Audio;
import com.realitart.contentandstreaming.Domain.repositories.IAudioRepository;
import com.realitart.contentandstreaming.Service.IAudioService;
import com.realitart.contentandstreaming.share.exceptions.ResourceNotFoundException;
import com.realitart.contentandstreaming.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioServiceImpl implements IAudioService {
    private static final String ENTITY = "Audio";

    @Autowired
    IAudioRepository _audioRepo;
    @Override
    public OperationResponse createAudio(Audio request) {
        try{
            _audioRepo.save(request);
            return new OperationResponse(true, "Audio creado correctamente");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al crear el audio", e);
        }
    }

    @Override
    public OperationResponse updateAudio(Long audioId, Audio request) {
        return _audioRepo.findById(audioId).map(
                audio -> {
                    if(request.getArtworkId() != null) audio.setArtworkId(request.getArtworkId());
                    if(request.getUrl() != null) audio.setUrl(request.getUrl());
                    if(request.getEnable() != null) audio.setEnable(request.getEnable());
                    _audioRepo.save(audio);

                    return new OperationResponse(true, "Audio actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, audioId));
    }

    @Override
    public OperationResponse deleteAudio(Long audioId) {
        try{
            _audioRepo.deleteById(audioId);
            return new OperationResponse(true, "Audio eliminado correctamente");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al eliminar el audio", e);
        }
    }

    @Override
    public Audio getAudio(Long audioId) {

        try {
            return _audioRepo.findById(audioId).get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el audio", e);
        }
    }

    @Override
    public List<Audio> getAudios() {
        try {
            return _audioRepo.findAll();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los audios", e);
        }
    }
}
