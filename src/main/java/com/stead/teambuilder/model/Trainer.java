package com.stead.teambuilder.model;

import com.stead.teambuilder.service.dto.trainer.CreateTrainerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "Trainer")
@Table(name = "Trainer", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String username;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String password;

    public Trainer(CreateTrainerDTO createTrainerDTO) {
        this.firstName = createTrainerDTO.getFirstName();
        this.lastName = createTrainerDTO.getLastName();
        this.username = createTrainerDTO.getUsername();
        this.email = createTrainerDTO.getEmail();
        this.password = createTrainerDTO.getPassword();
    }
}
