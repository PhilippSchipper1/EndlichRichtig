package de.fs.endlichrichtig;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataHelper {

    public static ArrayList<Workout> loadWokrout(Context context) {
        String json = "";
        ArrayList<Workout> workouts = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open("Crossfit_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("girlsBenchmark");

            for (int i =0; i<jsonArray.length(); i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                Workout workout= new Workout();
                workout.setTitle(jsonObject.getString("title"));
                workout.setWod(jsonObject.getString("wod  "));

                workouts.add(workout);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return workouts;
    }

}
