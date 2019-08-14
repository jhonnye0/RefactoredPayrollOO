package empresa.empregados;

import empresa.agendas.Schedule;
import empresa.agendas.Time;
import empresa.sindicato.Union;

public abstract class Employee extends Union {

    private int id;
    private int unionID;
    private String name;
    private String adress;
    private double fundo;
    private Schedule schedule;
    private String paymentMethod;
    private boolean isUnion;

    public abstract Employee makeCopy();

    public abstract void calcSalary();

    public abstract void registerSale(Time time);

    public abstract void registerPoint(Time time);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnionID() {
        return unionID;
    }

    public void setUnionID(int unionID) {
        this.unionID = unionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getFundo() {
        return fundo;
    }

    public void setFundo(double fundo) {
        this.fundo = fundo;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isUnion() {
        return isUnion;
    }

    public void setUnion(boolean union) {
        isUnion = union;
    }

    public void lauchFee(double fee) {
        setFundo(getFundo() - fee);
        System.out.println("Taxa lançada com sucesso..\n");
    }
}
