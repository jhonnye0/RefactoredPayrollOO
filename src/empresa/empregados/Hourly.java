package empresa.empregados;

public class Hourly extends Employee{
    @Override
    public Employee makeCopy() {
        return null;
    }

    @Override
    public double calcSalary() {
        return 0;
    }

    @Override
    public void registerSale() {
        System.out.println("Voce nao esta permitido executar essa operacao");
    }

    @Override
    public void registerPoint() {

    }
}
