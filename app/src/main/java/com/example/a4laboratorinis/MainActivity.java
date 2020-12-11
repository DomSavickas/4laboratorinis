package com.example.a4laboratorinis;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listNoteItems = new ArrayList<>();
    ArrayAdapter adapter;
    ListView lvNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvNotes = findViewById(R.id.lvNotes);
        DataBaseHelper dataBasehelper = new DataBaseHelper(MainActivity.this);
        this.adapter = new ArrayAdapter<NotesModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBasehelper.getEveryone());
        this.lvNotes.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_options_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        DataBaseHelper dataBasehelper = new DataBaseHelper(MainActivity.this);

        adapter = new ArrayAdapter<NotesModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBasehelper.getEveryone());
        lvNotes.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_note:
                Intent i = new Intent(this, AddNoteActivity.class);
                startActivity(i);
                return true;
            case R.id.delete_note:
                Intent a=new Intent(this, DeleteNoteActivity.class);
                startActivity(a);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

