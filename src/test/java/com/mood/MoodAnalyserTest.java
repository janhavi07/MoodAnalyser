package com.mood;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMood_WhenHappy_Returns_Sad() throws MoodAnalysisExceptions {
        MoodAnalyser analyser = new MoodAnalyser("I am in Happy Mood");
        String mood=analyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalysisExceptions {
        MoodAnalyser analyser = new MoodAnalyser("This is sad message");
        String mood = analyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessageToConstructor_WhenHappy_ShouldReturn_Happy() throws MoodAnalysisExceptions {
        MoodAnalyser analyser=new MoodAnalyser("This is happy mood");
        String mood=analyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() {
        try {
            MoodAnalyser analyser=new MoodAnalyser(null);
            String mood= mood = analyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace();
        }

    }
    @Test
    public void givenMessage_HasNoMessage_Return_Happy() {
        try{
            MoodAnalyser analyser=new MoodAnalyser("");
            String mood= mood = analyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace(); }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_Returns_Object() throws MoodAnalysisExceptions {
       MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("I am in Happy mood");
       Assert.assertEquals(new MoodAnalyser("I am in Happy mood"),moodAnalyser);
    }

    @Test
    public void givenMoodAnalyserClass_WhenImproperName_ThrowsException() throws MoodAnalysisExceptions {
        try{
            MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("I am in Sad mood");
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NO_SUCH_CLASS,moodAnalysisExceptions.type);

        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenMethodImproper_ThrowsException() throws MoodAnalysisExceptions {
        try{
            MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("I");
        }catch(MoodAnalysisExceptions e){
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void giveHappyMessage_WithReflection_ShouldReturn_Happy(){
        try{
            Object myObject=MoodAnalyserFactory.createMoodAnalyser("I am in Happy Mood");
            Object mood=MoodAnalyserFactory.invokeMethod(myObject,"analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WithImproper_MethodName_Throw_Exception() {
        try{
            Object myObject=MoodAnalyserFactory.createMoodAnalyser("I am in Happy Mood");
            Object mood=MoodAnalyserFactory.invokeMethod(myObject,"analyseMoo");
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            Assert.assertEquals(MoodAnalysisExceptions.ExceptionType.NO_SUCH_METHOD,moodAnalysisExceptions.type);
        }
    }

    @Test
    public void givenMessageHappy_ShouldReturn_Happy() {
        try{
            Object myObject=MoodAnalyserFactory.createMoodAnalyser("I am in Happy Mood");
            MoodAnalyserFactory.setFieldValues(myObject,"message","I am in Happy Mood");
            Object mood=MoodAnalyserFactory.invokeMethod(myObject,"analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisExceptions moodAnalysisExceptions) {
            moodAnalysisExceptions.printStackTrace();
        }
    }
}
