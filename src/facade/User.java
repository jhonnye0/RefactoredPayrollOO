package facade;

import empresa.agendas.MonthlySchedule;
import empresa.agendas.Schedule;
import empresa.agendas.Time;
import empresa.agendas.WeeklySchedule;
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

            int op = except.numcheckException(0,3);

            switch (op){

                case 0:
                    return;
                case 1:
                    usuario.registerSale(time);
                    break;
                case 2:
                    usuario.registerPoint(time);
                    break;
                case 3:
                    Schedule schedule = selectSchedule();
                    schedule.changeSchedule(agendas, usuario);
                    break;
            }
        }
    }

    public Schedule selectSchedule(){
        System.out.println("\nDigite o número da agenda que deseja:\n" +
                "1. Mensal\n" +
                "2. Semanal\n");

        int num = except.numcheckException(1,2);

        if (num == 1){
            return new MonthlySchedule("0", 0);
        }else return new WeeklySchedule("0", 0, 0);
    }
}
