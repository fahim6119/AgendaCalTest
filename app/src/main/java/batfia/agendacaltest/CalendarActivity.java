package batfia.agendacaltest;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

import batfia.agendacaltest.lib_agendaCal.AgendaCalendarView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class CalendarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initUI();
    }


    private void initUI() {

        // ntb

        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_habit_details);


        // adapter
        class MyPagerAdapter extends FragmentPagerAdapter {

            public MyPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int pos) {
                switch(pos) {

                    case 0: return new CalendarFragment();
                    default: return new CalendarFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        }

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

    }

}
