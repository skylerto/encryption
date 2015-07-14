import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by skylerlayne on 2015-07-14.
 *
 * Test scenarios for encryptor.
 *
 */
public class MyEncryptorTest extends TestCase {


    MyEncryptor encryptor;
    MyEncryptor decryptor;
    int key = 2;

    public void setUp() throws Exception {
        super.setUp();
        encryptor = new MyEncryptor(key);
        decryptor = new MyEncryptor(-key);

    }

    public void testEncryptsChar(){
        char character = 'c';
        assertEquals(true, encryptor.encryptChar(character) == (char) ((((int) character - 32) + 2 * 95 + this.key) % 95 + 32));
    }

    public void testReverseEncryptsChar(){
        char character = 'c';
        assertEquals(true, decryptor.encryptChar(encryptor.encryptChar(character)) == character);

    }

    public void testEncrypts(){
        char[] mess = {'j', 'u', 's', 't', ' ', 'a', ' ', 'f', 'e', 'w', ' ', 'w', 'o', 'r', 'd', 's', '.'};

        ArrayList<Character> message = new ArrayList<Character>();
        for(char c : mess){
            message.add(c);
        }

        ArrayList encrypted = new ArrayList();
        for (int i = 0; i < message.size(); i++){
            encrypted.add(encryptor.encryptChar(message.get(i)));
        }

        assertEquals(true, encrypted.equals(encryptor.encrypt(message)));
    }

    public void testDecrypts(){
        char[] mess = {'j', 'u', 's', 't', ' ', 'a', ' ', 'f', 'e', 'w', ' ', 'w', 'o', 'r', 'd', 's', '.'};

        ArrayList message = new ArrayList();
        for(char c : mess){
            message.add(c);
        }


        assertEquals(true, message.equals(decryptor.encrypt(encryptor.encrypt(message))));
    }

    public void tearDown() throws Exception {
        encryptor = null;
        decryptor = null;
    }

}