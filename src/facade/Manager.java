package facade;

import empresa.empregados.Employee;

import java.util.Scanner;

public class Manager {

    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    public void add(){

        String name, adress;
        Employee x;
        System.out.print("Digite o nome:\n");
        name = input.nextLine();
        System.out.print("Endereco:\n");
        adress = input.nextLine();
        int type = except.numcheckException(1,3);

        if()
    }
}
