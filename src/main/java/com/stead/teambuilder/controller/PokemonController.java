package com.stead.teambuilder.controller;

import com.stead.teambuilder.model.Pokemon;
import com.stead.teambuilder.model.Type;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @PostMapping
    public void create(){
        Pokemon pokemon = new Pokemon(
                "Pikachu",
                32.1,
                13.4,
                Type.ELECTRIC
        );
    }
}
