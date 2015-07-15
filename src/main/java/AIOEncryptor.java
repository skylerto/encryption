import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-14.
 *
 * All in one Encryptor, reads the file to an array, pops it out and puts it in place.
 */
public class AIOEncryptor {

    private File in;
    private File out;
    private int key;

    // Synchronized variables
    private ArrayList<Character> file = new ArrayList<Character>();
    private char current;
    private int position;

    public AIOEncryptor(String in, String out, int key){
        this.in = new File(in);
        this.out = new File(out);
        this.key = key;
    }

    public synchronized ArrayList<Character> getArray(){
        return file;
    }

    public synchronized char getChar(int index){
        return file.get(index);
    }

    public synchronized int getPosition(){
        return position;
    }


    public void encrypt(){
        synchronized (this){
            position++;
            file.add(this.encryptChar(current));
        }

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

    /**
     * Reads in a file char by char.
     *
     * @return
     */
    public void read(){
        try {

            FileInputStream fs = new FileInputStream(this.in);

            char current;
            while (fs.available() > 0) {
                current = (char) fs.read();
                synchronized (this) {
                    file.add(current);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }




}
