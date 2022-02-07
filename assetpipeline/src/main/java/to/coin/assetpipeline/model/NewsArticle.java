package to.coin.assetpipeline.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "news_articles")
public class NewsArticle {

    @Id
    private Long id;

    private String url;

    @Column(name = "published_at")
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
