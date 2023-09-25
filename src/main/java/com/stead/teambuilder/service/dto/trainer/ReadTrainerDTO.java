package com.stead.teambuilder.service.dto.trainer;

import com.stead.teambuilder.model.Trainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadTrainerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    public ReadTrainerDTO(){
        super();
    }

    public ReadTrainerDTO(Trainer trainer) {
        this.id = trainer.getId();
        this.firstName = trainer.getFirstName();
        this.lastName = trainer.getLastName();
        this.username = trainer.getUsername();
        this.email = trainer.getEmail();
    }
}
