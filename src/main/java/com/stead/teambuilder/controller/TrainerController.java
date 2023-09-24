package com.stead.teambuilder.controller;

import com.stead.teambuilder.model.Trainer;
import com.stead.teambuilder.repository.TrainerRepository;
import com.stead.teambuilder.service.dto.trainer.CreateTrainerDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> create(@Valid @RequestBody CreateTrainerDTO createTrainerDTO){
        try {
            trainerRepository.save(new Trainer(createTrainerDTO));
            return new ResponseEntity<String>("User created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Failed to create user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
