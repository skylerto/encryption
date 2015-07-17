package DataStructure;

import junit.framework.TestCase;

/**
 * Created by skylerlayne on 2015-07-17.
 */
public class CharacterStateArrayTest extends TestCase {

    CharacterStateArray array;

    public void setUp() throws Exception {
        array = new CharacterStateArray();
        CharacterState one = new CharacterState('a', 1);
        CharacterState two = new CharacterState('b', 2);
        CharacterState three = new CharacterState('c', 3);
        array.add(one);
        array.add(two);
        array.add(three);

        super.setUp();

    }

    public void tearDown() throws Exception {
        array = null;

    }

    public void testAdd() throws Exception {
        CharacterState one = new CharacterState('d', 4);
        array.add(one);
        assertEquals(true, array.get(3).equals(one));
    }

    public void testEncrypted() throws Exception {
        array.encrypted(array.get(1));
        assertEquals(true, array.get(1).getState() == 1);
    }

    public void testWritten() throws Exception {
        array.written(array.get(1));
        assertEquals(true, array.get(1).getState() == 2);
    }

    public void testAnyEncryptable() throws Exception {
        assertEquals(true, array.anyEncryptable());
    }

    public void testGetEncryptable() throws Exception {
        CharacterState one = array.get(0);
        assertEquals(true, array.getEncryptable().equals(one));
    }

    public void testAnyWritable() throws Exception {
        array.encrypted(array.get(0));
        assertEquals(true, array.anyWritable());

    }

    public void testGetWritable() throws Exception {
        array.encrypted(array.get(0));
        CharacterState one = array.get(0);
        assertEquals(true, array.getWritable().equals(one));

    }

    public void testOutputReady() throws Exception {
        array.written(array.get(0));
        array.written(array.get(1));
        array.written(array.get(2));
        assertEquals(true, array.outputReady());
    }

    public void testGet() throws Exception {
        CharacterState one = array.get(0);
        assertEquals(true, array.get(0).equals(one));

    }

    public void testToString() throws Exception {
        assertEquals(true, array.toString().equals("abc"));
    }

    public void testSize() throws Exception {
        assertEquals(true, array.size() == 3);
    }
}