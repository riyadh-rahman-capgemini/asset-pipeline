package to.coin.assetpipeline.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "filters")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonSetter("user_id")
    private Long userId;

    @NotBlank(message = "name cannot be left blank")
    private String name;

    private String query;

    @CreationTimestamp
    private Instant createdAt;

    public Filter() {
    }

    public Filter(Long userId, String name, String query) {
        this.userId = userId;
        this.name = name;
        this.query = query;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", query='" + query + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
