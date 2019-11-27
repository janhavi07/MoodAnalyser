package com.mood;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if(message.contains("Happy Mood"))
            return "HAPPY";
        else
            return "SAD";
    }
}
