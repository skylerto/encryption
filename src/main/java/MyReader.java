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


    public MyReader(File file){
        this.file = file;
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


}
