package com.realitart.contentandstreaming.Controller;

import com.realitart.contentandstreaming.Domain.Audio;
import com.realitart.contentandstreaming.Dtos.AudioCreateDTO;
import com.realitart.contentandstreaming.Service.IAudioService;
import com.realitart.contentandstreaming.share.mapping.entity.AudioMapper;
import com.realitart.contentandstreaming.share.response.OperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audios")
public class AudioController {
    @Autowired
    IAudioService audioService;
    @Autowired
    private AudioMapper mapper;

    @PostMapping()
    @Operation(summary = "Create a new audio")
    OperationResponse createAudio(@Valid @RequestBody AudioCreateDTO request){
        return audioService.createAudio(mapper.toModel(request));
    }

    @PutMapping("/{audioId}")
    @Operation(summary = "Update a audio")
    OperationResponse updateAudio(@PathVariable Long audioId,@RequestBody AudioCreateDTO request){
        return audioService.updateAudio(audioId,mapper.toModel(request));
    }

    @DeleteMapping("/{audioId}")
    @Operation(summary = "Delete a audio")
    OperationResponse deleteAudio(@PathVariable Long audioId){
        return audioService.deleteAudio(audioId);
    }

    @GetMapping("/{audioId}")
    @Operation(summary = "Get a audio by id")
    ResponseEntity<Audio> getAudioData(@PathVariable Long audioId){
        return ResponseEntity.ok(audioService.getAudio(audioId));
    }

    @GetMapping()
    @Operation(summary = "Get all audios")
    ResponseEntity<Page<Audio>> getAllAudios(Pageable pageable){
        return ResponseEntity.ok(mapper.modelListToPage(audioService.getAudios(),pageable));
    }
}
