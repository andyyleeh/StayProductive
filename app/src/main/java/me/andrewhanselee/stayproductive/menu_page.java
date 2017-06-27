package me.andrewhanselee.stayproductive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
    }

    public void viewProfile(View view){
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

    public void startSetup(View view){
        Intent intent = new Intent(this, setup.class);
        startActivity(intent);
    }
}
