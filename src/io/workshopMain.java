package io;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.InputStream;
// import java.io.DataInputStream;
// import java.io.ObjectInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class workshopMain {
    
    public static void main(String[] args)
    throws IOException, FileNotFoundException
    {

        //FileReader is specifically designed to read text files, includes charset support
        // BufferedReader object takes a FileReader object as an input
        // FileReader file = new FileReader(args[0]);
        // BufferedReader bFile= new BufferedReader(file); 

        String Input = args[0];
        String Output = args[1];

        BufferedReader br = new BufferedReader(new FileReader(Input));
        System.out.println(br.readLine()); // reads only 1 line
        
        //writer replaces file of same name, created under day3workshop
        FileWriter bw = new FileWriter(Output);
        BufferedWriter wFile = new BufferedWriter(bw);
        wFile.write("good doggie\n");
        
        //test readering the written file
            // BufferedReader wr = new BufferedReader(new FileReader(Output));
            // System.out.println(wr.readLine());
            // wr.close();
        
        //****************************************************************************/
        //java -cp classes io.workshopMain src/io/doginthehat.txt src/io/ratinthehat.txt

        //create set of strings
        Set <String> uniqueWords = new HashSet<>();

        //create a map
        Map<String, Integer> uniquelyWords = new HashMap<>();


        //force a non-null state
        String line = "x";
        while(null != line){
            //Read a line
            line = br.readLine();

            //if line is nullm we have reach the EOF
            if(null == line)
                break;

            
            //System.out.printf(">>> line: %s\n", line.toUpperCase());
            String transformed = line.replaceAll(" \\p{Punct}","").toLowerCase().trim();
            for(String word : transformed.split(" "))
                uniqueWords.add(word);

            for(String word: transformed.split(" ")){
                int currentCount = 0;
                if(uniquelyWords.containsKey(word)){
                    currentCount = uniquelyWords.get(word);
                }
                currentCount++;
                uniquelyWords.put(word, currentCount);


                // if(uniquelyWords.containsKey(word)){
                //     //word is found in list
                //     int currentCount = uniquelyWords.get(word);
                //     currentCount ++;
                //     uniquelyWords.put(word, currentCount);

                // }
                // else{
                //     //word is NOT found in list
                //     uniquelyWords.put(word, 1);
                // }

            }

            //write to file
            wFile.write(transformed + "\n");
        }


        //flush remaining data to file
        wFile.flush();
        wFile.close();

        //close the files
        br.close();

        System.out.printf("Unique words in %s: %d\n", Input, uniqueWords.size());

        for(String word: uniqueWords){
            System.out.printf("%s ", word);
        }

        System.out.println();
        for(String word: uniquelyWords.keySet()){
            System.out.printf("%s\t\t %d\n", word, uniquelyWords.get(word));
        }


        //implement stopword removal
        //print key set in alphabetical order/count order
        //convert the deck of cards to use List
        //process file: for every category -> print out the highest rated app, lowest rated app and average rating for that category
        //find the next word distribution, predict what is the next word that will come out(next word distribution, charles dickens)
    }


}
