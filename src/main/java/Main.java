
import Encryption.Encryptor;
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

                Encryptor encryptor = new Encryptor(inFile, outFile);
                encryptor.doEncryption(key);

            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("encrypt", options);
            }


        } catch(Exception e){
            e.printStackTrace();
        }



    }






}
