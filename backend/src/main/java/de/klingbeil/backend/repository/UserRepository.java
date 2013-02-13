package de.klingbeil.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.klingbeil.backend.model.User;

/**
 * Specifies methods used to obtain and modify user related information which is
 * stored in the database.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
