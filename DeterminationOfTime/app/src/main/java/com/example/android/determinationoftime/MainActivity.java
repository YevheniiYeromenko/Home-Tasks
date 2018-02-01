package com.example.android.determinationoftime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Processing EditText Method
     * @return
     */
    public long processingEditText(){
        EditText editTextMs = (EditText) findViewById(R.id.ms_et);
        String stringEditText = "" + editTextMs.getText();
        long integerEditText = Long.parseLong(stringEditText);
        return integerEditText;
    }

    /**
     * Determination of Date and Time
     * @param miliseconds
     * @return
     */
    public String solution(long miliseconds){
        long ms = miliseconds % 1000;
        long secTmp = miliseconds / 1000;
        long sec = secTmp % 60;
        long minTmp = secTmp / 60;
        long min = minTmp % 60;
        long hourTmp = minTmp /60;
        long hour = hourTmp % 24;
        long daysTmp = hourTmp / 24;
        long days = daysTmp % 365 + 1;
        //long day = 1;
        long yearTmp = daysTmp / 365 + 1;

        int mounthNumber = 1;
        String mounthCalendar = "January";

        if (days > 0 && days <= 31) {
            mounthNumber = 1;
            mounthCalendar = "January";
        }
        if (days > 31 && days <= 59) {
            mounthNumber = 2;
            mounthCalendar = "February";
            days = days - 31;
        }
        if (days > 59 && days <= 90) {
            mounthNumber = 3;
            mounthCalendar = "March";
            days = days - 59;
        }
        if (days > 90 && days <= 120) {
            mounthNumber = 4;
            mounthCalendar = "April";
            days = days - 90;
        }
        if (days > 120 && days <= 151) {
            mounthNumber = 5;
            mounthCalendar = "May";
            days = days - 120;
        }
        if (days > 151 && days <= 181) {
            mounthNumber = 6;
            mounthCalendar = "June";
            days = days - 151;
        }
        if (days > 181 && days <= 212) {
            mounthNumber = 7;
            mounthCalendar = "July";
            days = days - 181;
        }
        if (days > 212 && days <= 243) {
            mounthNumber = 8;
            mounthCalendar = "August";
            days = days - 212;
        }
        if (days > 243 && days <= 273) {
            mounthNumber = 9;
            mounthCalendar = "September";
            days = days - 243;
        }
        if (days > 273 && days <= 304) {
            mounthNumber = 10;
            mounthCalendar = "October";
            days = days - 273;
        }
        if (days > 304 && days <= 334) {
            mounthNumber = 11;
            mounthCalendar = "November";
            days = days - 304;
        }
        if (days > 334 && days <= 365) {
            mounthNumber = 12;
            mounthCalendar = "December";
            days = days - 334;
        }

        return "Present date is:"   + "Year: # " + yearTmp + "\n"
                                    + "Mounth: " + mounthCalendar + "(" + mounthNumber + ")" + "\n"
                                    + "Day: " + days + "\n" +
                "Time is:"          + hour + "h "
                                    + min + "m "
                                    + sec + "s "
                                    + ms + "ms";
    }


    /**
     * Processing button press
     * @param view
     */
    public void showResult(View view){
        TextView textViewResult = (TextView) findViewById(R.id.result_tv);
        String result = solution(processingEditText());
        textViewResult.setText(result);
    }
}
