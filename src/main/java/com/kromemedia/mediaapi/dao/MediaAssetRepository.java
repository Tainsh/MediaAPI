package com.kromemedia.mediaapi.dao;

import com.kromemedia.mediaapi.models.MediaAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaAssetRepository extends JpaRepository<MediaAsset, Integer> {
}
