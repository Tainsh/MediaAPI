package com.kromemedia.mediaapi.services;

import com.kromemedia.mediaapi.dao.MediaAssetRepository;
import com.kromemedia.mediaapi.models.MediaAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class MediaAssetService {
    private final MediaAssetRepository repo;

    @Autowired
    public MediaAssetService(MediaAssetRepository repo) {
        this.repo = repo;
    }

    public Collection<MediaAsset> findAll() {
        return repo.findAll();
    }

    public Optional<MediaAsset> findById(Integer id) {
        return repo.findById(id);
    }

    public MediaAsset create(MediaAsset options) throws Exception {
        MediaAsset cpy = new MediaAsset(options);
        cpy.setId(null);

        return this.repo.save(cpy);
    }

    public MediaAsset update(MediaAsset updated) throws Exception {
        Integer id = updated.getId();

        if(id == null || !this.repo.existsById(id)) {
            throw new Exception("Asset not found");
        }
        return this.repo.save(updated);
    }

    public void delete(MediaAsset asset) throws Exception {
        this.repo.delete(asset);
    }

    public void delete(Integer id) {
        this.repo.deleteById(id);
    }
}
