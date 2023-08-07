package com.realitart.contentandstreaming.Domain.repositories;

import com.realitart.contentandstreaming.Domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssetRepository extends JpaRepository<Asset, Long> {
}
