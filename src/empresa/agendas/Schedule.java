package empresa.agendas;

import empresa.empregados.Employee;

import java.util.ArrayList;

public abstract class Schedule {

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

    public abstract boolean checkIfisToPay(int day, int week);

    public void changeSchedule(ArrayList<Schedule> agendas, Employee x, int num) {

    }

    public void roolSheet(ArrayList<Employee> list, int day, int week) {
        for (Employee e : list) {

            if (e.getSchedule().checkIfisToPay(day, week)) {

                e.setFundo(0);
                System.out.println("Employee de ID [" + e.getId() + "]\n" +
                        "Foi pago atraves de: " + paymentMethod);
                System.out.println("--------------------------------");
            }
        }
    }

        public abstract Schedule makeCopy();
}
