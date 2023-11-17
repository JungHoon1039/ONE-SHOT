package oneshot.util;

import java.util.Random;

public class RandomCode {
    private static final int CODE_LENGTH = 10;
    private static final int LOWERCASE_A = 97;
    private static final int ALPHABET_SIZE = 26;
    private static final int DIGIT_SIZE = 10;

    public static String get() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < CODE_LENGTH; i++) {
            appendRandomly(stringBuffer);
        }
        return stringBuffer.toString();
    }

    private static void appendRandomly(StringBuffer stringBuffer) {
        Random random = new Random();
        if (random.nextBoolean()) {
            char randomChar = (char) (LOWERCASE_A + random.nextInt(ALPHABET_SIZE));
            stringBuffer.append(randomChar);
            return;
        }
        int randomNumber = random.nextInt(DIGIT_SIZE);
        stringBuffer.append(randomNumber);
    }
}
