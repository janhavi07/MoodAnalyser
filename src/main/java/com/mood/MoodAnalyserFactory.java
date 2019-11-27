package com.mood;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalysisExceptions {
    try {
        Class<?> moodClass = Class.forName("com.mood.MoodAnalyser");
        Constructor<?> moodConstructor = moodClass.getConstructor(String.class);
        Object moodObject = moodConstructor.newInstance(message);
        return (MoodAnalyser) moodObject;
    } catch(ClassNotFoundException e) {
        throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_CLASS,
                "No such class");
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }
    return null;
    }

}
