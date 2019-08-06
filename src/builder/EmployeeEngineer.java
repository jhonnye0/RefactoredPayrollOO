package builder;

import empresa.empregados.Employee;
import empresa.sindicato.Union;

import java.util.ArrayList;

public class EmployeeEngineer {

    private EmployeeBuilder employeeBuilder;

    public EmployeeEngineer(EmployeeBuilder builder) {
        employeeBuilder = builder;
    }

    public void construct(ArrayList< Union > union, int total) {
        employeeBuilder.buildName();
        employeeBuilder.buildAdress();
        employeeBuilder.buildSalary();
        employeeBuilder.buildSchedule();
        employeeBuilder.buildId(total);
        employeeBuilder.buildUnion(union);
    }

    public Employee getEmployee(){
        return this.employeeBuilder.getEmployee();
    }

}
