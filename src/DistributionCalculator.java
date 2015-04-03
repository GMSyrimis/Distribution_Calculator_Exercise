import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by c4q-george on 4/1/15.
 */

public class DistributionCalculator {

    public static ArrayList<String> calculate(File rawInput) throws FileNotFoundException {
        // Scanner to read file
        Scanner in =  new Scanner(rawInput);
        String textFile = "";
        // writing file to string
        while(in.hasNextLine()){
            textFile+=in.nextLine().toLowerCase();
        }

        // USE REPLACE TO CLEAR UNWANTED PUNCTUATION
        // MUST BE ONLY CHARACTERS
        //Making sure no spaces come through
        textFile = textFile.replace(" ","");
        // decimal formatting machine
        NumberFormat machine = new DecimalFormat("#0.00");


        /*
        // Typecasting a number to char with ascii codes
        // source http://stackoverflow.com/questions/2047228/auto-increment-alphabet-in-java
        // Adding comments is useful but bulky
        for(int i=65;i<=90;i++) {
            System.out.println((char)i);
        }
        */


        //Hashmap of alphabet (KEY) and times repeated (VALUE)
        HashMap<Character,Double> alphabet = new HashMap<Character, Double>();
        for(char a = 'a'; a <= 'z'; a++) {
            alphabet.put(a,0.0);
        }
        //Looping through textFile to count letter frequency
        //Checking the HashMap for Characters and incrementing
        //Calculating percentage and putting it in
        for(int i=0; i < textFile.length(); i++){
            // tools
            double totalTextLength = (double) textFile.length();
            char currentChar = textFile.charAt(i);
            double characterCount = alphabet.get(currentChar);
            
            alphabet.put(currentChar,characterCount+1);

            // you can re-put things into the hashmap, Used to have 2 loops
            double updateCount = alphabet.get(currentChar);
            double percentage = 100.0/(totalTextLength/updateCount);
            alphabet.put(currentChar,percentage);
        }

        // Now to convert the HashMap of char and double to a String arrayList
        ArrayList<String> result = new ArrayList<String>();
        for(char letter = 'a'; letter <= 'z'; letter++) {
            double value = alphabet.get(letter);
            String completeString = Character.toString(letter) + " = " + machine.format(value)+"%";
            result.add(completeString);
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File rawFile = new File("src/text.txt");
        // Save the generated ArrayList
        ArrayList<String> distribution = calculate(rawFile);
        //repeatedly print it's contents
        for (String dist : distribution){
            System.out.println(dist);
        }
    }
}
