package facade;

import builder.scheduleBuilder.*;
import empresa.agendas.*;
import empresa.empregados.Employee;
import empresa.sindicato.Union;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    private int save = 0;
    public int admin(ArrayList<Employee> list, ArrayList<Union> union,
                     ArrayList<Schedule> agendas, Manager manager, Time time,
                     int total, Empresa empresa) {

        while (true){
            System.out.println("\n----------------------------------\n");
            System.out.println("Digite o numero da operacao que deseja:\n\n" +
                    "0. Finalizar\n" +
                    "1. Adcionar empregado\n" +
                    "2. Remover empregado\n" +
                    "3. Lancar taxa de servico\n" +
                    "4. Reajustar informacoes de um empregado\n" +
                    "5. Rodar a folha de pagamento para hoje\n" +
                    "6. Criar nova agenda de pagamento\n" +
                    "7. Passar as horas/ Checar horas\n" +
                    "8. Passar os dias/ Checar dia\n" +
                    "9. Passar as semanas / Checar semana\n" +
                    "10. Checar os empregados registrados na empresa\n" +
                    "11. Desfazer operacao /  Refazer operacao\n");

            int operation = except.numcheckException(0,11);

//            if (save == 1){
//                originator.setState(list, union);
//                unCareTaker.save(originator);
//            }

            save = 0;

            switch (operation){
                case 0:
                    return total;
                case 1:
                    manager.add(list, union, total);
                    total += 1;
                    save = 1;

                    System.out.print("\nDIGITE ENTER PARA CONTINUAR\n");
                    input.nextLine();
                    break;
                case 2:
                    System.out.println("Digite seu ID:");
                    int id = except.numcheckException(0,-1);

                    if(manager.haveEmp(list, id)){
                        manager.remove(list, union, id, total);
                        save = 1;
                    }
                    break;
                case 3:
                    System.out.println("Qual o preco da taxa estipulada pelo sindicato?");
                    double tax = except.numcheckException(0,-1);
                    System.out.print("Qual o ID do empregado?\n");
                    id = except.numcheckException(0,-1);

                    if (manager.haveEmp(list, id)) {
                        Union.lauchFee(list, id, tax);
                        save = 1;
                    }
                    break;
                case 4:
                    System.out.print("Qual o ID do empregado?\n");
                    id = except.numcheckException(0,-1);
                    if (manager.haveEmp(list, id)) {
                        manager.update(list, union, id);
                        save = 1;
                    }
                    break;
                case 5:
                    WeeklySchedule x = new WeeklySchedule("Nao tem",0,0);
                    MonthlySchedule y = new MonthlySchedule("Nao tem",0);
                    System.out.println("Semanais:");
                    x.roolSheet(list, time.getDAY(), time.getWEEK());
                    System.out.println("------------------------------\n" +
                            "Mensais:");
                    y.roolSheet(list, time.getDAY(), time.getWEEK());
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

                    sEngineer.construct();
                    agendas.add(sEngineer.getSchedule());

                    input.nextLine();
                    System.out.print("Agenda criada com sucesso..\n");

                    System.out.println("Digite ENTER:");
                    input.nextLine();
                    break;
                case 7:
                    System.out.println("1 - Passar horas / 2 - Checar horas");
                    num = except.numcheckException(1,2);
                    if(num == 1){
                        System.out.println("Quantas horas deseja passar?");
                        int n = except.numcheckException(0,-1);
                        time.setHOUR(n);
                    }else{
                        if(time.getHOUR() > 9)
                            System.out.println("HORA: " + time.getHOUR() + ":00");
                        else System.out.println("HORA: " + "0"+ time.getHOUR() + ":00");
                    }
                    input.nextLine();
                    System.out.println("Digite ENTER:");
                    input.nextLine();
                    break;
                case 8:
                    System.out.println("1 - Passar dias / 2 - Checar dias");
                    num = except.numcheckException(1,2);
                    if(num == 1){
                        System.out.println("Quantos dias deseja passar?");
                        int n = except.numcheckException(0,-1);
                        time.setDAY(n);
                    }else{
                        System.out.println("DIA: " + time.getDAY());
                    }
                    if(time.getDAY() == 31)
                    {
                        for(Employee e : list){
                            if(union.get(e.getId()).isUnion()){
                                e.setFundo(e.getFundo()-union.get(e.getId()).getUnionTax());
                            }
                        }
                    }
                    input.nextLine();
                    System.out.println("Digite ENTER:");
                    input.nextLine();
                    break;
                case 9:
                    System.out.println("1 - Passar semanas / 2 - Checar semanas");
                    num = except.numcheckException(1,2);
                    if(num == 1){
                        System.out.println("Quantas semanas deseja passar?");
                        int n = except.numcheckException(0,-1);
                        time.setWEEK(n);
                    }else{
                        System.out.println("SEMANA: " + time.getDAY());
                    }
                    input.nextLine();
                    System.out.println("Digite ENTER:");
                    input.nextLine();
                    break;
                case 10:
                    int valid = -1;
                    int i;
                    for (i = 0; i < list.size(); i++) {
                        valid++;
                        manager.printEmployee(list, union, i);
                    }
                    if (valid == -1)
                        System.out.println("Nao ha empregados registrados..");
                    System.out.print("\n-----------------------------------\n");
                    System.out.print("\nDIGITE ENTER PARA CONTINUAR\n");
                    input.nextLine();
                    break;
                case 11:
                    System.out.println("1 - Defazer operacao / 2 - Refazer operacao");
                    num = except.numcheckException(1,2);
//                    if(num == 1){
//                        if(unCareTaker.getIndex() != 0){
//                            reOriginator.setState(list, union);
//                            reCareTaker.save(reOriginator);
//                            unCareTaker.undo(originator);
//                            list = originator.getEmp();
//                            empresa.setList(list);
//
//                            union = originator.getUn();
//                            empresa.setUnion(union);
//                            total = list.size();
//                        }else{
//                            System.out.println("Nao ha operacoes disponiveis para fazer");
//                        }
//                    }else if (num == 2){
//                        if(reCareTaker.getIndex() != 0){
//                            unCareTaker.clear();
//                            reCareTaker.undo(reOriginator);
//                            list = reOriginator.getEmp();
//                            union = reOriginator.getUn();
//                            total = list.size();
//                        }else{
//                            System.out.println("Nao ha operacoes disponiveis para fazer");
//                        }
//                    }
                    input.nextLine();
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
