package com.stead.teambuilder.repository;

import com.stead.teambuilder.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findTrainerByUsername(String username);
    Trainer findTrainerById(Long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
