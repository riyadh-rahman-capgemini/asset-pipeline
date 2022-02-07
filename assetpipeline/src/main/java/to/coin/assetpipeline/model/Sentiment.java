package to.coin.assetpipeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "sentiments")
public class Sentiment extends Score {

    @Column(name = "asset_id")
    private Long assetId;

    @Column(name = "entity_type")
    private Integer entityType;

    @Column(name = "score")
    @JsonProperty("sentiment_score")
    private Double sentimentScore;

    @Column(name = "relevance")
    @JsonProperty("relevance_score")
    private Double relevanceScore;

    @Column(name = "processed_at")
    @JsonProperty("processed_at")
    private Instant processedAt;

    @OneToOne()
    @JoinColumn(name = "entity_id", nullable = true)
    private NewsArticle newsArticle;

    public Double getSentimentScore() {
        return sentimentScore;
    }

    public Double getRelevanceScore() {
        return relevanceScore;
    }

    public Instant getProcessedAt() {
        return processedAt;
    }

    public NewsArticle getNewsArticle() {
        return newsArticle;
    }
}
