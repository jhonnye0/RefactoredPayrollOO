package builder.scheduleBuilder;

import empresa.agendas.Schedule;
import empresa.agendas.WeeklySchedule;
import facade.ExceptionCatch;
import java.util.*;

public class WeeklySBuilder implements ScheduleBuilder{

    Schedule schedule;
    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    public WeeklySBuilder(){
        schedule = new WeeklySchedule("nao tem", 0 ,0);
    }

    @Override
    public void buildPayday() {

    }

    @Override
    public void buildFrequence() {
        System.out.println("Qual a frequencia pagamento?(acima de 3 semanas é inviavel)");
        schedule.setFrequence(except.numcheckException(1,3));
    }

    @Override
    public void buildDayWeek() {
        System.out.print("Qual dia da semana sera efetuado o pagamento?\n\n" +
                "1. Domingo\n" +
                "2. Segunda\n" +
                "3. Terca\n" +
                "4. Quarta\n" +
                "5. Quinta\n" +
                "6. Sexta\n" +
                "7. Sabado\n");

        schedule.setDayWeek(except.numcheckException(1,7));
    }

    @Override
    public Schedule getSchedule() {
        return schedule;
    }
}
