package com.mood;

public class MoodAnalysisExceptions extends Exception{
    enum ExceptionType{
        NULL_POINTER_EXCEPTION,EMPTY_MESSAGE,NO_SUCH_CLASS
    }
    ExceptionType type;
    public MoodAnalysisExceptions(ExceptionType type, String errorMessage) {
        super(errorMessage);
        this.type=type;

    }
       
    
}
