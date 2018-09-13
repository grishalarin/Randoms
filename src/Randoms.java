import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class Randoms {

    private Random random = new Random();
    private char[] punctuationArray = {'?', '.', '!'};
    private char[] arrayChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Randoms(Random random) {
        this.random = random;
    }

    public Randoms() {

    }
    public void getFiles(String path, int n, int sizeSentence, String word, int Probability) {
            generateFile(path, n, sizeSentence,word, Probability);

    }

    private void generateFile(String path, int n, int sizeSentence, String word, int probability) {
        n = random.nextInt(1/probability);
        String fileName = path + "/" + UUID.randomUUID() + ".txt";
        createFillFile(fileName, n, word, probability);
    }

    private void createFillFile(String filename, int size,String word,int probability){
        try (FileOutputStream out = new FileOutputStream(filename); BufferedOutputStream bos = new BufferedOutputStream(out)){
            int counter = 0;
            int counter2 = 1;
            while (fileIsBigEnough(filename,size,false)){
                counter++;
                counter2++;
                if ((counter > 100_000) && (size > 100_000_000)) {
                    counter = 0;
                    fileIsBigEnough(filename, size, true);
                }
                String newSentence = generateParagraph(word,size,probability);
                if (counter2 > 10) {
                    counter2 = 0;
                    newSentence = newSentence + "\r\n";
                }
                byte[] buffer = newSentence.getBytes();
                bos.write(buffer, 0, buffer.length);
                bos.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            }

        }



    private boolean fileIsBigEnough(String file, int size, boolean log) {
        File f = new File(file);
        long len = f.length();
        if (log) {
            System.out.println("Size: " + len + " of " + size);
        }
        return len < size ? false : true;
    }

    public String generateParagraph(String word, int lenght, int probability){
        StringBuilder newString = new StringBuilder();
        int size = random.nextInt(21)+1;

        for (int i = 0; i < size; i++) {
            newString.append(generateNewSentence(word,lenght,probability),'\r','\n');
        }
        return newString.toString();
    }

    public String generateNewSentence(String word,int lenght, int probability) {

        StringBuilder newString = new StringBuilder();
        char comma = ',';
        int size = random.nextInt(16) + 1;
        newString.append(newLit());
        newString.append(generateWord(word,probability,true));
            for (int i = 0; i < size; i++) {
                newString.append(comma);
                for (int j = 0; j < size; j++) {
                    newString.append(" ");
                    newString.append(generateWord(word,probability,true));
                }
            }
        newString.append(newPunct());
        return newString.toString();
    }

    public StringBuilder generateWord(String word, int probability,boolean first) {

        if ((random.nextInt(probability) == 1) && (!first)) {
            return new StringBuilder(word);
        }
        StringBuilder out = new StringBuilder();

        int size = random.nextInt(16) + 1;
        for (int i = 0; i < size; i++) {
            out.append(newChar(word));
        }
        return out;
    }


    public char newChar(String string) {

        int numberofchar = random.nextInt(26);
        return arrayChar[numberofchar];
    }

    public char newPunct() {

        int numberofchar = random.nextInt(3);
        return punctuationArray[numberofchar];
    }

    public char newLit() {

        int numberofchar = random.nextInt(26);
        return upper[numberofchar];
    }
}



