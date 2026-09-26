package in.kumar.repository;

import in.kumar.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {

    Optional<Account> findByAccNo(String accNo);


}
