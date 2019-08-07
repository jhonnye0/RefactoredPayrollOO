package builder.scheduleBuilder;

import empresa.agendas.Schedule;
import java.util.ArrayList;

public interface ScheduleBuilder {

    void buildPayday();

    void buildFrequence();

    void buildDayWeek();

    Schedule getSchedule();
}
