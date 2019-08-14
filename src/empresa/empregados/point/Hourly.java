package empresa.empregados.point;

import empresa.agendas.Time;
import empresa.empregados.Employee;
import facade.ExceptionCatch;

public class Hourly extends Employee {

    private ExceptionCatch except = new ExceptionCatch();
    private double hourlyWage;
    private MarkPoint point = new MarkPoint();

    @Override
    public Employee makeCopy(){

        Hourly x = new Hourly();
        x.setId(this.getId());
        x.setName(this.getName());
        x.setAdress(this.getAdress());
        x.setPaymentMethod(super.getPaymentMethod());
        x.setSchedule(super.getSchedule().makeCopy());
        x.setFundo(super.getFundo());
        x.setUnionID(super.getUnionID());
        x.setUnion(isUnion());
        x.setUnionTax(getUnionTax());
        x.setHourlyWage(getHourlyWage());
        x.point.enterEntry(this.point.getEntry());
        x.point.insertOut(this.point.getOut());

        return x;
    }

    @Override
    public void calcSalary() {
        if(getDiff() > 8) {
            setFundo(getFundo() + 1.5*getHourlyWage()*(getDiff() - 8));
        }
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

    private void markEntracePoint(int hour){
        this.point.enterEntry(hour);
    }

    private void markOutPoint(int hour){
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
                "\nUnion:" + isUnion() +
                "\nType: Horista" +
                "\nTotal: " + super.getFundo() + "\n";
    }

    private double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    private int getDiff(){
        System.out.println("Horas trabalhadas:" + point.getDiff() + "hrs");
        return point.getDiff();
    }
}
