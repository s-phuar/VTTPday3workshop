package io;

// import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//run file with
//java -cp classes io.ReadFileByte src/io/catinthehat.txt


public class ReadFileByte {

    public static void main(String[] args)
        throws FileNotFoundException, IOException//throws an exception
    {
        File file = new File(args[0]);

        //FileInputSteam only knows how to read regular bytes
        //theres GZIPInputStream, DataInputStream etc. for specific file types besides txt
        InputStream inputStream = new FileInputStream(file);

        //create buffer, byte[] array
        byte[] buffer = new byte[1024];

        //read the file while providing buffer. outputs -1 if there is nothing else to read
        int bytesRead = 0;
        int total = 0;
        
        while (bytesRead >= 0){
            bytesRead = inputStream.read(buffer);
            if(bytesRead >= 0){
                total += bytesRead;
            }
            System.out.printf(">>> bytes read: %d (%d)\n", bytesRead, total);
        }
        //after reading, close the input stream
        inputStream.close();

        //opening and reading datainputstream
        File fi = new File(args[0]);
        InputStream fis = new FileInputStream(fi);
        DataInputStream ois = new DataInputStream(fis);

        int totalWords = 0;

        while(true){
            //readLine reads a singular line
            String line = ois.readLine();
            //program will 'break' once we run out of lines to read e.g. null
            if(line == null){
                break;
            }
            System.out.printf(">>> line: %s\n", line.toUpperCase());
            String[] words = line.split(" ");
            totalWords += words.length;
        }

        System.out.printf(">>> total words: %s\n", totalWords);

        ois.close();

    }
    
}
