package com.cat300.IndoorNavigationSystem;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    private SharedPreferences pref;
    private EditText roomTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pref = PreferenceManager.getDefaultSharedPreferences(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.nav_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomTextView = (EditText)findViewById(R.id.room_edittext);
                if(roomTextView.length() != 0) {
                    pref.edit().putString("destinationId", roomTextView.getText().toString().trim()).apply();
                    finish();
                }
                else {
                    Toast.makeText(Search.this, getString(R.string.no_destination_specified),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
