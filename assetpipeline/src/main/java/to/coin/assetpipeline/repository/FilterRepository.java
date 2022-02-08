package to.coin.assetpipeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import to.coin.assetpipeline.model.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {
}
