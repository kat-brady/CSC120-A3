import java.util.*;
public class Conversation { //the chatbot code

  public static void main(String[] args) {
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
    //The intro is printed once before the loop starts
    for (int i=1; i<= Rounds; i++){ //this allows the chat to continue the desired number of rounds
      Random rand= new Random(); //generates a random number to use later for a canned response
        int num = rand.nextInt(1,4);
      String response = sc.nextLine();
      transcript.add(response);
      if (response.contains("I")||response.contains("you")||response.contains("your")||response.contains("me")||response.contains("myself")||response.contains("am")||response.contains("my")){
        //the words are replaced with temporary words to prevent issues with the replacement words being overwritten
        response= response.replaceAll("I", "tempY"); //tempY -> you
        response = response.replaceAll("your", "tempP");//tempP -> my
        response = response.replaceAll("you", "tempI");//tempI -> I
        response = response.replaceAll("me", "tempY");//tempY -> you
        response = response.replaceAll("myself", "SELF");//SELF-> yourself
        response = response.replaceAll("am", "tempR");//tempR -> are
        response = response.replaceAll("are", "tempAM");//tempAM -> am
        response = response.replaceAll("my", "tempUR");//tempUR -> your
        response= response.replaceAll("tempY", "you");
        response = response.replaceAll("tempI", "I");
        response = response.replaceAll("tempP", "my");
        response = response.replaceAll("tempY", "you");
        response = response.replaceAll("SELF", "yourself");
        response = response.replaceAll("tempR", "are");
        response = response.replaceAll("tempAM", "am");
        response = response.replaceAll("tempUR", "your");
        response = response.replaceAll("'m", "tempAP");
        response = response.replaceAll("'re", "TEMPRE");
        response = response.replaceAll("tempAP", "'re");
        response = response.replaceAll("TEMPRE", "'m");
        System.out.println(response + "?");
        transcript.add(response + "?");}
      else{ //if none of the mirror words are detected, a canned response is used instead
        if (num==1){
          System.out.println("That's wild!");
        transcript.add("That's wild!");}
        else if (num==2){
          System.out.println("Wow, tell me more!");
          transcript.add("Wow, tell me more!");}
          else if (num==3){
          System.out.println("I'm totally listening.");
          transcript.add("I'm totally listening.");}
        else if (num==4){
          System.out.println("This is such a fun conversation.");
          transcript.add("This is such a fun conversation.");}
        else{
          System.out.println("Oh, okay.");
          transcript.add("Oh, okay.");}
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

