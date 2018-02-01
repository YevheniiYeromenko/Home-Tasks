package com.example.bicher.corectsequence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String solution(String arches){
        int cntOpenArches = 0;
        int cntCloseArches = 0;

        for (int i = 0; i < arches.length(); i++) {
            if (arches.charAt(i) == '(') cntOpenArches++;
            else if (arches.charAt(i) == ')') cntCloseArches++;
            else return "Invalid symbol";
        }
        if (cntCloseArches != cntOpenArches) return "Wrong sequence";

        int cntTrueSequence = 0;
        for (int i = 0; i < arches.length(); i++) {
            if (arches.charAt(i) == '(') cntTrueSequence++;
            if (arches.charAt(i) == ')') cntTrueSequence--;

            if (cntTrueSequence < 0) return "Wrong sequence";
        }
        return "True sequence";
    }

    public String processingEditText(){
        EditText editTextArches = (EditText) findViewById(R.id.arches_et);
        String stringArches = "" + editTextArches.getText();
        return stringArches;
    }

    public void showResult(View view){
        TextView textViewResult = (TextView) findViewById(R.id.result_tv);
        String result = solution(processingEditText());
        textViewResult.setText(result);
    }
}
