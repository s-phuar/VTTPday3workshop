package io;

import java.io.File;


public class ReadFileConsole {
    
    public static void main(String[] args){
        System.out.printf("args.length = %d\n", args.length);

        //pass in a file using code
        if(args.length <= 0 ){
            System.err.println("File name missing, please provide a file name");
            //anything other than system exit 1 e.g(System.exit(0)) means there is an error
            System.exit(1);
        }

        //run program with the below
            //java -cp classes io.FileMain src/io/catinthehat.txt 
            
        for(String a :args){
            System.out.printf("\n\n>>> Processing %s\n", a);
            
            //Path is a direction to that file, more powerful than File but requires more coding
                //Path p = Path.get(a);
                //File file = p.toFile();

            //File (catinthehat.txt) is the location at that place
            File file = new File(a);
            System.out.printf("path: %s\n", file.getAbsolutePath());
            System.out.printf("is file: %s\n", file.isFile());
            System.out.printf("exists: %s\n", file.exists());
            System.out.printf("write: %s\n", file.canWrite());



        }




    }
}
