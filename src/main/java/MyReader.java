import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-13.
 *
 * Completes all the read operations on a given file.
 */
public class MyReader extends Thread {

    private File file;
    private FileInputStream inputStream;


    public MyReader(File file){
        this.file = file;
        try {
            this.inputStream = new FileInputStream(this.file);
        } catch (Exception e){
            System.out.println("Error initializing FileInputStream.\n       - Something wrong with input file.");
            e.printStackTrace();
        }
    }

    /**
     * Reads in a file char by char.
     *
     * @return
     */
    public ArrayList<Character> read(){
        ArrayList<Character> list = new ArrayList<Character>();
        try {

            FileInputStream fs = new FileInputStream(this.file);
            char current;
            while(fs.available() > 0){
                current = (char) fs.read();
                list.add(current);
            }


        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /* Synchronized get method */

    /**
     * Synchronized the reads from the file.
     *
     * @return The next Character from the input stream.
     */
    public synchronized Character readChar(){
        try {
            if(inputStream.available() > 0) {
                // add new CharacterState object to Data Structure.

                return new Character((char) inputStream.read());
            }
        } catch (Exception e){

            return new Character('\0');
        }

        return new Character('\0');
    }


}
