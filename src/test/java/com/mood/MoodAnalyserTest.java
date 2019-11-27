package com.mood;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMood_WhenHappy_Returns_Sad() {
        MoodAnalyser analyser = new MoodAnalyser("I am in Happy Mood");
        String mood=analyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyser analyser = new MoodAnalyser("This is sad message");
        String mood = analyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessageToConstructor_WhenHappy_ShouldReturn_Happy() {
        MoodAnalyser analyser=new MoodAnalyser("This is happy mood");
        String mood=analyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() {
        MoodAnalyser analyser=new MoodAnalyser(null);
        String mood=analyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }
}
