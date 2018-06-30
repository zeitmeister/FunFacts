package com.example.simon.funfacts;

import java.util.Random;

public class FactBook {
    String[] factsArray = {
            "Tommy Claesson e så jävla go",
    };
    //fields or members
    //methods
    public String getFact() {
        Random random = new Random();
        int randomNumber = random.nextInt(factsArray.length);
        return factsArray[randomNumber];

    }
}

