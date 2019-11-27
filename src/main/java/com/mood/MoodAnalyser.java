package com.mood;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(){

    }
    public MoodAnalyser(String message){
        this.message=message;
    }

    public String analyseMood() throws MoodAnalysisExceptions {
        try {
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e){
            throw new MoodAnalysisExceptions(MoodAnalysisExceptions.ExceptionType.NULL_POINTER_EXCEPTION, "Null value passed");
        }
    }

}





