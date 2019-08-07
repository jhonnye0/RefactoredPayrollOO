package builder.scheduleBuilder;

import empresa.agendas.Schedule;
import facade.ExceptionCatch;

import java.util.ArrayList;
import java.util.Scanner;

public class ScheduleEngineer {

    ScheduleBuilder scheduleBuilder;

    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    public ScheduleEngineer(ScheduleBuilder builder){
        scheduleBuilder = builder;
    }

    public void construct(){
        scheduleBuilder.buildDayWeek();
        scheduleBuilder.buildFrequence();
        scheduleBuilder.buildPayday();
    }

    public Schedule getSchedule(){
        return this.scheduleBuilder.getSchedule();
    }
}
