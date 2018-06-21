package com.example.simon.funfacts;

import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();
    // declare our view variables
    private TextView factTextView;
    private Button showFactButton;
    private EditText hoursInput;
    private RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // assign the views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        hoursInput = findViewById(R.id.editHours);
        background = findViewById(R.id.background);
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                // button was clicked so update the view with a new fun fact
                String fact = factBook.getFact();
                factTextView.setText(fact);
                background.setBackgroundColor(colorWheel.getColor());
                showFactButton.setTextColor(colorWheel.getColor());

                //String value = hoursInput.getText().toString(); //sätter användarens input till en sträng
                //int hours = new Integer(value).intValue(); //omvandlar inputsträngen till en integer
                //hours += 5;
                //factTextView.setText(String.valueOf(hours)); //sätter textviewen till siffran som användaren skrivit in
                }
        };
        showFactButton.setOnClickListener(listener);

        Toast.makeText(this, "Yay, din morsa e snygg", Toast.LENGTH_SHORT).show();
    }

}
