package com.example.simon.funfacts;

import java.util.Random;

public class FactBook {
    String[] factsArray = {
            "Kiss och bajs",
            "Vem är coolast av katterna",
            "Rickard är en kusin till mig"
    };
    //fields or members
    //methods
    public String getFact() {
        Random random = new Random();
        int randomNumber = random.nextInt(factsArray.length);
        String hellos = "fwefwef";
        return factsArray[randomNumber];

    }
}

