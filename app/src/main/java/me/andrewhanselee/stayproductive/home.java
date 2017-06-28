package me.andrewhanselee.stayproductive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity {

    private Button startB;
    private Button profileB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startB = (Button) findViewById(R.id.start_button);
        profileB = (Button) findViewById(R.id.profile_button);


        SharedPreferences sp = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Boolean isFirstRun = sp.getBoolean("firstGo", true);

        String run = Boolean.toString(isFirstRun);

        if (!isFirstRun) {
            startActivity(new Intent(this, menu_page.class));
            finish();
        } else {

            editor.putBoolean("firstGo", false).commit();
        }

    }

    public void getStarted(View view){
        Intent intent = new Intent(this, userinfo.class);
        startActivity(intent);
        finish();
    }



}
