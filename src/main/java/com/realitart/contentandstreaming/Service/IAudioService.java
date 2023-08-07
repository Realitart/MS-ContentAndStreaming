package com.realitart.contentandstreaming.Service;

import com.realitart.contentandstreaming.Domain.Audio;
import com.realitart.contentandstreaming.share.response.OperationResponse;

import java.util.List;

public interface IAudioService {
    OperationResponse createAudio(Audio request);

    OperationResponse updateAudio(Long audioId, Audio request);

    OperationResponse deleteAudio(Long audioId);

    Audio getAudio(Long audioId);

    List<Audio> getAudios();
}
