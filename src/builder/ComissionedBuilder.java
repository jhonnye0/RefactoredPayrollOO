package builder;

import empresa.agendas.*;
import empresa.empregados.*;
import empresa.sindicato.Union;
import facade.ExceptionCatch;
import java.util.ArrayList;
import java.util.Scanner;

public class ComissionedBuilder implements EmployeeBuilder {

    private Employee employee;
    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    public ComissionedBuilder(){
        this.employee = new Comissioned();
    }

    @Override
    public void buildId(int total) {
        employee.setId(total);

    }

    @Override
    public void buildName() {
        System.out.println("Digite seu nome:");
        employee.setName(input.nextLine());
    }

    @Override
    public void buildAdress() {
        System.out.println("Digite seu endereco:");
        employee.setAdress(input.nextLine());
    }

    @Override
    public Employee getEmployee() {
        return this.employee;
    }

    @Override
    public void buildUnion(ArrayList<Union> union) {
        except.checkSynd(employee, union);
    }

    @Override
    public void buildSchedule() {

        System.out.println("Digite o metodo de pagamento:" +
                "1.Cheque em maos\n" +
                "2.Cheque pelos correios\n" +
                "3.Deposito bancario\n");

        int paymentMethod = except.numcheckException(1,3);

        Schedule schedule = new MonthlySchedule(paymentMethod,31);

        employee.setSchedule(schedule);
    }

    @Override
    public void buildSalary() {
        System.out.println("Digite seu salario:");
        double salary = except.numcheckException(0,-1);
        employee.setFundo(salary);
    }
}
