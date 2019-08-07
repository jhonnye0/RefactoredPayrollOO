package empresa.agendas;

import empresa.empregados.Employee;

import java.util.ArrayList;

public interface Schedule {

    String getPaymentMethod();

    void setFrequence(int frequence);

    void setDayWeek(int dayWeek);

    void setPayday(int payday);

    void setPaymentMethod(String paymentMethod);

    void changeSchedule(ArrayList<Schedule> agendas, Employee x, int num);

    void roolSheet(ArrayList<Employee> list, int day, int week);

    Schedule makeCopy();
}
