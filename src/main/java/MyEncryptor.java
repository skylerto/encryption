import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-13.
 *
 * Class defines how a file should be encrypted with a given key.
 *
 */
public class MyEncryptor {


    private int key;

    public MyEncryptor(int key){
        this.key = key;
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
}
