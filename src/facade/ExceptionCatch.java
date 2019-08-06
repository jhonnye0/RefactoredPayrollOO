package facade;

import java.util.Scanner;

public class ExceptionCatch {

    static Scanner input = new Scanner(System.in);

    public int numcheckException(int limInf, int limSup) {

        int num;

            if(limSup == -1) limSup = Integer.MAX_VALUE;

            while(true){
                try {
                    num = input.nextInt();
                    if(limInf <= num && num <= limSup) return num;
                    else {
                        System.out.println("Fora do intervalo.. digite novamente");
                    }
                }catch (Exception e){
                    System.out.print("Formato incorreto digite novamente..\n");
                    input.nextLine();
                }
            }
        }

    public double numcheckException(double limInf, double limSup) {
        double num;

        if(limSup == -1) limSup = Integer.MAX_VALUE;

        while(true){
            try {
                num = input.nextDouble();
                if(limInf <= num && num <= limSup) return num;
                else {
                    System.out.println("Fora do intervalo.. digite novamente");
                }
            }catch (Exception e){
                System.out.print("Formato incorreto digite novamente..\n");
                input.nextLine();
            }
        }
    }
}
