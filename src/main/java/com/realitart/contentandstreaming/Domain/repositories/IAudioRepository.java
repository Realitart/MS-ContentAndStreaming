package com.realitart.contentandstreaming.Domain.repositories;

import com.realitart.contentandstreaming.Domain.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAudioRepository extends JpaRepository<Audio, Long> {
}
