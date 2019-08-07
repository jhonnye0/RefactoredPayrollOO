package facade;

import empresa.empregados.Employee;
import empresa.sindicato.Union;

import java.util.ArrayList;
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

    public void checkSynd(Employee employee, ArrayList<Union> union){
        System.out.println("Empregado deseja filiar-se ao sindicato?" +
                "\n[y] - yes" +
                "\n[n] - no");

        input.nextLine();
        label:
        while (true) {
            String in = input.nextLine();
            switch (in.intern()) {
                case "y": {

                    System.out.print("Digite a taxa sindical:\n");
                    double synTax = numcheckException(0,-1);

                    Union aux = new Union(true, synTax);
                    union.add(employee.getId(), aux);

                    employee.setUnionID(employee.getId() + 10000);

                    input.nextLine();
                    break label;
                }
                case "n": {
                    Union aux = new Union(false, 0);
                    union.add(employee.getId(), aux);
                    System.out.println("Nao registrado no sindicato");
                    break label;
                }
                default:
                    System.out.println("Entrada inadequada, digite novamente..");
                    break;
            }
        }
    }
}
