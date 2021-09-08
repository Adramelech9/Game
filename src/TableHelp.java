public class TableHelp {

    TableHelp(int num) {

        int im;
        int jm;
        System.out.print("PC \\ User ");
        for (int  i = 0; i < num; i++) System.out.print("|  " + (i + 1)+ "   ");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num + 1; j++) {
                if (j == 0) {
                    System.out.println();
                    System.out.print("----------");
                    for (int k = 0; k < num; k++) {
                        System.out.print("+------");
                    }
                    System.out.println();
                        System.out.print("  " +(i + 1) + "       ");
                    continue;
                }
                else {
                    if (i + 1 == j) {
                        System.out.print("| draw ");
                        continue;
                    } if (i - j > num / 2 || j - i > num / 2) {
                        im = -i;
                        jm = -j;
                    } else {
                        im = i;
                        jm = j;
                    }
                    if (im > jm) {
                        System.out.print("| lose ");
                    } else {
                        System.out.print("| win  ");
                    }
                }
            }
        }
        System.out.println();
    }
}
