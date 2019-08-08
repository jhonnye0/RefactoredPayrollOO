package empresa.agendas;

import facade.ExceptionCatch;
import java.util.Scanner;

public class Time {

    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();
    private static int HOUR = 0;
    private static int DAY = 1;
    private static int WEEK = 0;

    public void Do(){
        System.out.println("\nEscolha uma opcao:\n" +
                "1. Setar tempo\n" +
                "2. Checar tempo\n" +
                "3. Modificar tempo especifico");

        int operation = except.numcheckException(1,3);

        if(operation == 1){
            setTime();
        }else if(operation == 2){
            toString();
        }else {
            setEscTime();
        }
    }

    public void setEscTime(){
        System.out.println("\nO que deseja alterar?\n" +
                "1. Hora\n" +
                "2. Dia\n" +
                "3. Semana\n");
        int operation = except.numcheckException(1,3);

        if(operation == 1){
            setHOUR();
        }else if(operation == 2){
            setDAY();
        }else {
            setWEEK();
        }
    }

    public void setTime(){
        System.out.println("Digite a hora que deseja: (0 - 23)");
        this.HOUR = except.numcheckException(0,23);
        System.out.println("Digite o dia que deseja: (1 - 31)");
        this.DAY = except.numcheckException(1,31);
        System.out.println("Digite a semana que deseja:");
        this.WEEK = except.numcheckException(0,-1);
    }

    public String toString(){
        return "\nHour: " + getHOUR() +
                "\nDay: " + getDAY() +
                "\nWeek: " + getWEEK() + "\n";
    }

    public int getHOUR() {
        return HOUR;
    }

    public void setHOUR() {

        System.out.println("Quantas horas deseja passar?");
        int n = except.numcheckException(0,-1);
        Time.HOUR += HOUR;
        Time.HOUR %= 24;
        if(Time.HOUR == 0) DAY++;
        DAY %= 365;
        WEEK = DAY/7;

        System.out.println("Hora(s) passada(s) com sucesso.");
    }

    public void setDAY() {

        System.out.println("Quantos dias deseja passar?");
        int n = except.numcheckException(0,-1);

        Time.DAY += DAY;
        DAY %= 365;
        WEEK = DAY/7;

        System.out.println("Dia(s) passado(s) com sucesso.");
    }

    public int getDAY() {
        return DAY;
    }

    public int getWEEK() {
        return WEEK;
    }

    public void setWEEK() {

        System.out.println("Quantas semanas deseja passar?");
        int n = except.numcheckException(0,-1);
        Time.WEEK += WEEK;

        System.out.println("Semana(s) passadas com sucesso.");
    }
}
