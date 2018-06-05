package com.example.android.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etName;

    private SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.name_edit_text);


        /**
         * Get a reference from an object of the SharePreferences class
         * via the inherited getSharedPreferences first parameter for
         * name of preference file and the second parameter for the way
         * the file is created
         */
        preference = getSharedPreferences("data_name", Context.MODE_PRIVATE);

        /**
         *  Extract the data from the preference file
         */
        String strName = preference.getString("name","");

        etName.setText(strName);
    }



    public void save(View view) {
        /**
         *  Get value from EditText (name) and save it
         *  in preference file
         */
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("name",etName.getText().toString());
        editor.commit();
    }
}
