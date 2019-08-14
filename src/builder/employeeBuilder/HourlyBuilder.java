package builder.employeeBuilder;

import empresa.agendas.*;
import empresa.empregados.*;
import empresa.empregados.point.Hourly;
import empresa.sindicato.Union;
import facade.ExceptionCatch;
import java.util.ArrayList;
import java.util.Scanner;

public class HourlyBuilder implements EmployeeBuilder {

    private Employee employee;
    private Scanner input = new Scanner(System.in);
    private ExceptionCatch except = new ExceptionCatch();

    public HourlyBuilder(){
        this.employee = new Hourly();
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
    public void buildPMethod() {
        System.out.print("Qual metodo de pagamento que deseja?\n\n" +
                "1.Cheque em maos\n" +
                "2.Cheque pelos correios\n" +
                "3.Deposito bancario\n");

        int payMethod = except.numcheckException(1,3);

        if(payMethod == 1)
            employee.setPaymentMethod("Cheque em maos");
        else if (payMethod == 2)
            employee.setPaymentMethod("Cheque pelos correios");
        else
            employee.setPaymentMethod("Deposito bancário");
    }

    @Override
    public void setEmployee(Employee x) {
        employee = x.makeCopy();
    }

    @Override
    public Employee getEmployee() {
        return this.employee;
    }

    @Override
    public void buildUnion() {
        except.checkSynd(employee);
    }

    @Override
    public void buildSchedule() {

        Schedule schedule = new WeeklySchedule(employee.getPaymentMethod(),1,6);
        employee.setSchedule(schedule);
    }

    @Override
    public void buildSalary() {
        System.out.println("Digite seu salario/hora:");
        double salary = except.numcheckException(0,-1);
        ((Hourly)(employee)).setHourlyWage(salary);
    }

}
