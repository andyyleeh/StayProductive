package me.andrewhanselee.stayproductive;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {

    private Button startB;
    private Button profileB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startB = (Button) findViewById(R.id.start_button);
        profileB = (Button) findViewById(R.id.profile_button);
    }

    static {
        System.loadLibrary("native-lib");
    }

    public void viewProfile(View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void startSetup(View view){
        Intent intent = new Intent(this, setup.class);
        startActivity(intent);
    }

}
