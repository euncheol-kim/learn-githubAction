package com.dev.learngithubaction.user.infrastructure;

import com.dev.learngithubaction.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
