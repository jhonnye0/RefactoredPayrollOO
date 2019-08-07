package empresa.empregados;

public class Salaried extends Employee{

    private double monthlySalary;

    @Override
    public Employee makeCopy(){

        Employee x = new Salaried();
        x.setId(this.getId());
        x.setName(this.getName());
        x.setAdress(this.getAdress());
        x.setPaymentMethod(super.getPaymentMethod());
        x.setSchedule(super.getSchedule().makeCopy());
        x.setFundo(super.getFundo());
        x.setUnionID(super.getUnionID());
        ((Salaried)x).setMonthlySalary(getMonthlySalary());
        return x;
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

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "\nEmployee - ["+ super.getId() +"]" +
                "\nName: " + super.getName() +
                "\nAdress: " + super.getAdress() +
                "\nPayment Method: " + super.getPaymentMethod() +
                "\nSalary: R$" + monthlySalary +
                "\nType: Salariado"+
                "\nTotal: R$" + super.getFundo() + "\n";
    }
}
