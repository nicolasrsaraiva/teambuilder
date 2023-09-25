package com.stead.teambuilder.service.dto.trainer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTrainerDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
