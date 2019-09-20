package com.example.ovulationcalculator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    CalendarView simpleCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView);
//        simpleCalendarView.setFocusedMonthDateColor(Color.RED);
//        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE);
//        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED);
//        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN);
//
//        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
//                String dt = year + "-" + month + "-" +dayOfMonth ;
//                Log.d("date",""+dayOfMonth + "-" + month + "-" + year );
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                Calendar c = Calendar.getInstance();
//                try {
//                    c.setTime(sdf.parse(dt));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                c.add(Calendar.DATE, 28);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
//                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
//                String output = sdf1.format(c.getTime());
//
//                Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
