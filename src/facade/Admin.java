package facade;

import builder.scheduleBuilder.*;
import empresa.agendas.*;
import empresa.sindicato.Union;
import memento.*;

import java.util.Scanner;

class Admin {

    private Scanner input = new Scanner(System.in);
    private ExceptionCatch except = new ExceptionCatch();

    private int save = 0;

    int admin(Manager manager, Time time, int total, Empresa empresa,
              CareTaker careTaker, ReCareTaker reCareTaker, Originator originator) {

        while (true){

            if (save == 1){
                originator.setState(empresa);
                careTaker.save(originator);
            }
            save = 0;

            System.out.println("\n----------------------------------\n");
            System.out.println("Digite o numero da operacao que deseja:\n\n" +
                    "0. Finalizar\n" +
                    "1. Adcionar empregado\n" +
                    "2. Remover empregado\n" +
                    "3. Lancar taxa de servico\n" +
                    "4. Reajustar informacoes de um empregado\n" +
                    "5. Rodar a folha de pagamento para hoje\n" +
                    "6. Criar nova agenda de pagamento\n" +
                    "7. Checar os empregados registrados na empresa\n" +
                    "8. Desfazer operacao /  Refazer operacao\n");

            int operation = except.numcheckException(0,8);

            switch (operation){
                case 0:
                    return total;
                case 1:
                    manager.add(empresa.getList(), empresa.getUnion(), empresa.getList().size());
                    total += 1;
                    save = 1;

                    System.out.print("\nDIGITE ENTER PARA CONTINUAR\n");
                    input.nextLine();
                    break;
                case 2:
                    System.out.println("Digite seu ID:");
                    int id = except.numcheckException(0,-1);

                    if(manager.haveEmp(empresa.getList(), id)){
                        manager.remove(empresa.getList(), empresa.getUnion(), id, total);
                        save = 1;
                    }
                    break;
                case 3:
                    System.out.println("Qual o preco da taxa estipulada pelo sindicato?");
                    double tax = except.numcheckException(0,-1);
                    System.out.print("Qual o ID do empregado?\n");
                    id = except.numcheckException(0,-1);

                    if (manager.haveEmp(empresa.getList(), id)) {
                        new Union(false, 0).lauchFee(empresa.getList(), id, tax);
                        save = 1;
                    }
                    break;
                case 4:
                    System.out.print("Qual o ID do empregado?\n");
                    id = except.numcheckException(0,-1);
                    if (manager.haveEmp(empresa.getList(), id)) {
                        manager.update(empresa.getList(), empresa.getUnion(), id);
                        save = 1;
                    }
                    break;
                case 5:
                    Schedule schedule = new MonthlySchedule("0",0);
                    schedule.roolSheet(empresa.getList(), time.getDAY(), time.getWEEK());

                    System.out.println("------------------------------\n" +
                            "Mensais:");
                    schedule.roolSheet(empresa.getList(), time.getDAY(), time.getWEEK());
                    save = 1;
                    break;
                case 6:
                    System.out.println("Que tipo de agenda deseja criar?");
                    System.out.println("1 - Mensal / 2 - Semanal");
                    int num = except.numcheckException(1,2);

                    ScheduleEngineer sEngineer = null;

                    if(num == 1){
                        sEngineer = new ScheduleEngineer(new MonthlySBuilder());
                    }else if(num == 2) {
                        sEngineer = new ScheduleEngineer(new WeeklySBuilder());
                    }

                    assert sEngineer != null;
                    sEngineer.construct();
                    empresa.getAgendas().add(sEngineer.getSchedule());

                    System.out.print("Agenda criada com sucesso..\n");

                    System.out.println("Digite ENTER:");
                    input.nextLine();
                    break;

                case 7:
                    manager.printAllEmployee(empresa.getList(), empresa.getUnion());

                    System.out.print("\n-----------------------------------\n");
                    System.out.print("\nDIGITE ENTER PARA CONTINUAR\n");
                    input.nextLine();
                    break;
                case 8:
                    System.out.println("1 - Defazer operacao / 2 - Refazer operacao");

                    UROperation urOperation = careTaker;

                    if(except.numcheckException(1,2) == 1){
                        reCareTaker.save(originator);
                    }else {
                        urOperation = reCareTaker;
                    }
                    urOperation.undo(originator);
                    empresa = originator.getCompany();

                    System.out.println("Digite ENTER:");
                    input.nextLine();
                    break;
                default:
                    System.out.print("Digite novamente o numero..\n");
                    break;
            }
        }
    }
}
