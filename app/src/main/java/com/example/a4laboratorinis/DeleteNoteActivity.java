package com.example.a4laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    ArrayList<String> listNoteItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView lvNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvNotes = findViewById(R.id.lvNotes);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.listNoteItems);
        this.lvNotes.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String note = sharedPref.getString(Constants.BASE_NOTE_KEY, "NotSet");

        this.listNoteItems.clear();
        this.listNoteItems.add(note);
        this.adapter.notifyDataSetChanged();

        //In case You will need to append/remove values from array:
        //https://stackoverflow.com/questions/9648236/android-listview-not-updating-after-a-call-to-notifydatasetchanged
    }
    /*public void onBtnSaveAndCloseClick(View view) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constants.BASE_NOTE_KEY, this.edNote.getText().toString());
        editor.apply();
        finish();
    }*/
}