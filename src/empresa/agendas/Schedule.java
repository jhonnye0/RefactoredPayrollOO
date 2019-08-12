package empresa.agendas;

import empresa.empregados.Employee;
import facade.ExceptionCatch;
import java.util.ArrayList;

public abstract class Schedule {

    ExceptionCatch except = new ExceptionCatch();
    private String paymentMethod;

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public abstract void setFrequence(int frequence);

    public abstract void setDayWeek(int dayWeek);

    public abstract void setPayday(int payday);

    public abstract void showSchedules(ArrayList<Schedule> agendas);

    public abstract boolean checkIfisToPay(int day, int week);

    public void changeSchedule(ArrayList<Schedule> agendas, Employee x){

        System.out.println("Escolha o ID indicado da agenda que deseja:");
        showSchedules(agendas);
        int num = except.numcheckException(0,agendas.size()-1);

        x.setSchedule(agendas.get(num));
    }

    public void roolSheet(ArrayList<Employee> list, int day, int week) {

        for (Employee e : list) {
            if (e.getSchedule().checkIfisToPay(day, week)) {

                e.calcSalary();
                System.out.println("Employee de ID [" + e.getId() + "]\n" +
                        "Foi pago no valor de: R$"+ e.getFundo() + "\nAtraves de: " + e.getPaymentMethod());
                System.out.println("--------------------------------");
                e.setFundo(0);
            }
        }
    }

    public abstract Schedule makeCopy();
}
