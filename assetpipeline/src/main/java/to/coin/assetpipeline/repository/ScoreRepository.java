package to.coin.assetpipeline.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import to.coin.assetpipeline.model.Score;
import to.coin.assetpipeline.model.Sentiment;

import java.util.List;

public interface ScoreRepository extends ReadOnlyRepository<Score, Long> {

    @Cacheable(value = "sentimentsCache", key = "#id")
    @Query("SELECT s FROM Sentiment s JOIN NewsArticle n ON s.newsArticle = n.id WHERE s.assetId = :id AND s.entityType = 0 AND s.processedAt IS NOT NULL")
    List<Sentiment> findAllSentimentsByAssetId(Long id);
}
