package de.fs.endlichrichtig;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "de.fs.endlichrichtig.MESSAGE";

    private static final String TAG = "MainActivity";
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started");
        ListView lv_main = findViewById(R.id.lv_main);

        Functions bmi = new Functions("BMI");
        Functions crossfit = new Functions("Crossfit Exercises");
        Functions train = new Functions("Training");

        ArrayList<Functions> functions = new ArrayList<>();
        functions.add(bmi);
        functions.add(crossfit);
        functions.add(train);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, functions);
        lv_main.setAdapter(adapter);


    }
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText =(EditText) findViewById(R.id.editText);
        String message =editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

