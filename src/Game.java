import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Game {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        if (args.length % 2 != 1 || args.length < 3) {
            if (args.length % 2 != 1) System.out.println("Enter an odd number of possible combinations");
            else System.out.println("The args must be at least 3");
            return;
        }
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if (i != j && args[i].equals(args[j])) {
                    System.out.println(args[i] + " is repeated");
                    return;
                }
            }
        }

        new Rules(args.length ,args);
        Rules.playRound();
    }
}
