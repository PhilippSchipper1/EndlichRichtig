package de.fs.endlichrichtig;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class crossfit extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private ArrayList<Workout> wodList;
    private ArrayList<String> titleList;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfit);
        lv = findViewById(R.id.lv);

       wodList= DataHelper.loadWokrout(this);
       titleList = new ArrayList<>();

       for(int i=0; i<wodList.size(); i++){
           String str = wodList.get(i).getTitle();
           titleList.add(str);
       }



       adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
       lv.setAdapter((ListAdapter) adapter);

       lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent =new Intent(this, crossfit_detail.class);

        String title = wodList.get(position).getTitle();
        String wod = wodList.get(position).getWod();

        intent.putExtra("EXTRA_TITLE", title);
        intent.putExtra("EXTRA_WOD", wod);


    }
}
