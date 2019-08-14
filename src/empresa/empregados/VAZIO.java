package empresa.empregados;

import empresa.agendas.Time;

public class VAZIO extends Employee {
    @Override
    public Employee makeCopy() {
        return null;
    }

    @Override
    public void calcSalary() {

    }

    @Override
    public void registerSale(Time time) {

    }

    @Override
    public void registerPoint(Time time) {

    }
}
