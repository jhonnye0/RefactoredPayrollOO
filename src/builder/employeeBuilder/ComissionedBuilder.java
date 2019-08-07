package builder.employeeBuilder;

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
    public void buildUnion(ArrayList<Union> union) {
        except.checkSynd(employee, union);
    }

    @Override
    public void buildSchedule() {
        Schedule schedule = new MonthlySchedule(employee.getPaymentMethod(),31);
        employee.setSchedule(schedule);
    }

    @Override
    public void buildSalary() {
        System.out.println("Digite seu salario:");
        double salary = except.numcheckException(0,-1);
        ((Comissioned)employee).setMonthlySalary(salary);

        System.out.println("Digite o percentual de comissao: (sem o %)");
        double comPerc = except.numcheckException(0,100);
        ((Comissioned)employee).setComPerc(comPerc);
    }

}
