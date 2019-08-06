package facade;

import builder.EmployeeEngineer;
import builder.HourlyBuilder;
import empresa.empregados.Employee;
import empresa.empregados.Hourly;
import empresa.sindicato.Union;

import java.util.ArrayList;
import java.util.Scanner;

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
            HourlyBuilder hourlyBuilder = new HourlyBuilder();
            employeeEngineer = new EmployeeEngineer(hourlyBuilder);
        }else if(type == 2){

        }else{

        }
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
}
