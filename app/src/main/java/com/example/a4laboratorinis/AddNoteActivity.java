package com.example.a4laboratorinis;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    EditText edNote;
    EditText edTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        this.edNote = findViewById(R.id.edNote);
        this.edTitle = findViewById(R.id.edTitle);
    }

    public void onBtnSaveAndCloseClick(View view) {
        NotesModel notesModel = new NotesModel(-1, edTitle.getText().toString(), edNote.getText().toString());
        Toast.makeText(AddNoteActivity.this, notesModel.toString(), Toast.LENGTH_SHORT).show();
        finish();
    }
}