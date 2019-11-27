package com.mood;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser analyser = new MoodAnalyser();

    @Test
    public void givenMood_WhenHappy_Returns_Happy() {
        String mood=analyser.analyseMood("Happy Mood");
        Assert.assertEquals("HAPPY",mood);

    }
}
