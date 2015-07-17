package MyHelpers;

import DataStructure.CharacterState;
import Encryption.Encryptor;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class WriterHelper implements Runnable {

    private String outFile;
    private Encryptor encryptor;
    private Thread t;
    private PrintWriter writer;
    private ArrayList<Character> array;

    public WriterHelper(String fileName, Encryptor enc){
        this.outFile = fileName;
        this.encryptor = enc;
        this.array = new ArrayList<Character>();
        try {
            this.writer = new PrintWriter(new File(this.outFile), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void write(){
        for(Character c: array) {
            this.writer.print(c);
        }
    }

    @Override
    public void run() {
        CharacterState c;

        while(!encryptor.getArray().outputReady()){
            synchronized (this) {
                while (encryptor.getArray().anyWritable()) {
                    c = encryptor.getArray().getWritable();
                    array.add((int) c.getPosition(), c.getCharacter());
                    encryptor.getArray().written(c);
                }
            }
        }
        this.write();

    }

    public void start(){
        t = new Thread(this);
        t.start();
    }

    public void join(){
        try{
            writer.close();
            t.join();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
