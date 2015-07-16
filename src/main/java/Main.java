
import org.apache.commons.cli.*;


import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static ArrayList list;

    public static void main(String[] args) {

        String inFile;
        String outFile;
        int key;

        Options options = new Options();
        options.addOption("in", true, "input file name");
        options.addOption("out", true, "output file name");
        options.addOption("key", true, "integer encryption value");

        CommandLineParser parser = new GnuParser();
        try {

            CommandLine cmd = parser.parse(options, args);


            if(cmd.hasOption("in") && cmd.hasOption("out") && cmd.hasOption("key")) {

                // get c option value
                inFile = cmd.getOptionValue("in");
                outFile = cmd.getOptionValue("out");
                key = Integer.parseInt(cmd.getOptionValue("key"));



                list = new ArrayList();


                FileHandler fileHandler = new FileHandler(inFile, outFile);

                MyEncryptor encryptor = new MyEncryptor(key);

                ArrayList inputList = fileHandler.readInput(list);

                if(inputList.get(0).getClass().equals(Character.class)) {
                    ArrayList encryptList = encryptor.encrypt(inputList);
                    ArrayList outList = fileHandler.output(encryptList);
                } else {
                    System.out.println("Encryption failed, our fault!");
                }



            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("encrypt", options);
            }


        } catch(Exception e){
            e.printStackTrace();
        }



    }






}
