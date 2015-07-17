import Encryption.Encryptor;
import MyHelpers.ReaderHelper;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class newTests {

    public static void main(String[] args) {

        Encryptor encryptor = new Encryptor("test.txt", "test.enc.txt");
        encryptor.doEncryption(2);

        Encryptor encryptorOther = new Encryptor("test.enc.txt","test.dec.txt");
        encryptorOther.doEncryption(-2);

    }
}
