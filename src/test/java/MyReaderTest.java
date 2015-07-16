import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-13.
 *
 */
public class MyReaderTest extends TestCase {

    MyReader reader;

    public void setUp() throws Exception {
        super.setUp();
        reader = new MyReader(new File("test.txt"));

    }

    public void testReadChar(){
        assertEquals(true, reader.readChar().equals(new Character('T')));
        assertEquals(true, reader.readChar().equals(new Character('h')));
    }


    public void testRead(){
        char[] mess = {'T', 'h', 'i', 's',' '  , 'i', 's', ' ' , 'a', ' ' , 't', 'e', 's', 't','\n',
                'o', 'n', ' ' , 't', 'w', 'o', ' ' , 'l', 'i', 'n', 'e', 's', '.','\n'
        };
        ArrayList<Character> message = new ArrayList<Character>();
        for(char c: mess){
            message.add(c);
        }

        assertEquals(true, message.equals(reader.read()));
    }

    public void tearDown() throws Exception {

    }
}