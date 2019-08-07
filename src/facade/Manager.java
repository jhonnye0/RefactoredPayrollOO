package facade;

import builder.employeeBuilder.ComissionedBuilder;
import builder.employeeBuilder.EmployeeEngineer;
import builder.employeeBuilder.HourlyBuilder;
import builder.employeeBuilder.SalariedBuilder;
import empresa.empregados.*;
import empresa.sindicato.Union;
import java.util.*;

public class Manager {

    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    public void add(ArrayList<Employee> list, ArrayList<Union> union, int total){

        EmployeeEngineer employeeEngineer;

        System.out.print("Tipo de empregado: (Digite o número)\n" +
                "1. Horista\n" +
                "2. Comissionado\n" +
                "3. Assalariado\n");

        int type = except.numcheckException(1,3);

        if(type == 1){
            employeeEngineer = new EmployeeEngineer(new HourlyBuilder());
        }else if(type == 2){
            employeeEngineer = new EmployeeEngineer(new ComissionedBuilder());
        }else{
            employeeEngineer = new EmployeeEngineer(new SalariedBuilder());
        }

        employeeEngineer.construct(union, total);
        list.add(employeeEngineer.getEmployee());
    }

    public void remove(ArrayList<Employee> list, ArrayList<Union> union, int id, int total) {

        if(union.get(id).isUnion()) {
            union.get(id).setUnion(false); // unionID
            union.get(id).setUnionTax(0);
        }
        list.remove(id);
        System.out.println("Empregado removido com sucesso..");
    }

    public boolean haveEmp(ArrayList<Employee> list, int id) {
        int valid;
        try {
            valid = 1;
            list.get(id);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Empregado nao registrado na empresa.");
            valid = 0;
        }
        return valid == 1;
    }

    public void printEmployee(ArrayList<Employee> list, ArrayList<Union> union, int id) {
        System.out.print("\n-----------------------------------\n");
        Employee x = list.get(id);
        if(x.getSchedule() != null) {
            System.out.print(x.toString());
            System.out.println(x.getSchedule().toString());
        }
        if (union.get(id).isUnion()) {
            System.out.println("Union: true");
            System.out.println("Union ID: " + x.getUnionID());
            System.out.println("Union fee: " + union.get(id).getUnionTax());
        }
    }

    public void update(ArrayList<Employee> list, ArrayList<Union> union, int id){

        SalariedBuilder builder = new SalariedBuilder();
        EmployeeEngineer engineer = new EmployeeEngineer(builder);

        while (true){
            System.out.println("Digite o numero da informacao a qual deseja atualizar:\n\n" +
                    "0. Retornar\n" +
                    "1. Nome\n" +
                    "2. Endereco\n" +
                    "3. Tipo\n" +
                    "4. Metodo de pagamento\n" +
                    "5. Participacao no sindicato\n");

            int operation = except.numcheckException(0,5);

            if(operation != 0){
                engineer.update(list, union, id, operation);
                list.set(id, engineer.getEmployee());
            }else break;
        }
    }
}
