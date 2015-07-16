package MyHelpers;

import DataStructure.CharacterState;
import Encryption.Encryptor;

import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class EncryptionHelper implements Runnable {

    private int key;
    private Encryptor encryptor;
    private Thread t;

    public EncryptionHelper(int key, Encryptor enc){
        this.key = key;
        this.encryptor = enc;
    }



    public synchronized ArrayList encrypt(ArrayList<Character> list){
        ArrayList<Character> array = new ArrayList<Character>();

        for(char c: list){
            array.add(this.encryptChar(c));
        }

        return array;
    }

    protected char encryptChar(char character){

        if(this.key >= 0 && character>31 && character<127)
        {
            character = (char) ((((int) character-32) + 2 * 95 + this.key)%95+32);
        } else if (this.key < 0 &&character>31 && character<127 ) {
            character = (char) ((((int)character-32)+2*95-(-1*this.key))%95+32);
        }

        return character;

    }

    @Override
    public void run() {
        CharacterState c;
        synchronized (this) {

            while (encryptor.getArray().anyEncryptable()) {
                c = encryptor.getArray().getEncryptable();
                c.setCharacter(this.encryptChar(c.getCharacter()));
                encryptor.getArray().encrypted(c);
            }
        }
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
}
