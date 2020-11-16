import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();  
        int Q = in.nextInt(); 

        Map<String, String> lookupTable = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String EXT = in.next(); 
            String MT = in.next(); 

            lookupTable.putIfAbsent(EXT.toLowerCase(), MT);
        }

        in.nextLine();

        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine();  
            String mimeType = FNAME.substring(FNAME.lastIndexOf('.') + 1).toLowerCase();

            if (!FNAME.contains(".") || !lookupTable.containsKey(mimeType)) {
                System.out.println("UNKNOWN");
            } else {
                System.out.println(lookupTable.get(mimeType));
            }
        }
    }
}
