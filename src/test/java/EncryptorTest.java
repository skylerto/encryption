import DataStructure.CharacterState;
import Encryption.Encryptor;
import MyHelpers.EncryptionHelper;
import MyHelpers.ReaderHelper;
import MyHelpers.WriterHelper;
import junit.framework.TestCase;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class EncryptorTest extends TestCase {

    Encryptor encryptor;
    ReaderHelper readerHelper;
    EncryptionHelper encryptionHelper;
    WriterHelper writerHelper;

    int key;
    String inFile = "test.txt";
    String outFile = "test.enc.txt";

    public void setUp() throws Exception {
        key = 1;

        encryptor = new Encryptor(inFile, outFile);
        readerHelper = new ReaderHelper(inFile, encryptor);
        encryptionHelper = new EncryptionHelper(key, encryptor);
        writerHelper = new WriterHelper(outFile, encryptor);

        super.setUp();

    }

    public void tearDown() throws Exception {
        encryptor = null;
        readerHelper = null;
        encryptionHelper = null;
        writerHelper = null;
    }

    /*  Reader Tests    */
    public void testMoreInput(){
        assertEquals(true, readerHelper.moreInput() == (true || false));
    }

    public void testReadChar(){
        assertEquals(true, readerHelper.readChar().getClass().equals(CharacterState.class) || readerHelper.readChar().equals(null));
    }


    /*  Encryptor Tests */

    /*  Writer Tests   */


}