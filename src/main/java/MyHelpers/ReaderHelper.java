package MyHelpers;

import DataStructure.CharacterState;
import DataStructure.CharacterStateArray;
import Encryption.Encryptor;

import java.io.FileInputStream;
import java.*;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class ReaderHelper implements Runnable {

    private String inputFile;
    private FileInputStream inputStream;
    private Thread t;
    private Encryptor encryptor;

    /**
     * Constructor creates a FileInputStream from the given file name.
     *
     * @param fileName - input file name.
     */
    public ReaderHelper(String fileName, Encryptor enc){
        this.encryptor = enc;
        this.inputFile = fileName;
        try {
            this.inputStream = new FileInputStream(this.inputFile);
        } catch (Exception e){
            System.out.println("Error initializing FileInputStream.\n       - Something wrong with input file.");
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(this.moreInput()) {
            synchronized (this) {

                CharacterState current = this.readChar();
                //System.out.println("Character: " + current.getCharacter() + "State: " + current.getState() + "Position: " + current.getPosition());
                encryptor.add(current);
            }
        }
        encryptor.toString();
    }

    public void start(){
        t = new Thread(this);
        t.start();
    }

    public void join(){
        try{
            t.join();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized boolean moreInput(){
        try {
            return inputStream.available() > 0;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Synchronized the reads from the file.
     *
     * @return The next Character from the input stream.
     */
    public synchronized CharacterState readChar(){
        CharacterState state = null;
        try {
            //if(inputStream.available() > 0) {
                char c = (char) inputStream.read();
                //System.out.print(c);
                state = new CharacterState(c, inputStream.getChannel().position());
          //  }
        } catch (Exception e){
            e.printStackTrace();
            state = null;
        }
        return state;
    }
}
