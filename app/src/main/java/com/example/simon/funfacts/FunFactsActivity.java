package com.example.simon.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private MinutesCount minutesCount = new MinutesCount();
    private HoursCount hoursCount = new HoursCount();
    private ColorWheel colorWheel = new ColorWheel();
    // declare our view variables
    private TextView timeTextView;
    private Button calculateButton;
    private EditText hoursInput;
    private RelativeLayout background;
    private EditText minutesInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // assign the views from the layout file to the corresponding variables
        timeTextView = findViewById(R.id.factTextView);
        calculateButton = findViewById(R.id.showFactButton);
        hoursInput = findViewById(R.id.editHours);
        background = findViewById(R.id.background);
        minutesInput = findViewById(R.id.editMinutes);
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                // button was clicked so update the view with a new fun fact

                background.setBackgroundColor(colorWheel.getColor());
                calculateButton.setTextColor(colorWheel.getColor());
                String stringHours = hoursInput.getText().toString();
                String stringMinutes = minutesInput.getText().toString();
                if (hoursCount.checkHours(stringHours) && minutesCount.checkMinutes(stringMinutes)){
                    hoursCount.setHours(hoursCount.calculateHours(hoursInput.getText().toString()));
                    minutesCount.setMinutes(minutesCount.calculateMinutes(minutesInput.getText().toString()));
                    int hours = hoursCount.getHours();
                    int minutes = minutesCount.getMinutes();
                    while(minutes > 59) {
                        hours++;
                        minutes = minutes - 60;
                        hoursCount.setHours(hours);
                        minutesCount.setMinutes(minutes);

                    }
                    String time = String.valueOf(hoursCount.getHours()) + " " + String.valueOf(minutesCount.getMinutes());
                    timeTextView.setText(time); //sätter textviewen till siffran som användaren skrivit in
                    minutesInput.getText().clear();
                    hoursInput.getText().clear();
                    hoursCount.clearHours();
                    minutesCount.clearMinutes();
                }else{
                    minutesInput.getText().clear();
                    hoursInput.getText().clear();
                    hoursCount.clearHours();
                    minutesCount.clearMinutes();
                }


                }
        };
        calculateButton.setOnClickListener(listener);
        Log.d(TAG, "We're logging from the log röv");
    }

    public boolean inputCheck(String input){
        int checker;
        try {
            checker = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @Override
    public void onBackPressed() {
        hoursInput.setText("");
        minutesInput.setText("");
        timeTextView.setText("");
    }

}
