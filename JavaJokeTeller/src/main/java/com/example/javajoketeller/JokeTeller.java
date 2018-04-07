package com.example.javajoketeller;

import java.util.Random;

public class JokeTeller {
    private static String[] jokes = {"What is the best thing about Switzerland? \n I do not know, but the flag is a big plus.",
            "I invented a new word!! \n PLAGIARISM.",
            "NT is the only OS that has caused me to beat a piece of hardware to death with my bare hands.",
            "Microsoft is not the answer.\n Microsoft is the question. NO is the answer.",
            "Computers are like air conditioners: they stop working when you open Windows",
            "Helvetica and Times New Roman walk into a bar.\n\"Get out of here!\" shouts the bartender.\"We do not serve your type\"",
            "Why don\'t scientist trust atoms? \n Because they make up everything."};

    public static String getAnyJoke() {

        Random random = new Random();

        return jokes[random.nextInt(jokes.length)];
    }

    public static String getJoke() {

        Random random = new Random();

        return jokes[random.nextInt(jokes.length - 1)];
    }
}
