package ru.gb.androidlessonsix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String NOTES = "notes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] countries = getResources().getStringArray(R.array.country_names);
        String[] capitals = getResources().getStringArray(R.array.country_capital);
        ArrayList<Note> notes = Note.initArrayNote(capitals, countries);

        NoteFragment noteFragment = new NoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(NOTES, notes);
        noteFragment.setArguments(bundle);


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, noteFragment)
                    .commit();
        }
    }
}