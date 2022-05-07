package edu.corvinus.beadando2.repository;

import edu.corvinus.beadando2.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>
{
    Optional<User> findByUsername(String email);
}
