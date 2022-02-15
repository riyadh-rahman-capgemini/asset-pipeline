package to.coin.assetpipeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "assets")
public class Asset implements Serializable {

    @Id
    private Long id;

    private String symbol;

    @Column(name = "class")
    @JsonProperty("class")
    private Integer assetClass;

    private boolean enabled;

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getAssetClass() {
        return assetClass;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
