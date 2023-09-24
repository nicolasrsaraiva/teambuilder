package com.stead.teambuilder.model;

import com.stead.teambuilder.service.dto.trainer.CreateTrainerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Entity(name = "Trainer")
@Table(name = "Trainer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    public Trainer(CreateTrainerDTO createTrainerDTO) {
        this.name = createTrainerDTO.getName();
    }
}
