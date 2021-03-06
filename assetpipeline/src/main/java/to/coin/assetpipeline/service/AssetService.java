package to.coin.assetpipeline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import to.coin.assetpipeline.repository.AssetRepository;
import to.coin.assetpipeline.repository.ScoreRepository;
import to.coin.assetpipeline.model.Asset;
import to.coin.assetpipeline.model.Sentiment;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    public ResponseEntity<List<Asset>> getAll() {
        return ResponseEntity.ok(assetRepository.findAll());
    }

    public ResponseEntity<Asset> getOne(Long id) {
        Optional<Asset> asset = assetRepository.findById(id);

        if (asset.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(asset.get());
    }

    public ResponseEntity<List<Sentiment>> getTodaySentimentsByAssetId(Long id) {
        if (!assetRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        System.out.println("");

        return ResponseEntity.ok(scoreRepository.findAllSentimentsByAssetIdAndDate(id, LocalDate.now()));
    }
}
