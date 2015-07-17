package DataStructure;

import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class CharacterStateArray {
    private ArrayList<CharacterState> stateArray;

    public CharacterStateArray(){
        this.stateArray = new ArrayList<CharacterState>();
    }

    public synchronized void add(CharacterState characterState){
        this.stateArray.add(characterState);
    }

    public synchronized void encrypted(CharacterState characterState){
        this.get(characterState).setState(1);
    }

    public synchronized void written(CharacterState characterState){
        this.get(characterState).setState(2);
    }



    /*  Encrypting Preparations */
    /**
     * Check to see if anything is encryptable.
     *
     * @return true if something is ready for encryption, false if otherwise.
     */
    public synchronized boolean anyEncryptable(){
        boolean encryptable = false;
        for(CharacterState c : stateArray) {
            if (c.getState() == 0) {
                return true;
            }

        }
        return encryptable;
    }

    /**
     * Get the first value ready to be encrypted.
     *
     * @return Return the first encryptable
     */
    public synchronized CharacterState getEncryptable(){
        CharacterState characterState = null;
        for(CharacterState c : stateArray){
            if(c.getState() == 0){
                return c;
            }
        }
        return characterState;
    }

        /*  Writing Preparations */
    /**
     * Check to see if anything is encryptable.
     *
     * @return true if something is ready for encryption, false if otherwise.
     */
    public synchronized boolean anyWritable(){
        boolean encryptable = false;
        for(CharacterState c : stateArray){
            if(c.getState() == 1){
                return true;
            }
        }
        return encryptable;
    }

    /**
     * Get the first value ready to be encrypted.
     *
     * @return Return the first encryptable
     */
    public synchronized CharacterState getWritable(){
        CharacterState characterState = null;
        for(CharacterState c : stateArray){
            if(c.getState() == 1){
                return c;
            }
        }
        return characterState;
    }

    public synchronized boolean outputReady(){
        boolean ready = true;
        for(CharacterState c : stateArray){
            if(c.getState() != 2){
                return false;
            }
        }
        return ready;
    }

    public synchronized CharacterState get(int index){
        return this.stateArray.get(index);
    }

    @Override
    public synchronized String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(CharacterState c : stateArray){
            //System.out.print(c.getCharacter());
            stringBuilder.append(c.getCharacter());
        }
        //System.out.print(stringBuilder.toString());
        //return
        return stringBuilder.toString();
    }

    public synchronized int size(){
        return stateArray.size();
    }


    /* y so circular? */
    private synchronized CharacterState get(CharacterState characterState){
        return this.stateArray.get(this.stateArray.indexOf(characterState));
    }
}
