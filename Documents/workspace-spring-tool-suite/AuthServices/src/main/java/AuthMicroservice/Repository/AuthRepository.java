package AuthMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AuthMicroservice.entity.Auth;
@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {

}
