package com.realitart.contentandstreaming.Controller;

import com.realitart.contentandstreaming.Domain.Asset;
import com.realitart.contentandstreaming.Dtos.AssetCreateDTO;
import com.realitart.contentandstreaming.Service.IAssetService;
import com.realitart.contentandstreaming.share.mapping.entity.AssetMapper;
import com.realitart.contentandstreaming.share.response.OperationResponse;
//import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assets")
public class AssetController {
    @Autowired
    IAssetService assetService;
    @Autowired
    private AssetMapper mapper;

    @PostMapping()
    //@Operation(summary = "Create a new asset")
    OperationResponse createAsset(@Valid @RequestBody AssetCreateDTO request){
        return assetService.createAsset(mapper.toModel(request));
    }

    @PutMapping("/{assetId}")
    //@Operation(summary = "Update a asset")
    OperationResponse updateAsset(@PathVariable Long assetId,@RequestBody AssetCreateDTO request){
        return assetService.updateAsset(assetId,mapper.toModel(request));
    }

    @DeleteMapping("/{assetId}")
    //@Operation(summary = "Delete a asset")
    OperationResponse deleteAsset(@PathVariable Long assetId){
        return assetService.deleteAsset(assetId);
    }

    @GetMapping("/{assetId}")
    //@Operation(summary = "Get a asset by id")
    ResponseEntity<Asset> getAssetData(@PathVariable Long assetId){
        return ResponseEntity.ok(assetService.getAsset(assetId));
    }

    @GetMapping()
    //@Operation(summary = "Get all assets")
    ResponseEntity<Page<Asset>> getAllAssets(Pageable pageable){
        return ResponseEntity.ok(mapper.modelListToPage(assetService.getAssets(),pageable));
    }
}
