package com.nyc.in_class_dec_10_four;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<BirdModel> birds;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        birds = new ArrayList<>();
        ArrayList<String> members;

        try {
            JSONObject jsonObject = new JSONObject(Constant.json);
            JSONArray jsonArray = jsonObject.getJSONArray("birds");
            ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length() ; i++) {
                jsonObjectArrayList.add(new JSONObject(jsonArray.get(i).toString()));
            }
            for (int i = 0; i < jsonObjectArrayList.size(); i++) {
                members=new ArrayList<>();
                String family = jsonObjectArrayList.get(i).get("family").toString();
                JSONArray memberList = new JSONArray(jsonObjectArrayList.get(i).get("members").toString());
                for (int j = 0; j < memberList.length(); j++) {
                    members.add(memberList.get(j).toString());
                }
                birds.add(new BirdModel(family));
                birds.get(i).setMembers(members);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < birds.size(); i++) {
            Log.d("MainActivity", "Family: " + birds.get(i).getFamily());
            for (String s :birds.get(i).getMembers()) {
                Log.d("MainActivity", "Members: " + s);
            }
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        Adapter adapter = new Adapter(birds);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
