import java.util.Random;

class Utils {

    private Random random = new Random();
    private char[] arrayChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] punctuationArray = {'?', '.', '!'};


    char newChar() {
        int numberofchar = random.nextInt(26);
        return arrayChar[numberofchar];
    }

    char newPunct() {
        int numberofchar = random.nextInt(3);
        return punctuationArray[numberofchar];
    }
}
