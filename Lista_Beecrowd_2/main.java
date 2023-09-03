package Lista_Beecrowd_2;

import java.util.Scanner;
import java.util.Random;

 class main {

    public static void main (String[] args) throws outException{

        LSECircular<Integer> energia = new LSECircular<Integer>();
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int N = 0;
        int m = 0;

        do {
            if (N != 0) {

                for (int i = 1; i <= N; i++)
                    energia.inserir(i, i);

            }

            N = Integer.parseInt(sc.nextLine());
        } while (N != 0);
    }
}
