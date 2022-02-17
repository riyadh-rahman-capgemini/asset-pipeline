package to.coin.assetpipeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import to.coin.assetpipeline.model.Filter;

import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long> {

    List<Filter> findAllByUserId(Long userId);
}
