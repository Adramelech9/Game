import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Rules {
    static Scanner scanner = new Scanner(System.in);
    public static int countUser = 0;
    public static int countPC = 0;
    public static int draws = 0;

    private static int[] sequence = RandomKey.getSequence();
    private static int num;

    Rules() throws NoSuchAlgorithmException, InvalidKeyException {

        System.out.println("Enter an odd number of possible combinations");
        this.num = getInt();
        while (num < 3 || num % 2 != 1 || num > 9) {
            if (num < 3) System.out.println("The number must be at least 3");
            if (num % 2 != 1) System.out.println("Error. Enter an odd number");
            if (num > 9) System.out.println("The number must be no more than 9");
            num = getInt();
        }
        new RandomKey(num);
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
    public static String getSteps() {
        String key = RandomKey.getKey();
        System.out.println(key);
        return key;
    }

   static String playRound() {
        int numUser;
        int num1;
        int num2;
       System.out.println("You need select a positive number and < " + (num + 1));
       System.out.println("press 911 to learn the rules");
       for (int i = 0; i < 128; i++) {
            System.out.println("Enter your move: №" + (i + 1));
            if(scanner.hasNextInt()) {

            } else {
                System.out.println("You made a mistake entering the number. Try again.");
                scanner.next();
                num = getInt();
            }
            numUser = scanner.nextInt();
            if (numUser == 911) {
                new TableHelp(num);
                i--;
                continue;
            }

            if (numUser < 0 || numUser > num) {
                System.out.println("You need select a positive number and < " + (num + 1));
                System.out.println("or 911 for help");
                numUser = getInt();
                if (numUser == 911) {
                    new TableHelp(num);
                    i--;
                    continue;
                }
            if (numUser < 0 || numUser > num) {
                System.out.println("try again");
                numUser = getInt();
                if (numUser < 0 || numUser > num) {
                    System.out.println("attempts ended");
                    break;
                    }
                }
            }
            if (numUser == 0) break;
            if (numUser == '?') {
                new TableHelp(num);
                continue;
            }
            if (numUser == sequence[i]) {
                System.out.println("draw");
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
            System.out.println("You selected " + numUser + ", PC " + sequence[i]);
        }
        System.out.println("score: " + countUser + " WINS | " + countPC + " LOSE | " + draws + " DRAWS");
         return "";
    }
}
