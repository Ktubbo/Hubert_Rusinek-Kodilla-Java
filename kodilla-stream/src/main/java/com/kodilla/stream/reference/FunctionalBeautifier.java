package com.kodilla.stream.reference;

public class FunctionalBeautifier {

    public static String everySecondCharacterToUpperCase(String poem) {
        String result = "";
        if(poem == ""){ return ""; }
        for(int i=0; i<poem.length();i++){
            if(i%2==0){
                char letter = poem.charAt(i);
                String upperCaseLetter = "" + letter;
                result=result+ upperCaseLetter.toUpperCase();
            } else {
                result=result+poem.charAt(i);
            }
        }
        return result;
        }

   public static String spacesToStars(String poem) { return poem.replaceAll(" ", "*"); }
}
