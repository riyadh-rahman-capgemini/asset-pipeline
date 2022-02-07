package to.coin.assetpipeline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Score {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }
}
