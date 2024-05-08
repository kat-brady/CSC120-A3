import java.util.*;
/*The Conversation class contains all of the methods for the chatbot to function */
public class Conversation { 
    /* main method for the Conversation class to run the chatbot
     * Initializes a scanner to get user input
     * Initializes a transcript to display to the user
     * Mirrors responses or produces response from array of canned ones for desired number of rounds
     */
  public static void main(String[] args) {
    /*Initializes arraylist of static responses and adds possible responses to it */
    ArrayList<String> cannedResponses = new ArrayList<>();
    cannedResponses.add("That's wild!");
    cannedResponses.add("I'm totally listening.");
    cannedResponses.add("Wow, tell me more.");
    cannedResponses.add("This is such a fun conversation.");
    cannedResponses.add("Oh, okay.");
    /* Initializes scanner to get user input */
    Scanner sc = new Scanner(System.in);
    System.out.println("How many rounds of conversation?");
    int Rounds= sc.nextInt(); //this saves the user's input as Rounds
    sc.nextLine();
    List<String> transcript= new ArrayList<String>(); //this creates the transcript in order to later print it
    transcript.add("TRANSCRIPT:\n");
    transcript.add("How many rounds of conversation?");
    String times=String.valueOf(Rounds); //this converts the integer Rounds into a string so that it can be added to the transcript
    transcript.add(times);
    transcript.add("Hello! What are you thinking about today?");
    System.out.println("Hello! What are you thinking about today?");
    /*For loop allows conversation to continue for the desired length */
    for (int i=1; i<= Rounds; i++){ //this allows the chat to continue the desired number of rounds
      Random rand= new Random(); //generates a random number to use later for a canned response
        int num = rand.nextInt(1,4);
      String response = sc.nextLine();
      transcript.add(response);
      if (response.contains("\\bI\\b")||response.contains("\\byou\\b")||response.contains("\\byour\\b")||response.contains("\\bme\\b")||response.contains("\\bmyself\\b")||response.contains("\\bam\\b")||response.contains("\\bmy\\b")){
        //the words are replaced with temporary words to prevent issues with the replacement words being overwritten
        response= response.replaceAll("\\bI\\b", "tempY"); //tempY -> you
        response = response.replaceAll("\\byour\\b", "tempP");//tempP -> my
        response = response.replaceAll("\\byou\\b", "tempI");//tempI -> I
        response = response.replaceAll("\\bme\\b ", "tempY");//tempY -> you
        response = response.replaceAll("\\bmyself\\b", "SELF");//SELF-> yourself
        response = response.replaceAll("\\bam\\b", "tempR");//tempR -> are
        response = response.replaceAll("\\bare\\b", "tempAM");//tempAM -> am
        response = response.replaceAll("\\bmy\\b", "tempUR");//tempUR -> your
        response = response.replaceAll("tempY", "you");
        response = response.replaceAll("tempI", " I ");
        response = response.replaceAll("tempP", " my ");
        response = response.replaceAll("tempY", " you ");
        response = response.replaceAll("SELF", " yourself ");
        response = response.replaceAll("tempR", " are ");
        response = response.replaceAll("tempAM", " am ");
        response = response.replaceAll("tempUR", " your ");
        response = response.replaceAll("'m", " tempAP ");
        response = response.replaceAll("'re", "TEMPRE");
        response = response.replaceAll("tempAP", "'re");
        response = response.replaceAll("TEMPRE", "'m");
        System.out.println(response + "?");
        transcript.add(response + "?");}
      else{ //if none of the mirror words are detected, a canned response is used instead
        Random rand = new Random();
        reply=cannedResponses.get(rand);
        System.out.println(reply);
        transcript.add(reply);
    }
  }
  String bye="It was nice talking to you. Bye now!\n"; //this wraps up the conversation
    transcript.add(bye);
    System.out.println(bye);
    for(String line: transcript){
      System.out.println(line);
    }
      sc.close(); //the scanner is closed
  }
}

