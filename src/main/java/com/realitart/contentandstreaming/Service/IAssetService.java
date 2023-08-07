package com.realitart.contentandstreaming.Service;

import com.realitart.contentandstreaming.Domain.Asset;
import com.realitart.contentandstreaming.share.response.OperationResponse;

import java.util.List;

public interface IAssetService {
    OperationResponse createAsset(Asset request);

    OperationResponse updateAsset(Long assetId, Asset request);

    OperationResponse deleteAsset(Long assetId);

    Asset getAsset(Long assetId);

    List<Asset> getAssets();
}
