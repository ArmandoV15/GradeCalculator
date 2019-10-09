package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.calcButton);
        //Setting local variables equal to the id of my EditText
        final EditText desiredGrade = findViewById(R.id.editDesiredGrade);
        final EditText minimumAverage = findViewById(R.id.minAverage);
        final EditText currentAverage = findViewById(R.id.currentAvg);
        final EditText finalPercentage = findViewById(R.id.finalPercent);
        final TextView endMessage = findViewById(R.id.finalMessage);
        final TextView finalLetter = findViewById(R.id.finalLetterGrade);

        //anonymous class implementation of View.OnClickListener
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DecimalFormat df = new DecimalFormat(".00");
                String letter = desiredGrade.getText().toString();
                //try catch block so that the app doesn't crash if fields are empty
                try {
                    float minAvg = Float.parseFloat(minimumAverage.getText().toString());
                    float currAvg = Float.parseFloat(currentAverage.getText().toString());
                    float finalPercent = Float.parseFloat(finalPercentage.getText().toString());
                    finalLetter.setText("");
                    GradeCalculator calc = new GradeCalculator(minAvg, currAvg, finalPercent);
                    double finalNeededPercentage = calc.calculateFinalGrade();

                    if (finalNeededPercentage > 0 && finalNeededPercentage < 100) {
                        String lastMessage = "You need a score of " + df.format(finalNeededPercentage) + " on the final to earn a";
                        endMessage.setText(lastMessage);
                        finalLetter.setText(letter);
                    } else if (finalNeededPercentage < 0) {
                        endMessage.setText("You don't need to take the final!!");
                    }else if(finalNeededPercentage > 100){
                        endMessage.setText("The score you need is not feasible!");
                    }
                }catch (NumberFormatException e){
                    endMessage.setText("Please fill in all fields before calculating!!");
                }
            }
        });
    }
}


