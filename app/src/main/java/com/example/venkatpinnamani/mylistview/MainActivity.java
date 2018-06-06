package com.example.venkatpinnamani.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private String[] myStringArray = new String[]{
            "Shikhar Dhawan",
            "Rohith Sharma",
            "Virat Kohli",
            "Manish Pandey",
            "M S Dhoni",
            "Hardik Pandya",
            "R Jadeja",
            "R Ashwin",
            "B Kumar",
            "Umesh Yadav",
            "Jasprit Bumrah"
    };

    private Players[] mplayers = new Players[] {
            new Players("Shikhar Dhawan",25,"Sunrisers Hyderabad","bcci"),
            new Players("Rohith Sharma",45,"Mumbai Indians","bcci"),
            new Players("Virat Kohli",18,"Royal Challengers","bcci"),
            new Players("Manish Pandey",10,"Sunrisers Hyderabad","bcci"),
            new Players("M S Dhoni",07,"Chennai Super Kings","bcci"),
            new Players("Hardik Pandya",33,"Mumbai Indians","bcci"),
            new Players("R Jadeja",8,"Chennai Super Kings","bcci"),
            new Players("R Ashwin",99,"Chennai Super Kings","bcci"),
            new Players("B Kumar",15,"Sunrisers Hyderabad","bcci"),
            new Players("Umesh Yadav",19,"Royal Challengers","bcci"),
            new Players("Jasprit Bumrah",93,"Mumbai Indians","bcci")
    };


    ListView mListView;
    PlayerAdapterRecycler mPlayerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.myList);
        mPlayerAdapter = new PlayerAdapterRecycler(getApplicationContext(),R.layout.row,mplayers);

        if(mListView != null)
        {
            mListView.setAdapter(mPlayerAdapter);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Hello I Am " + mplayers[position].playerName,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
