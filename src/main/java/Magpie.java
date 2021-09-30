import java.util.Locale;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findWord(statement,"no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement,"mother") >= 0
                || findWord(statement,"father") >= 0
                || findWord(statement,"sister") >= 0
                || findWord(statement,"brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement,"dog")>=0 || findWord(statement,"cat")>=0){
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement,"Nathan")>=0){
            response = "I've heard he loves Romanian folk dancing.";
        }
        else if (findWord(statement,"baseball")>=0){
            response = "I love baseball.";
        }
        else if (findWord(statement,"ice cream")>=0){
            response = "My favorite ice cream flavor is strawberry cheesecake.";
        }
        else if (findWord(statement,"spanish")>=0){
            response = "What a romantic language.";
        }
        else if ("".equals(statement.trim())){
            response= "Say something please.";
        }
        else if (findWord(statement,"I want")>=0){
            response = transformIWantStatement(statement);
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Well shiver me timbers.";
        }
        else if (whichResponse == 5)
        {
            response = "By golly that's surprising!";
        }

    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        word = word.toLowerCase();
        str = str.toLowerCase();
        int index = str.indexOf(word);
        int maxIndex = str.length()-word.length();
        if (index==maxIndex){
            if (str.charAt(index-1)==' '){
                return index;
            }
        }
        else {
            char after = str.charAt(index + word.length());
            if (index > 0 && index < maxIndex) {

                if (after == ' ' && str.charAt(index - 1) == ' ') {
                    return index;
                }
            } else if (index == 0) {

                if (after == ' ') {
                    return index;
                }

            }

        }
        return -1;

    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        statement= statement.toLowerCase();
        int index = findWord(statement,"i want") + 7;
        int endIndex = statement.length();
        for (int i =index; i<statement.length();i++){
            if (statement.charAt(i)==' '){
                endIndex=i+1;
            }
        }
        String response = "Would you really be happy if you had " +statement.substring(index,endIndex) + "?";
        return response;
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        //your code here
        return "";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        // your code here
        return "";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        // your code here
        return "";
    }
}
