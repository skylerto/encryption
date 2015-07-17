package MyHelpers;

import DataStructure.CharacterState;
import Encryption.Encryptor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class WriterHelper implements Runnable {

    private String outFile;
    private Encryptor encryptor;
    private Thread t;
    private PrintWriter writer;
    private Map array;

    public WriterHelper(String fileName, Encryptor enc){
        this.outFile = fileName;
        this.encryptor = enc;
        this.array = new HashMap();
        try {
            this.writer = new PrintWriter(new File(this.outFile), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void write(){
        for(long i = 0; i < array.size(); i++){
            this.writer.print(array.get(i + 1));
        }
    }

    @Override
    public void run() {
        CharacterState c;
        while (!encryptor.output()) {
            synchronized (this) {
                if ((c = encryptor.getArray().getWritable()) != null) {
                    array.put(c.getPosition(), c.getCharacter());
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
            t.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        writer.close();
    }


}
