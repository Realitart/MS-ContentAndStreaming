package com.realitart.contentandstreaming.Service.Impl;

import com.realitart.contentandstreaming.Domain.Asset;
import com.realitart.contentandstreaming.Domain.repositories.IAssetRepository;
import com.realitart.contentandstreaming.Service.IAssetService;
import com.realitart.contentandstreaming.share.exceptions.ResourceNotFoundException;
import com.realitart.contentandstreaming.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements IAssetService {
    private static final String ENTITY = "Asset";

    @Autowired
    IAssetRepository _assetRepo;
    @Override
    public OperationResponse createAsset(Asset request) {
        try{
            _assetRepo.save(request);
            return new OperationResponse(true, "Asset creado correctamente");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al crear el asset", e);
        }
    }

    @Override
    public OperationResponse updateAsset(Long assetId, Asset request) {
        return _assetRepo.findById(assetId).map(
                asset -> {
                    if(request.getArtworkId() != null) asset.setArtworkId(request.getArtworkId());
                    if(request.getUrl() != null) asset.setUrl(request.getUrl());
                    if(request.getPositionX() != null) asset.setPositionX(request.getPositionX());
                    if(request.getPositionY() != null) asset.setPositionY(request.getPositionY());
                    if(request.getPositionZ() != null) asset.setPositionZ(request.getPositionZ());
                    if(request.getScaleX() != null) asset.setScaleX(request.getScaleX());
                    if(request.getScaleY() != null) asset.setScaleY(request.getScaleY());
                    if(request.getScaleZ() != null) asset.setScaleZ(request.getScaleZ());
                    if(request.getRotationX() != null) asset.setRotationX(request.getRotationX());
                    if(request.getRotationY() != null) asset.setRotationY(request.getRotationY());
                    if(request.getRotationZ() != null) asset.setRotationZ(request.getRotationZ());
                    if(request.getEnable() != null) asset.setEnable(request.getEnable());
                    _assetRepo.save(asset);

                    return new OperationResponse(true, "Asset actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, assetId));
    }

    @Override
    public OperationResponse deleteAsset(Long assetId) {
        try{
            _assetRepo.deleteById(assetId);
            return new OperationResponse(true, "Asset eliminado correctamente");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al eliminar el asset", e);
        }
    }

    @Override
    public Asset getAsset(Long assetId) {

        try {
            return _assetRepo.findById(assetId).get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el asset", e);
        }
    }

    @Override
    public List<Asset> getAssets() {
        try {
            return _assetRepo.findAll();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los assets", e);
        }
    }
}
