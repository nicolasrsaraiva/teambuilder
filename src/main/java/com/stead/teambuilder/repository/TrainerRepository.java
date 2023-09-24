package com.stead.teambuilder.repository;

import com.stead.teambuilder.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findTrainerByName(String name);
    Trainer findTrainerById(Long id);
}
