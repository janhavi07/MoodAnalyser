package com.mood;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    @Test
    public void givenMood_WhenHappy_Returns_Sad() throws MoodAnalysisExceptions {
        MoodAnalyser analyser = new MoodAnalyser("I am in Happy Mood");
        String mood = analyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalysisExceptions {
        MoodAnalyser analyser = new MoodAnalyser("This is sad message");
        String mood = analyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessageToConstructor_WhenHappy_ShouldReturn_Happy() throws MoodAnalysisExceptions {
        MoodAnalyser analyser = new MoodAnalyser("This is happy mood");
        String mood = analyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() {
        try {
            MoodAnalyser analyser = new MoodAnalyser(null);
            String mood = mood = analyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace();
        }

    }

    @Test
    public void givenMessage_HasNoMessage_Return_Happy() {
        try {
            MoodAnalyser analyser = new MoodAnalyser("");
            String mood = mood = analyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_Returns_Object() throws MoodAnalysisExceptions {
        Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
        Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in Happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in Happy mood"), myObject);
    }

    @Test
    public void givenMoodAnalyserClass_WhenImproperName_ThrowsException() throws MoodAnalysisExceptions {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in happy mood");
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NO_SUCH_CLASS, moodAnalysisExceptions.type);

        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenMethodImproper_ThrowsException() throws MoodAnalysisExceptions {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in happy mood");
        } catch (MoodAnalysisExceptions e) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void giveHappyMessage_WithReflection_ShouldReturn_Happy() {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in happy mood");
            Object analyseMood = MoodAnalyserFactory.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", analyseMood);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WithImproper_MethodName_Throw_Exception() {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in happy mood");
            Object analyseMood = MoodAnalyserFactory.invokeMethod(myObject, "analyzeMod");
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NO_SUCH_METHOD, moodAnalysisExceptions.type);
        }
    }

    @Test
    public void givenMessageHappy_ShouldReturn_Happy() {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in happy mood");
            MoodAnalyserFactory.setFieldValues(myObject, "message", "I am in happy mood");
            Object analyseMood = MoodAnalyserFactory.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace();
        }
    }

    @Test
    public void fieldWhenImproper_Should_ThrowException() {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in ");
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NO_SUCH_FIELD, moodAnalysisExceptions.type);

        }
    }

    @Test
    public void fieldValueWhenImproper_Should_ThrowException() {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in ");
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.FIELD_SETTING_ISSUE, moodAnalysisExceptions.type);
        }
    }

    @Test
    public void messageWhen_Null_Should_ThrowException() {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in Happy mood");
            MoodAnalyserFactory.setFieldValues(myObject, "message", null);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NULL_POINTER_EXCEPTION, moodAnalysisExceptions.type);

        }
    }
    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserFactory.getConstructor();
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor);
            MoodAnalyserFactory.setFieldValues(myObject, "message", "I am in happy mood");
            Object analyseMood = MoodAnalyserFactory.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        } catch (MoodAnalysisExceptions e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor(String.class);
            Object myObject = MoodAnalyserFactory.createMoodAnalyser(constructor,"I am in happy mood");
            Assert.assertEquals(new MoodAnalyser("I am in happy mood"),myObject);
        } catch (MoodAnalysisExceptions e) {
            e.printStackTrace();
        }
    }


}
