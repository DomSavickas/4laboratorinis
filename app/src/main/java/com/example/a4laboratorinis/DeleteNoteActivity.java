package com.example.a4laboratorinis;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {
    private Button btnDelete;
    Spinner spinnerWithListItems;

    ArrayAdapter noteItemArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);
        btnDelete = findViewById(R.id.btnDelete);
        spinnerWithListItems = findViewById(R.id.spinnerWithListItems);
        final DataBaseHelper db = new DataBaseHelper(this);
        Integer delete = db.deletedata(3);



        final DataBaseHelper dataBasehelper = new DataBaseHelper(DeleteNoteActivity.this);
        noteItemArrayAdapter = new ArrayAdapter<NotesModel>(DeleteNoteActivity.this, android.R.layout.simple_list_item_1, dataBasehelper.getEveryone());

        Cursor data = dataBasehelper.getData();
        final ArrayList<String> listData = new ArrayList<>();
//
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(DeleteNoteActivity.this, android.R.layout.simple_expandable_list_item_1, listData);

        spinnerWithListItems.setAdapter(noteItemArrayAdapter);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(spinnerWithListItems.getSelectedItem());
                NotesModel currentAbstractNote = (NotesModel) spinnerWithListItems.getSelectedItem();
                NotesModel currentNote = new NotesModel(currentAbstractNote.getId());
                System.out.println(currentAbstractNote.getId());
                Integer delete = db.deletedata(currentAbstractNote.getId());
                spinnerWithListItems.setAdapter(noteItemArrayAdapter);
                finish();
            }
        });
    }
}