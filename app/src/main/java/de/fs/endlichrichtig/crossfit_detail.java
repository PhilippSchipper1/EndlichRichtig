 package de.fs.endlichrichtig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

 public class crossfit_detail extends AppCompatActivity {

    private TextView title;
     private TextView wod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfit_detail);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
         String t = extra.getString("EXTRA_TITLE");
         String w = extra.getString("EXTRA_WOD");

         title.setText(t);
         wod.setText(w);

        }

        title=findViewById(R.id.title_tv);
        wod=findViewById(R.id.wod_tv);
    }
}
