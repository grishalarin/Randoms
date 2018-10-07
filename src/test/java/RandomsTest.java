import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class RandomsTest {

    private Utils utils = Mockito.mock(Utils.class);
    private Randoms randoms;
    private String filepath = "file://any";
    private int n = 1;
    private int size =1;
    private String[] words = {};
    private int probability = 1;


    @BeforeEach
    void setUp() {
        randoms = new Randoms(utils);
    }

    @RepeatedTest(50)
    void generateWord() {
        when(utils.newChar()).thenReturn('s');
        String s = randoms.generateWord();
        assertTrue(s.length() >= 1 && s.length() <= 15);
    }

}

