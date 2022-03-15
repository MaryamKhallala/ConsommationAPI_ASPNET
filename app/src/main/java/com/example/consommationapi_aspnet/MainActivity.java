package com.example.consommationapi_aspnet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.Model.Livre;
import com.example.controller.ApiFetcher;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final String API_LINK = "http://192.168.0.113:45457/api/showLivres";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        @SuppressLint("StaticFieldLeak")
        class LiverTask extends AsyncTask<String, Void, List<Livre>>{
            @Override
            protected List<Livre> doInBackground(@NonNull String... strings) {

                List<Livre> liteLivers = new ArrayList<>();
                try {
                    liteLivers = ApiFetcher.GetLivers(new URL(strings[0]), getApplicationContext());

                }catch (IOException e){
                    System.out.println("==IO" + e);
                } catch (JSONException e){
                    System.out.println("==JSON" + e);
                }
                return  liteLivers;
            }

            @Override
            protected void onPostExecute(List<Livre> livers) {
                super.onPostExecute(livers);
                ArrayList<String> lv_arr = new ArrayList<>();
                for(int i=0; i<livers.size(); i++){
                    lv_arr.add(livers.get(i).toString());
                }
                listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.text_view_livre, lv_arr));
            }
        }
        new LiverTask().execute(API_LINK);
    }

}