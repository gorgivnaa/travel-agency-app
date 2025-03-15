package by.bsuir.travel.agency.core.repositories;

import by.bsuir.travel.agency.core.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
