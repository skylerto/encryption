package DataStructure;

import junit.framework.TestCase;

/**
 * Created by skylerlayne on 2015-07-17.
 */
public class CharacterStateTest extends TestCase {

    CharacterState characterState;

    public void setUp() throws Exception {
        characterState = new CharacterState('c',1);
        super.setUp();

    }

    public void tearDown() throws Exception {
        characterState = null;
    }

    public void testGetState() throws Exception {
        System.out.println("***Testing getState()***");
        assertEquals(true, characterState.getState() == 0);
    }

    public void testSetState() throws Exception {
        System.out.println("***Testing setState()***");
        characterState.setState(1);
        assertEquals(true, characterState.getState() == 1);
    }

    public void testGetPosition() throws Exception {
        System.out.println("***Testing getPosition()***");
        assertEquals(true, characterState.getPosition() == 1);

    }

    public void testGetCharacter() throws Exception {
        System.out.println("***Testing getCharacter()***");
        assertEquals(true, 'c' == characterState.getCharacter());

    }

    public void testSetCharacter() throws Exception {
        System.out.println("***Testing getCharacter()***");
        characterState.setCharacter('d');
        assertEquals(true, characterState.getCharacter() == 'd');

    }

    public void testToString() throws Exception {
        System.out.println("***Testing toString()***");
        assertEquals(true, characterState.toString().equals( " Character: c\n" + " State: 0\n" + " Position: 1"));

    }
}