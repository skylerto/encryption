
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-13.
 *
 * Class defines all the write operations, i.e. outputting to a specified file.
 *
 */
public class MyWriter {

    private File out;
    public MyWriter(File outputFile){ this.out = outputFile; }


    public ArrayList write(ArrayList list){
        ArrayList array = new ArrayList();
        try {
            PrintWriter writer = new PrintWriter(this.out, "UTF-8");
            for(int i = 0; i < list.size(); i++){

                writer.print(list.get(i));
                array.add(list.get(i));


            }
            writer.close();
        } catch(Exception e){
           e.printStackTrace();
        }
        return array;
    }
}
