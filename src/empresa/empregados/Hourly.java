package empresa.empregados;

import empresa.agendas.Schedule;

public class Hourly extends Employee{

    private int hourlyWage;

    @Override
    public Employee makeCopy(){

        Employee x = new Hourly();
        x.setId(this.getId());
        x.setName(this.getName());
        x.setAdress(this.getAdress());
        x.setPaymentMethod(super.getPaymentMethod());
        x.setSchedule(super.getSchedule().makeCopy());
        x.setFundo(super.getFundo());
        x.setUnionID(super.getUnionID());
        ((Hourly)x).setHourlyWage(getHourlyWage());

//        x.point.enterEntry(this.point.getEntry());
//        x.point.insertOut(this.point.getOut());
        return x;
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

    @Override
    public String toString() {
        return "\nEmployee - ["+ super.getId() +"]" +
                "\nName: " + super.getName() +
                "\nAdress: " + super.getAdress() +
                "\nPayment Method: " + super.getPaymentMethod() +
                "\nSalary/Hour: R$" + hourlyWage +
                "\nType: Horista" +
                "\nTotal: " + super.getFundo() + "\n";
    }

    public int getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
