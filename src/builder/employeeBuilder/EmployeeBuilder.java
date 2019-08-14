package builder.employeeBuilder;

import empresa.empregados.Employee;

public interface EmployeeBuilder {

    void buildId(int total);

    void buildName();

    void buildSchedule();

    void buildSalary();

    void buildUnion();

    void buildAdress();

    void buildPMethod();

    void setEmployee(Employee x);

    Employee getEmployee();

}
