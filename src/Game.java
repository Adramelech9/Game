import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Game {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        new Rules();
        Rules.playRound();
    }
}
