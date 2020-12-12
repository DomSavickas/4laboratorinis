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

public class DeleteNoteActivity extends AppCompatActivity {

    ArrayList<String> listNoteItems = new ArrayList<>();
    ArrayAdapter adapter;
    ListView lvNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);
        this.lvNotes = findViewById(R.id.lvNotes);
        DataBaseHelper dataBasehelper = new DataBaseHelper(DeleteNoteActivity.this);
        this.adapter = new ArrayAdapter<NotesModel>(DeleteNoteActivity.this, android.R.layout.simple_list_item_1, dataBasehelper.getEveryone());
        this.lvNotes.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        DataBaseHelper dataBasehelper = new DataBaseHelper(DeleteNoteActivity.this);

        adapter = new ArrayAdapter<NotesModel>(DeleteNoteActivity.this, android.R.layout.simple_list_item_1, dataBasehelper.getEveryone());
        lvNotes.setAdapter(adapter);
    }

}