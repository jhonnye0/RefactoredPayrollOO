package empresa.empregados;

public class Salaried extends Employee{

    @Override
    public Employee makeCopy() {
        return null;
    }

    @Override
    public double calcSalary() {
        return super.getFundo();
    }

    @Override
    public void registerSale() {
        System.out.println("Voce nao esta permitido executar essa operacao");
    }

    @Override
    public void registerPoint() {
        System.out.println("Voce nao esta permitido executar essa operacao");
    }


}
