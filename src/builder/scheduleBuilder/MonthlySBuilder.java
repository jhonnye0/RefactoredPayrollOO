package builder.scheduleBuilder;

import empresa.agendas.*;
import facade.ExceptionCatch;
import java.util.*;

public class MonthlySBuilder implements ScheduleBuilder{

    Schedule schedule;
    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    @Override
    public void buildPayday() {
        System.out.println("Qual o dia do pagamento?");
        int valid = checkValid();
        schedule = new MonthlySchedule("Não tem", valid);
    }

    @Override
    public void buildFrequence() {

    }

    @Override
    public void buildDayWeek() {

    }

    @Override
    public Schedule getSchedule() {
        return schedule;
    }

    public int checkValid() {
        String valid;

        while (true) {
            try{
                valid = input.nextLine();

                if(valid.equals("$")) return 31;
                else if ((Integer.parseInt(valid) >= 0 && Integer.parseInt(valid) <= 31)) {
                    return Integer.parseInt(valid);
                }
                else System.out.println("Intervalo inadequado, digite novamente..");
            }catch (Exception e){
                System.out.println("Tipo inadequado digite novamente!");
            }
        }
    }
}
