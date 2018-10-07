import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    Utils utils = new Utils();
    private char[] arrayChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] punctuationArray = {'?', '.', '!'};

    @RepeatedTest(50)
    void newChar() {
        char character = utils.newChar();
        boolean bol = false;
        for (int i = 0; i < arrayChar.length; i++) {
            if (character == arrayChar[i]) {
                bol = true;
                break;
            }
        }
        assertTrue(bol);
    }

    @RepeatedTest(50)
    void checkIOBExptnChar(){
        assertDoesNotThrow(()->utils.newChar());
    }

    @RepeatedTest(50)
    void newPunct() {
        char character = utils.newPunct();
        boolean bol = false;
        for (int i = 0; i < punctuationArray.length; i++) {
            if (character == arrayChar[i]){
                bol = true;
                break;
            }
        }
        assertTrue(bol);
    }
    @RepeatedTest(50)
    void checkIOBExptnPunct(){
        assertDoesNotThrow(()->utils.newPunct());
    }
}