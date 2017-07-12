package com.example.userpc.app1;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myListView = (ListView) findViewById(R.id.myListView);
        final SeekBar multBar = (SeekBar) findViewById(R.id.multBar);

        multBar.setMax(20);
        multBar.setProgress(10);
        multBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 0){
                    progress = 1;
                    multBar.setProgress(1);
                }
                ArrayList<Integer> multTable = new ArrayList<Integer>();
                for(int i = 1; i <= 10; i++){
                    multTable.add(progress*i);
                }
                ArrayAdapter<Integer> myArrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, multTable);
                myListView.setAdapter(myArrayAdapter);
                Log.i("Info", String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
