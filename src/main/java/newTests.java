import Encryption.Encryptor;
import MyHelpers.ReaderHelper;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class newTests {

    public static void main(String[] args) {

        Encryptor encryptor = new Encryptor("test.txt", "test.enc.txt");

      //  System.out.println("Before: " + encryptor.toString());
        encryptor.read();
        encryptor.getReaderHelper().join();
        System.out.println("Reading: " + encryptor.toString());

        encryptor.encrypt(2);
        encryptor.getEncryptionHelper().join();
        System.out.println("Encrypting: " + encryptor.toString());


        System.out.println("Writing: " + encryptor.toString());


        encryptor.join();

    }
}
