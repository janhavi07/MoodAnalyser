package com.mood;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalysisExceptions {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.mood.MoodAnalyser");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_CLASS,"THere is np such class");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_METHOD,"No such method");
        }
    }
    public static Object createMoodAnalyser(Constructor<?> constructor, Object ... message ) throws MoodAnalysisExceptions{
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_ACCESS,"No such access");
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.OBJECT_CREATION_ISSUE,"Object was not created");
        }
    }



//    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalysisExceptions {
//    try {
//        Class<?> moodClass = Class.forName("com.mood.MoodAnalyser");
//        Constructor<?> moodConstructor = moodClass.getConstructor(String.class);
//        Object moodObject = moodConstructor.newInstance(message);
//        return (MoodAnalyser) moodObject;
//    } catch(ClassNotFoundException e) {
//        throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_CLASS,
//                "No such class");
//    } catch (NoSuchMethodException e) {
//        throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_METHOD,
//                "No such Method");
//    } catch (IllegalAccessException e) {
//        e.printStackTrace();
//    } catch (InstantiationException e) {
//        e.printStackTrace();
//    } catch (InvocationTargetException e) {
//        e.printStackTrace();
//    }
//    return null;
//    }

    public static Object invokeMethod(Object object,String methodName) throws MoodAnalysisExceptions {
        try {
            return object.getClass().getMethod(methodName).invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.METHOD_INVOCATION_ISSUE,
                    "Issue with data");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_METHOD,
                    "No such method");
        }
    }

    public static void setFieldValues(Object myObject,String fieldName,String fieldValues) throws MoodAnalysisExceptions {
        try{
            Field field=myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValues);
        } catch (IllegalAccessException e) {
           throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.FIELD_SETTING_ISSUE,
                   "Improper fields");
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NO_SUCH_FIELD,
                    "Improper field Name");
        }
    }


    }


