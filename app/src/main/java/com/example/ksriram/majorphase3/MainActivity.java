package com.example.ksriram.majorphase3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    Button addButton;
    EditText GetValue;
    private int notificationId =1;
    String[] ListElements = new String[] {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.list);
        addButton = findViewById(R.id.button);
        GetValue = findViewById(R.id.editext);
        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

int c=0;
ListElementsArrayList.add(GetValue.getText().toString());
                adapter.notifyDataSetChanged();
                Pend(c);
            }
        });
    }
    public void Pend(int request){
        EditText editText = findViewById(R.id.editext);
        TimePicker timePicker = findViewById(R.id.timePicker);
        Intent intent = new Intent(MainActivity.this,Alaram.class);
        intent.putExtra("NotifiactionId",notificationId);
        intent.putExtra("todo",editText.getText().toString());


        final int _id = (int) System.currentTimeMillis();
        PendingIntent alaramIntent = PendingIntent.getBroadcast(this, _id, intent,PendingIntent.FLAG_ONE_SHOT);




        //PendingIntent alaramIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);

        String title = editText.getText().toString();
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        Calendar startTime  = Calendar.getInstance();

        startTime.set(Calendar.HOUR_OF_DAY,hour);
        startTime.set(Calendar.MINUTE,minute);
        startTime.set(Calendar.SECOND,0);
        long alaramstartTime = startTime.getTimeInMillis();
        alarm.set(AlarmManager.RTC_WAKEUP,alaramstartTime,alaramIntent);
        Toast.makeText(this,"Done!",Toast.LENGTH_SHORT).show();

    }
}
