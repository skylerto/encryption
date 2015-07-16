
import MyHelpers.ReaderHelper;
import junit.framework.TestCase;

/**
 * Created by skylerlayne on 2015-07-16.
 *
 */
public class ReaderHelperTest extends TestCase {

    ReaderHelper readerHelper;
    public void setUp() throws Exception {
        //readerHelper = new ReaderHelper("test.txt");
        super.setUp();

    }

    public void tearDown() throws Exception {
        readerHelper = null;
    }

    public void testRun() throws Exception {
        readerHelper.start();
        Thread.sleep(1000);
    }

    public void testReadChar() throws Exception {

    }
}