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

//please note that bufferedReader and bufferedWriter can function independently
//Only use this file for normal bufferedReading and bufferedWriting. The loop is useful for assignements
//Interaction between the 2 blocks of code is buggy, so look at set of other Main files

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

        //******java -cp classes io.workshopMain src/io/doginthehat.txt src/io/ratinthehat.txt*********

        //Input includes the absolute path + file name. If we only have filename we are using a relative path
        BufferedReader br = new BufferedReader(new FileReader(Input));
        System.out.println(br.readLine()); // reads only 1 line
        
        //Output includes the absolutepath + file name. if we only have filename we are using a relative path
        FileWriter bw = new FileWriter(Output);
        BufferedWriter wFile = new BufferedWriter(bw);
        wFile.write("testing\n");
        
        //test reading the written file
            // BufferedReader wr = new BufferedReader(new FileReader(Output));
            // System.out.println(wr.readLine());
            // wr.close();
        
        //****************************************************************************/
        //

        //create set of strings
        Set <String> uniqueWords = new HashSet<>();

        //create a map
        Map<String, Integer> uniquelyWords = new HashMap<>();


        //force a non-null state
        String line = "x";
        while(null != line){
            //Read a single line from br, this while be looped for each line of word, transformed and added to 'uniqueWords'/
            line = br.readLine();

            //if line is null we have reach the End of the file
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

            //write the transformed uniqueWords to file, includes the write at line 45
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
