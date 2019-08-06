package facade;

import empresa.agendas.Schedule;
import empresa.agendas.Time;
import empresa.empregados.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();


    public void user(Employee usuario, Time time, Manager manager,
                     ArrayList<Schedule> agendas, Empresa empresa) {


        while(true){

            System.out.println("\n----------------------------------\n");
            System.out.println("Digite a operacao que deseja:\n\n" +
                    "0. Finalizar\n" +
                    "1. Registro de vendas\n" +
                    "2. Marcar ponto\n" +
                    "3. Alterar agenda de pagamento\n");

            int op = except.numcheckException(0,2);

            switch (op){

                case 0:
                    return;
                case 1:
                    usuario.registerSale();
                    break;
                case 2:
                    usuario.registerPoint();
                    break;
                case 3:
                    //TO DO
                    break;
            }
        }
    }
}
