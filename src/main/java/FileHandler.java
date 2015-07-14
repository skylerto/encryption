import java.io.File;
import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-14.
 */
public class FileHandler {

    private File in;    // Input file reference
    private File out;   // Output file reference

    /**
     * Constructs all things file handling.
     *
     * @param input - Path to input file
     * @param output - Path to output file
     */
    public FileHandler(String input, String output){
        this.in = new File(input);
        this.out = new File(output);
    }

    /**
     * Thread safe input reader
     *
     * @param list
     * @return
     */
    public synchronized ArrayList readInput(ArrayList list){
        MyReader reader = new MyReader(this.in);
        return new ArrayList(reader.read());
    }

    /**
     * Thread safe file writer
     *
     * @param list
     * @return
     */
    public synchronized ArrayList output(ArrayList list){
        MyWriter writer = new MyWriter(this.out);
        return new ArrayList(writer.write(list));
    }

    /* Getters and Setters */
    public File getOutFile() {
        return out;
    }

    public void setOutFile(File out) {
        this.out = out;
    }

    public File getInFile() {
        return in;
    }

    public void setInFile(File in) {
        this.in = in;
    }

}
