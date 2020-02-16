package com.example.project_techninjas_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Calendar;

public class AddingNotes extends AppCompatActivity {

    Toolbar toolbar;
    EditText notetitle,notedetail;
    Calendar calendar;
    String todaysDate;
    String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_notes);

//       toolbar = findViewById(R.id.toolbar);
//       getSupportActionBar(toolbar);
//        setActionBar(toolbar);

        notetitle = findViewById(R.id.notetitle);
        notedetail = findViewById(R.id.notedetail);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setTitle("new notes");

        notetitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

//                if(s.length() != 0){
//                    getActionBar().setTitle(s);
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //get current date and time
        calendar = Calendar.getInstance();
        todaysDate = calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH);
        currentTime = pad(calendar.get(Calendar.HOUR))+":"+pad(calendar.get(Calendar.MINUTE));
        Log.d("calender","date and time:    " + todaysDate +" and " + currentTime);
    }

    private void getSupportActionBar(Toolbar toolbar) {
    }

    private String pad(int i) {
        if (i<10)
            return "0"+i;
        return String.valueOf(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete){
//            Intent intent = new Intent(this,AddingNotes.class);
//            startActivity(intent);

            Toast.makeText(this,"delete button is Clicked",Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.save){
            Note note = new Note(notetitle.getText().toString(),notedetail.getText().toString(),todaysDate,currentTime);
            DatabaseNotes db = new DatabaseNotes(this);
            db.addNote(note);

            Toast.makeText(this,"save button is Clicked",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
