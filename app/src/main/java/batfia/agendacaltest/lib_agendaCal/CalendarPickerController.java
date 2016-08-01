package batfia.agendacaltest.lib_agendaCal;

import batfia.agendacaltest.lib_agendaCal.models.CalendarEvent;
import batfia.agendacaltest.lib_agendaCal.models.DayItem;

import java.util.Calendar;

public interface CalendarPickerController {
    void onDaySelected(DayItem dayItem);

    void onEventSelected(CalendarEvent event);

    void onScrollToDate(Calendar calendar);
}
