package com.example.admin.searchviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declare Variables
    ListView listView;
    ListViewAdapter adapter;
    SearchView searchView;
    String[] animalNameList;
    ArrayList<AnimalNames> arrayList = new ArrayList<AnimalNames>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        searchView = (SearchView) findViewById(R.id.search_view);

        animalNameList = new String[]{"Lion", "Tiger", "Dog",
                "Cat", "Tortoise", "Rat", "Elephant", "Fox",
                "Cow","Donkey","Monkey"};

        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arrayList.add(animalNames);
        }

        adapter = new ListViewAdapter(this, arrayList);

        // Binds the Adapter to the ListView
        if(listView != null){
            listView.setAdapter(adapter);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adapter.filter(text);
                return false;
            }
        });

    }
}
