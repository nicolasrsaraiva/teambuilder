package com.stead.teambuilder.controller;

import com.stead.teambuilder.model.Trainer;
import com.stead.teambuilder.repository.TrainerRepository;
import com.stead.teambuilder.service.dto.trainer.CreateTrainerDTO;
import com.stead.teambuilder.service.dto.trainer.ReadTrainerDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

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

    @GetMapping("/id/{id}")
    public ResponseEntity<ReadTrainerDTO> readTrainerById(@PathVariable Long id) {
        try {
            Trainer trainer = trainerRepository.findTrainerById(id);
            if (trainer != null) {
                return new ResponseEntity<ReadTrainerDTO>(new ReadTrainerDTO(trainer), HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ReadTrainerDTO> readTrainerByName(@PathVariable String name) {
        try {
            Trainer trainer = trainerRepository.findTrainerByName(name);
            if (trainer != null) {
                return new ResponseEntity<ReadTrainerDTO>(new ReadTrainerDTO(trainer), HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
