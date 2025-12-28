package com.rentals.project.Repository;

import com.rentals.project.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    @Repository
    public interface UserRepository extends JpaRepository<category, Long> {
    }
}
