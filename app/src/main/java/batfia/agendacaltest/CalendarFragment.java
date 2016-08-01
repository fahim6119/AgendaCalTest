package batfia.agendacaltest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import batfia.agendacaltest.lib_agendaCal.AgendaCalendarView;
import batfia.agendacaltest.lib_agendaCal.CalendarPickerController;
import batfia.agendacaltest.lib_agendaCal.DrawableCalendarEvent;
import batfia.agendacaltest.lib_agendaCal.DrawableEventRenderer;
import batfia.agendacaltest.lib_agendaCal.models.BaseCalendarEvent;
import batfia.agendacaltest.lib_agendaCal.models.CalendarEvent;
import batfia.agendacaltest.lib_agendaCal.models.DayItem;
import butterknife.Bind;
import butterknife.ButterKnife;

public class CalendarFragment extends Fragment  implements CalendarPickerController {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String LOG_TAG = "checkLog";

    AgendaCalendarView mAgendaCalendarView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("checkLog","Came to Create");
        View view =inflater.inflate(R.layout.fragment_calendar, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("checkLog","Came to Bind");
        mAgendaCalendarView = (AgendaCalendarView) view.findViewById(R.id.agenda_calendar_view);
        //mAgendaCalendarView=new AgendaCalendarView(getContext());
        ButterKnife.bind(view,getActivity());
        Calendar minDate = Calendar.getInstance();
        Calendar maxDate = Calendar.getInstance();

        minDate.add(Calendar.MONTH, -2);
        minDate.set(Calendar.DAY_OF_MONTH, 1);
        maxDate.add(Calendar.YEAR, 1);

        List<CalendarEvent> eventList = new ArrayList<>();
        mockList(eventList);

        mAgendaCalendarView.init(eventList, minDate, maxDate, Locale.getDefault(), this);
        mAgendaCalendarView.addEventRenderer(new DrawableEventRenderer());

        // Inflate the layout for this fragment
        Log.i("checkLog","Came to Inflate");
        //ButterKnife.bind(getActivity());
    }


    @Override
    public void onDaySelected(DayItem dayItem) {
        Log.d(LOG_TAG, String.format("Selected day: %s", dayItem));
    }

    @Override
    public void onEventSelected(CalendarEvent event) {
        Log.d(LOG_TAG, String.format("Selected event: %s", event));
    }

    @Override
    public void onScrollToDate(Calendar calendar) {
       /*
         if (getActivity().getSupportActionBar() != null) {
            getActivity().getSupportActionBar().setTitle(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        }
        */
    }

    // endregion

    // region Private Methods

    private void mockList(List<CalendarEvent> eventList) {
        Calendar startTime1 = Calendar.getInstance();
        Calendar endTime1 = Calendar.getInstance();
        endTime1.add(Calendar.MONTH, 1);
        BaseCalendarEvent event1 = new BaseCalendarEvent("Thibault travels in Iceland", "A wonderful journey!", "Iceland",
                ContextCompat.getColor(getActivity(), R.color.orange_dark), startTime1, endTime1, true);
        eventList.add(event1);

        BaseCalendarEvent eventX = new BaseCalendarEvent("Fahim travels in Sylhet", "A memorable journey!", "Sylhet",
                ContextCompat.getColor(getActivity(), R.color.orange_dark), startTime1, endTime1, true);
        eventList.add(eventX);

        Calendar startTime2 = Calendar.getInstance();
        startTime2.add(Calendar.DAY_OF_YEAR, 1);
        Calendar endTime2 = Calendar.getInstance();
        endTime2.add(Calendar.DAY_OF_YEAR, 3);
        BaseCalendarEvent event2 = new BaseCalendarEvent("Visit to Dalvík", "A beautiful small town", "Dalvík",
                ContextCompat.getColor(getActivity(), R.color.yellow), startTime2, endTime2, true);
        eventList.add(event2);

        Calendar startTime3 = Calendar.getInstance();
        Calendar endTime3 = Calendar.getInstance();
        startTime3.set(Calendar.HOUR_OF_DAY, 14);
        startTime3.set(Calendar.MINUTE, 0);
        endTime3.set(Calendar.HOUR_OF_DAY, 15);
        endTime3.set(Calendar.MINUTE, 0);
        DrawableCalendarEvent event3 = new DrawableCalendarEvent("Visit of Harpa", "", "Dalvík",
                ContextCompat.getColor(getActivity(), R.color.blue_dark), startTime3, endTime3, false, android.R.drawable.ic_dialog_info);
        eventList.add(event3);
    }

}
