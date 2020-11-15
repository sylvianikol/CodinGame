import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String MESSAGE = reader.readLine();

        byte[] bytes = MESSAGE.getBytes();

        StringBuilder finalBinary = new StringBuilder();

        for (byte b :bytes){

            StringBuilder currentBinary = new StringBuilder();

            int currentValue = b;

            for (int i = 0; i < 8; i++) {
                currentBinary.append((currentValue & 128) == 0 ? 0 : 1);
                currentValue <<= 1;
            }

            if (currentBinary.charAt(0) == '0') {
                currentBinary.delete(0, 1);
            }

            finalBinary.append(currentBinary);
        }


        char[] chars = finalBinary.toString().toCharArray();

        StringBuilder answer = new StringBuilder();

        int index = 0;

        while (index < chars.length) {

            int count = 0;
            answer.append("0");

            if (chars[index] == '0') {
                answer.append("0");
            }

            char current = chars[index];

            while (index < chars.length && chars[index] == current) {
                ++index;
                ++count;
            }

            answer.append(" ").append("0".repeat(count)).append(' ');
        }

        System.out.println(answer.toString().trim());
    }
}
