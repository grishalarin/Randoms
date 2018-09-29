import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class Randoms {

    private Random random = new Random();

    private char[] punctuationArray = {'?', '.', '!'};
    private char[] charArray = {'\r', '\n'};
    private char[] arrayChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private String[] upper = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] search = {};

    public Randoms(Random random) {
        this.random = random;
    }

    public Randoms() {
    }

    public void getFiles(String path, int n, int size, String[] words, int probability) {
        for (int i = 0; i < n; i++) {
            generateFile(path, i, size, words, probability);
        }
    }

    private void generateFile(String path, int n, int size, String[] word, int probability) {
        String fileName = path + "/" + UUID.randomUUID() + ".txt";
        createFillFile(fileName, n, size, word, probability);
    }

    private void createFillFile(String filename, int n, int size, String[] word, int probability) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename))) {
            for (int i = 0; i < size; i++) {
                bos.write(generateParagraph(word, size, probability).getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String generateParagraph(String[] word, int size, int probability) {
        StringBuilder newString = new StringBuilder();

        int a = random.nextInt(20) + 1;
        for (int i = 0; i < a; i++) {
            newString.append(generateNewSentence(word, size, probability));
        }
        newString.append(charArray);
        return newString.toString();
    }

    private String generateNewSentence(String[] words, int lenght, int probability) {
        StringBuilder stringBuilder = new StringBuilder();
        String word;
        int vBeforeComma = 0;
        int a = random.nextInt(15) + 1;

        for (int i = 0; i < a; i++) {

            if (vBeforeComma == 0) {
                vBeforeComma = random.nextInt(5) + 5;
                if (i != 0) {
                    stringBuilder.append(",");
                }
            } else --vBeforeComma;
            if (i != 0) {
                stringBuilder.append(" ");
            }
            if (1 == (random.nextInt(probability) + 1)) {
                word = words[random.nextInt(words.length)];

            } else {
                word = (generateWord());
            }
            if (i == 0) {
                StringBuilder sb = new StringBuilder(word);
                sb.replace(0, 1, String.valueOf(word.charAt(0)).toUpperCase());
                word = sb.toString();
            }
            stringBuilder.append(word);
        }
        return stringBuilder.toString() + newPunct() + " ";
    }

    private String generateWord() {
        StringBuilder stringBuilder = new StringBuilder();
        int size = random.nextInt(15) + 1;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(newChar());
        }
        return stringBuilder.toString();
    }

    private char newChar() {
        int numberofchar = random.nextInt(26);
        return arrayChar[numberofchar];
    }

    private char newPunct() {
        int numberofchar = random.nextInt(3);
        return punctuationArray[numberofchar];
    }

    private String newLit() {
        int numberofchar = random.nextInt(26);
        return upper[numberofchar];
    }
}