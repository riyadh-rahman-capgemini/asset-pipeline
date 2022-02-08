package to.coin.assetpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import to.coin.assetpipeline.model.Asset;
import to.coin.assetpipeline.service.AssetService;
import to.coin.assetpipeline.model.Sentiment;

import java.util.List;

@CrossOrigin
@RestController
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping("/api/assets")
    public ResponseEntity<List<Asset>> getAll() {
        return assetService.getAll();
    }

    @GetMapping("/api/assets/{id}")
    public ResponseEntity<Asset> getOne(@PathVariable Long id) {
        return assetService.getOne(id);
    }

    @GetMapping("/api/assets/{id}/sentiments")
    public ResponseEntity<List<Sentiment>> getSentimentsForOne(@PathVariable Long id) {
        return assetService.getSentimentsByAssetId(id);
    }

}
