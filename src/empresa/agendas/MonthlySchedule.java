package empresa.agendas;

import java.util.ArrayList;

public class MonthlySchedule extends Schedule
{
    private String paymentMethod;
    private int payday;

    public MonthlySchedule(String paymentMethod, int payday) {
        this.paymentMethod = paymentMethod;
        this.payday = payday;
    }

    public int getPayday() {
        return payday;
    }

    public void setPayday(int payday) {
        this.payday = payday;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    @Override
    public void setFrequence(int frequence) {

    }

    @Override
    public void setDayWeek(int dayWeek) {

    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString()
    {
        return "Agenda:\n" + "Mensal " + payday;
    }

    @Override
    public void showSchedules(ArrayList<Schedule> agendas) {

        for(Schedule e : agendas){
            if(e instanceof MonthlySchedule){
                System.out.println("ID - [" + agendas.indexOf(e) + "]\n" + e.toString());
            }
        }
    }

    public boolean checkIfisToPay(int day, int week){
        if(day == getPayday()) return true;

        return false;
    }

    public MonthlySchedule makeCopy(){
        return new MonthlySchedule(this.paymentMethod, this.payday);
    }
}