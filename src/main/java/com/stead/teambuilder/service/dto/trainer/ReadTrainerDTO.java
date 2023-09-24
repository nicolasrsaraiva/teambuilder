package com.stead.teambuilder.service.dto.trainer;

import com.stead.teambuilder.model.Trainer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadTrainerDTO {
    private Long id;
    private String name;

    public ReadTrainerDTO(Trainer trainer) {
        this.id = trainer.getId();
        this.name = trainer.getName();
    }
}
