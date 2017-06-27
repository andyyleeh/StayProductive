package me.andrewhanselee.stayproductive;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.security.AccessController.getContext;

public class userinfo extends AppCompatActivity {
    String userName;
    private EditText uN;
    Button goNext;
    Context ctxt = this;
    public static dataOperations dbOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        uN = (EditText) findViewById(R.id.name);
        goNext = (Button) findViewById(R.id.sendInfo);

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = uN.getText().toString();

                dbOP = new dataOperations(ctxt);
                dbOP.addData(dbOP, userName, "0", "0");

                goHome();
            }
        });
    }


    public void goHome(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
        finish();
    }
}
