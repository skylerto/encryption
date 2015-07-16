import Encryption.Encryptor;
import junit.framework.TestCase;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class EncryptorTest extends TestCase {

    Encryptor encryptor;
    int key;

    public void setUp() throws Exception {
        encryptor = new Encryptor("test.txt", "test.enc.txt");
        key = 1;
        super.setUp();

    }

    public void tearDown() throws Exception {
        encryptor = null;
    }

    /**
     * Test if input and output are different given the key is not 0
     * @throws Exception
     */
    public void testEncryptPutsDifferent() throws Exception {
        //assertEquals(key != 0, encryptor.getInput() != encryptor.getOutput());
    }


}