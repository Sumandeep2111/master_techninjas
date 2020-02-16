package com.example.project_techninjas_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    AdapterNote adapterNote;
    List<Note> notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseNotes db = new DatabaseNotes(this);
        notes = db.getNotes();


        recyclerView = findViewById(R.id.listofNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterNote = new AdapterNote(this,notes);
        recyclerView.setAdapter(adapterNote);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add){
            Intent intent = new Intent(this,AddingNotes.class);
            startActivity(intent);

            Toast.makeText(this,"Add button is Clicked",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
