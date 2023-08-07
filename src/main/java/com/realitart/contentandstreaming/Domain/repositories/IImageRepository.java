package com.realitart.contentandstreaming.Domain.repositories;

import com.realitart.contentandstreaming.Domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
}
