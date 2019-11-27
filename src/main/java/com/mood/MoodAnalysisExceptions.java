package com.mood;

public class MoodAnalysisExceptions extends Exception{
    enum ExceptionType{
        NULL_POINTER_EXCEPTION
    }
    ExceptionType type;
    public MoodAnalysisExceptions(ExceptionType type, String errorMessage) {
        super(errorMessage);
        this.type=type;

    }
       
    
}
