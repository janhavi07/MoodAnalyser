package com.mood;

public class MoodAnalysisExceptions extends Exception{
    enum ExceptionType{
        NULL_POINTER_EXCEPTION,EMPTY_MESSAGE,NO_SUCH_CLASS,NO_SUCH_METHOD,METHOD_INVOCATION_ISSUE,FIELD_SETTING_ISSUE
    }
    ExceptionType type;
    public MoodAnalysisExceptions(ExceptionType type, String errorMessage) {
        super(errorMessage);
        this.type=type;

    }
       
    
}
