package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;


// https://gist.github.com/sebleier/554280

public class RemoveStopWordsMain {

    public static void main(String[] args)
    throws IOException, FileNotFoundException{
        BufferedReader bufferedRead = new BufferedReader(new FileReader("src/io/catinthehat.txt"));
        BufferedReader stopWords = new BufferedReader(new FileReader("src/io/stopwords-en.txt"));

        Writer writer = new FileWriter("src/io/batinthehat.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        //create unordered hashset of stopswords
        HashSet <String> listOfStops = new HashSet<String>();
        String sline = stopWords.readLine();
        while(sline != null){
            listOfStops.add(sline);
            //read the next line, else infinite loop
            sline = stopWords.readLine();
        }

        //force start while loop


        String line = "x";
        while(line != null){
            //ensure lineRead is fresh for each line being processed, if not words from previous iterations will stay
            List<String> lineRead = new ArrayList<String>();
            //read next line (1st line of txt document) into line
            line = bufferedRead.readLine();

            //check for end of the file
            if(line == null)
                break;
            
            //loop to add non-stopwords to lineRead arraylist
            for(String words: line.split(" ")){
                if(!listOfStops.contains(words.toLowerCase())){
                    lineRead.add(words);
                }

            }

            bufferedWriter.write(String.join(" ", lineRead) + "\n");
            

        }

        bufferedRead.close();
        stopWords.close();
        bufferedWriter.close();


    }

}
    
