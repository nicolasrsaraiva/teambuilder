package com.stead.teambuilder.controller;

import com.stead.teambuilder.model.Trainer;
import com.stead.teambuilder.repository.TrainerRepository;
import com.stead.teambuilder.service.dto.trainer.CreateTrainerDTO;
import com.stead.teambuilder.service.dto.trainer.DeleteTrainerDTO;
import com.stead.teambuilder.service.dto.trainer.ReadTrainerDTO;
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
    public ResponseEntity<String> create(@Valid @RequestBody CreateTrainerDTO createTrainerDTO){
        try {
            boolean usernameAlreadyExists = trainerRepository.existsByUsername(createTrainerDTO.getUsername());
            boolean emailAlreadyExists = trainerRepository.existsByEmail(createTrainerDTO.getEmail());
            if (usernameAlreadyExists) {
                return new ResponseEntity<String>("Username already exists", HttpStatus.BAD_REQUEST);
            }
            if (emailAlreadyExists) {
                return new ResponseEntity<String>("Email already exists", HttpStatus.BAD_REQUEST);
            }
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
                return new ResponseEntity<>(new ReadTrainerDTO(trainer), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ReadTrainerDTO> readTrainerByName(@PathVariable String username) {
        try {
            Trainer trainer = trainerRepository.findTrainerByUsername(username);
            if (trainer != null) {
                return new ResponseEntity<ReadTrainerDTO>(new ReadTrainerDTO(trainer), HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<DeleteTrainerDTO> delete(@PathVariable Long id) {
        try {
            Trainer trainer = trainerRepository.findTrainerById(id);
            if (trainer != null) {
                trainerRepository.deleteById(id);
                return new ResponseEntity<DeleteTrainerDTO>(new DeleteTrainerDTO(trainer), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
