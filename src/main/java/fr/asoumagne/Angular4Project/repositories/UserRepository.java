package fr.asoumagne.Angular4Project.repositories;

import fr.asoumagne.Angular4Project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
