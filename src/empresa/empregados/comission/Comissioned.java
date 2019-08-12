package empresa.empregados.comission;

import empresa.agendas.Time;
import empresa.empregados.*;
import facade.ExceptionCatch;

public class Comissioned extends Salaried {

    ExceptionCatch except = new ExceptionCatch();
    private double comPerc;
    private Sells sells = new Sells();

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
        ((Comissioned)x).sells = this.sells.makeCopy();
        return x;
    }

    @Override
    public void calcSalary() {
        int i;
        double total = 0;
        for (i = 0; i < 31; i++){
            total += sells.getDaySale(i);
        }
        setFundo(getMonthlySalary() + getComPerc()*total/100);
    }

    public void registerSale(Time time){

        System.out.println("Digite o preco da venda:");
        double sale = except.numcheckException(0,-1);

        this.sells.registerSale(time.getDAY(), sale);
    }

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
