package Encryption;

import DataStructure.CharacterState;
import DataStructure.CharacterStateArray;
import MyHelpers.EncryptionHelper;
import MyHelpers.ReaderHelper;
import MyHelpers.WriterHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-16.
 *
 */
public class Encryptor {

    private String inputFileName;
    private String outputFileName;
    private CharacterStateArray array;// = new CharacterStateArray();

     ReaderHelper readerHelper;

    public EncryptionHelper getEncryptionHelper() {
        return encryptionHelper;
    }

    public ReaderHelper getReaderHelper() {
        return readerHelper;
    }

    EncryptionHelper encryptionHelper;
    WriterHelper writerHelper;

    public Encryptor(String inputFile, String outputFile) {
        this.inputFileName = inputFile;
        this.outputFileName = outputFile;
        this.array = new CharacterStateArray();
    }

    public void doEncryption(int key){
        this.read();
        this.encrypt(key);
        this.write();
        this.join();
    }

    public void read(){
        readerHelper = new ReaderHelper(this.inputFileName, this);
        readerHelper.start();
    }

    public void encrypt(int key) {
        encryptionHelper = new EncryptionHelper(key, this);
        encryptionHelper.start();

    }

    public void write(){
        writerHelper = new WriterHelper(this.outputFileName, this);
        writerHelper.start();

    }

    public void join(){
        readerHelper.join();
        encryptionHelper.join();
        writerHelper.join();
    }

    public synchronized boolean output(){
        boolean ready = false;
        synchronized(this){
            for(int a = 0; a < this.getArray().size(); a++){
                return this.getArray().outputReady();
            }
        }
        return ready;
    }

    public synchronized boolean doneEncrypting(){
        boolean ready = false;
        synchronized (this){
            for(int a = 0; a < this.getArray().size(); a++){
                return this.getArray().anyEncryptable();
            }
        }
        return false;
    }


    /* Getters */
    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void add(CharacterState state){
        //System.out.println("Character: " + state.getCharacter() + "State: " + state.getState() + "Position: " + state.getPosition());
        this.array.add(state);
    }
    public synchronized String toString(){
      //  System.out.print(this.array.toString());
        return this.array.toString();
    }

    public CharacterStateArray getArray(){
        return this.array;
    }
}
