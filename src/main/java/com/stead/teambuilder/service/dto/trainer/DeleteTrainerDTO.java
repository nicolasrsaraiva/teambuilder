package com.stead.teambuilder.service.dto.trainer;

import com.stead.teambuilder.model.Trainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteTrainerDTO {
    private String firstName;
    private String lastName;

    public DeleteTrainerDTO(Trainer trainer) {
        this.firstName = trainer.getFirstName();
        this.lastName = trainer.getLastName();
    }
}
