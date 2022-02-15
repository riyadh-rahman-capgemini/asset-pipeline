package to.coin.assetpipeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "news_articles")
public class NewsArticle implements Serializable {

    @Id
    private Long id;

    private String url;

    @Column(name = "published_at")
    @JsonProperty("published_at")
    private Instant publishedAt;

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

}
