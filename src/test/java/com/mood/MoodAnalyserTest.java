package com.mood;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMood_WhenSad_Returns_Sad() {
        MoodAnalyser analyser = new MoodAnalyser("I am in Sad Mood");
        String mood=analyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }
}
