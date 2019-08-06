package empresa.empregados;

public class Comissioned extends Salaried{

    private double comPerc;

    @Override
    public Employee makeCopy(){

        Employee x = new Comissioned();
        x.setId(this.getId());
        x.setName(this.getName());
        x.setAdress(this.getAdress());
        x.setPaymentMethod(super.getPaymentMethod());
        x.setSchedule(super.getSchedule().makeCopy());
        x.setFundo(super.getFundo());
        x.setUnionID(super.getUnionID());

        ((Comissioned)x).setComPerc(getComPerc());

        //TO DO - - SELLS
        return x;
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

    public double getComPerc() {
        return comPerc;
    }

    public void setComPerc(double comPerc) {
        this.comPerc = comPerc;
    }

    @Override
    public String toString(){
        return "\nEmployee - ["+ super.getId() +"]" +
                "\nName: " + super.getName() +
                "\nAdress: " + super.getAdress() +
                "\nPayment Method: " + super.getPaymentMethod() +
                "\nSalary: R$" + super.getMonthlySalary() +
                "\nComission: " + comPerc + "%" +
                "\nType: Comissionado" +
                "\nTotal: " + super.getFundo() + "\n";
    }
}