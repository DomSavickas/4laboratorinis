package com.example.a4laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DeleteNoteActivity extends AppCompatActivity {
    private Button btnAddNote, btnDelete;
    Button View_List;
    ListView note_list;
    Spinner deleteSpinner;

    ArrayAdapter noteArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);
        btnDelete = findViewById(R.id.btnDelete);
        deleteSpinner = findViewById(R.id.deleteSpinner);
        final DataBaseHelper db = new DataBaseHelper(this);
        Integer delete = db.deletedata(3);



        final DataBaseHelper dataBasehelper = new DataBaseHelper(DeleteNoteActivity.this);
        noteArrayAdapter = new ArrayAdapter<NotesModel>(DeleteNoteActivity.this, android.R.layout.simple_list_item_1, dataBasehelper.getEveryone());

        Cursor data = dataBasehelper.getData();
        final ArrayList<String> listData = new ArrayList<>();
//
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(DeleteNoteActivity.this, android.R.layout.simple_expandable_list_item_1, listData);

        deleteSpinner.setAdapter(noteArrayAdapter);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(deleteSpinner.getSelectedItem());
                NotesModel currentAbstractNote = (NotesModel) deleteSpinner.getSelectedItem();
                NotesModel currentNote = new NotesModel(currentAbstractNote.getId());
                System.out.println(currentAbstractNote.getId());
                Integer delete = db.deletedata(currentAbstractNote.getId());
                deleteSpinner.setAdapter(noteArrayAdapter);
                Toast.makeText(DeleteNoteActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}