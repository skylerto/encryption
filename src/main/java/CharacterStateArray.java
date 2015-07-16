import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class CharacterStateArray {
    private ArrayList<CharacterState> stateArray;

    public CharacterStateArray(){
        this.stateArray = new ArrayList<CharacterState>();
    }

    public void add(CharacterState characterState){
        this.stateArray.add(characterState);
    }

    public void encrypted(CharacterState characterState){
        this.get(characterState).setState(1);
    }

    public void written(CharacterState characterState){
        this.get(characterState).setState(2);
    }



    /*  Encrypting Preparations */
    /**
     * Check to see if anything is encryptable.
     *
     * @return true if something is ready for encryption, false if otherwise.
     */
    public boolean anyEncryptable(){
        boolean encryptable = false;
        for(CharacterState c : stateArray){
            if(c.getState() == 0){
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
    public CharacterState getEncryptable(){
        CharacterState characterState = null;
        for(CharacterState c : stateArray){
            if(c.getState() == 0){
                return c;
            }
        }
        return characterState;
    }



    /* y so circular? */
    private CharacterState get(CharacterState characterState){
        return this.stateArray.get(this.stateArray.indexOf(characterState));
    }
}
