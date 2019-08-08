package empresa.empregados.point;

import empresa.agendas.Time;
import empresa.empregados.Employee;
import facade.ExceptionCatch;

public class Hourly extends Employee {

    ExceptionCatch except = new ExceptionCatch();
    private double hourlyWage;
    private MarkPoint point = new MarkPoint();

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
    public void registerSale(Time time) {
        System.out.println("Voce nao esta permitido executar essa operacao");
    }

    @Override
    public void registerPoint(Time time) {
        System.out.println("Deseja marcar:\n" +
                "1. Entrada\n" +
                "2. Saida\n");

        int num = except.numcheckException(1,2);

        if(num == 1) markEntracePoint(time.getHOUR());
        else markOutPoint(time.getHOUR());
    }

    public void markEntracePoint(int hour){
        this.point.enterEntry(hour);
    }

    public void markOutPoint(int hour){
        this.point.insertOut(hour);

        if(point.getDiff() > 8){
            super.setFundo(super.getFundo() + 1.5*(point.getDiff()-8)*hourlyWage);
        }else{
            super.setFundo(((point.getDiff())*this.hourlyWage));
        }
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

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getDiff(){
        System.out.println("Horas trabalhadas:" + point.getDiff() + "hrs");
        return point.getDiff();
    }
}
