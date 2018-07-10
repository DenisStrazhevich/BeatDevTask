package com.strazhevich.task.repository;

import com.strazhevich.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link User} class.
 * Extends {@link JpaRepository} class and provides work with database.
 *
 * @author Denis Strazhevich
 */

public interface UserRepository extends JpaRepository<User, Integer> {
}
