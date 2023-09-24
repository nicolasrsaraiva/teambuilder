package com.stead.teambuilder.service.dto.trainer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateTrainerDTO {
    @NotBlank
    private String name;
}
