import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Rules {
    static Scanner scanner = new Scanner(System.in);
    public static int countUser = 0;
    public static int countPC = 0;
    public static int draws = 0;
    public static String[] args;

    private static int[] sequence = RandomKey.getSequence();
    private static int num;

    Rules(int num, String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        this.args = args;
        this.num = num;
        new RandomKey(this.num);
    }
    public static int getInt(){
        int num;
        if(scanner.hasNextInt()){
                num = scanner.nextInt();

        } else {
            System.out.println("You made a mistake entering the number. Try again.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

   static String playRound() throws NoSuchAlgorithmException, InvalidKeyException {
        int numUser;
        int num1;
        int num2;
       System.out.println("Available moves:");
       for (int j = 0; j < num; j++) {
           System.out.println(j + 1 + " - " + args[j]);
       }
       System.out.println("0 - exit\n911 - learn the rules");
       System.out.print("HMAC: ");
        for (int i = 0; i < 128; i++) {
            new RandomKey(i, 1);
            System.out.println("Enter your move: " + (i + 1));
            if(scanner.hasNextInt()) {

            } else {
                System.out.println("You made a mistake entering the number. Try again.");
                scanner.next();
                num = getInt();
            }
            numUser = scanner.nextInt();
            if (numUser == 911) {
                new TableHelp(num, args);
                i--;
                continue;
            }

            if (numUser < 0 || numUser > num) {
                System.out.println("You need select a positive number and < " + (num + 1));
                System.out.println("or 911 for help");
                numUser = getInt();
                if (numUser == 911) {
                    new TableHelp(num, args);
                    i--;
                    continue;
                }
            if (numUser < 0 || numUser > num ) {
                System.out.println("try again. 911 for help");
                numUser = getInt();
                if (numUser == 911) {
                    new TableHelp(num, args);
                    i--;
                    continue;
                }
                if (numUser < 0 || numUser > num) {
                    System.out.println("attempts ended");
                    break;
                    }
                }
            }
            if (numUser == 0) break;
            if (numUser == sequence[i]) {
                System.out.println("draw, Computer move: " + args[sequence[i] - 1]);
                System.out.println("Key: " + RandomKey.getKey());
                System.out.println("---------------");
                System.out.print("HMAC: ");
                draws++;
                continue;
            } if (numUser - sequence[i] > num / 2 || sequence[i] - numUser > num / 2) {
                num1 = -num;
                num2 = -sequence[i];
            } else {
                num1 = num;
                num2 = sequence[i];
            }
            if (num1 > num2) {
                countPC++;
                System.out.println("You lose!");
            } else {
                countUser++;
                System.out.println("You win!");
            }
            System.out.println("You selected: " + args[numUser - 1] + ", Computer selected: " + args[sequence[i] - 1]);
            System.out.println("HMAC key: " + RandomKey.getKey());
            System.out.println("---------------------------------------------");
            System.out.print("HMAC: ");


        }
        System.out.println("score: " + countUser + " WINS | " + countPC + " LOSE | " + draws + " DRAWS");
         return "";
    }
}
