public class TableHelp {

    TableHelp(int num, String[] args) {
        int im;
        int jm;
        System.out.println("Available moves:");
        for (int j = 0; j < num; j++) {
            System.out.println(j + 1 + " - " + args[j]);
        }
        System.out.println("0 - exit\n911 - learn the rules");
        System.out.printf(" \\  User\nPC \\       ");
        for (int  i = 0; i < num; i++) System.out.printf("| %-10s " ,args[i]);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num + 1; j++) {
                if (j == 0) {
                    System.out.println();
                    System.out.print("-----------");
                    for (int k = 0; k < num; k++) {
                        System.out.print("+------------");
                    }
                    System.out.println();
                        System.out.printf("%-10s " ,args[i]);
                    continue;
                }
                else {
                    if (i + 1 == j) {
                        System.out.printf("| %-10s ", "draw");
                        continue;
                    } if (i - j > num / 2 || j - i > num / 2) {
                        im = -i;
                        jm = -j;
                    } else {
                        im = i;
                        jm = j;
                    }
                    if (im > jm) {
                        System.out.printf("| %-10s ", "lose");
                    } else {
                        System.out.printf("| %-10s ", "win");
                    }
                }
            }
        }
        System.out.println("\n");
    }
}
