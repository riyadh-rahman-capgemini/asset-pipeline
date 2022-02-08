package to.coin.assetpipeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import to.coin.assetpipeline.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
