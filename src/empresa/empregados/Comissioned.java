package empresa.empregados;

public class Comissioned extends Employee{
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

    }

    @Override
    public void registerPoint() {
        System.out.println("Voce nao esta permitido executar essa operacao");
    }
}
