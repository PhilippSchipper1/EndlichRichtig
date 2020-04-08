package de.fs.endlichrichtig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {
    EditText height, weight;
    TextView result = findViewById(R.id.result);
    String calculation, BMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weight= findViewById(R.id.weight);
        height= findViewById(R.id.height);

    }

    public void calculateBMI(View view) {
        String w= weight.getText().toString();
        String h= height.getText().toString();

        float w_calc = Float.parseFloat(w);
        float h_calc = Float.parseFloat(h) / 100;

        float bmi = w_calc / (h_calc * h_calc);

        if(bmi<16) BMIresult="Stark  untergewichtig";

        else if(bmi>= 18.5)BMIresult="untergewichtig";

        else if(bmi>= 18.5 && bmi<= 24.9)BMIresult="normal";

        else if(bmi>= 25 && bmi<= 29.9)BMIresult="übergewichtig";

        else BMIresult="adipös";

        calculation= "Result:  "+ bmi+ BMIresult;

        result.setText(calculation);

    }
}
