package DataStructure;

/**
 * Created by skylerlayne on 2015-07-16.
 */
public class CharacterState {
    private char character;
    private int state; //0 = read for encryption, 1 = read for output, 2 = finished
    private long position;

    public CharacterState(char character, long position){
        this.character = character;
        this.position = position;
        this.state = 0;
    }


    /* Getters and Setters */
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getPosition() {
        return position;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String toString(){
        return " Character: " + this.character + "\n"
                + " State: " + this.state + "\n"
                + " Position: " + this.position;
    }
}
