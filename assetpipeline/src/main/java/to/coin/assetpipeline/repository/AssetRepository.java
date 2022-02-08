package to.coin.assetpipeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import to.coin.assetpipeline.model.Asset;

public interface AssetRepository extends ReadOnlyRepository<Asset, Long> {
}
