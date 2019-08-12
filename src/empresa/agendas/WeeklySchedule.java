package empresa.agendas;

import java.util.ArrayList;

public class WeeklySchedule extends Schedule {

    private int frequence;
    private int dayWeek;
    private String dW;
    private String paymentMethod;

    public WeeklySchedule(String paymentMethod, int frequence, int dayWeek) {
        this.paymentMethod = paymentMethod;
        this.frequence = frequence;
        this.dayWeek = dayWeek;

        switch (this.dayWeek) {
            case 1:
                dW = "Domingo";
                break;
            case 2:
                dW = "Segunda";
                break;
            case 3:
                dW = "Terça";
                break;
            case 4:
                dW = "Quarta";
                break;
            case 5:
                dW = "Quinta";
                break;
            case 6:
                dW = "Sexta";
                break;
            case 7:
                dW = "Sábado";
                break;
            default:
                break;
        }
    }

    public WeeklySchedule makeCopy(){
        return new WeeklySchedule(this.paymentMethod, this.frequence, this.dayWeek);
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public int getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(int dayWeek) {
        this.dayWeek = dayWeek;

        switch (this.dayWeek) {
            case 1:
                dW = "Domingo";
                break;
            case 2:
                dW = "Segunda";
                break;
            case 3:
                dW = "Terça";
                break;
            case 4:
                dW = "Quarta";
                break;
            case 5:
                dW = "Quinta";
                break;
            case 6:
                dW = "Sexta";
                break;
            case 7:
                dW = "Sábado";
                break;
            default:
                break;
        }
    }

    @Override
    public void setPayday(int payday) {

    }

    @Override
    public void showSchedules(ArrayList<Schedule> agendas) {

        for(Schedule e : agendas){
            if(e instanceof WeeklySchedule){
                System.out.println("ID - [" + agendas.indexOf(e) + "]\n" + e.toString());
            }
        }
    }

    public boolean checkIfisToPay(int day, int week){
        if(getFrequence()%week == 0){
            if(getDayWeek() == day) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Agenda:\n" + "Semanal " + this.frequence + " " + this.dW;
    }
}
