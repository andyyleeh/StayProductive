package me.andrewhanselee.stayproductive;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {

    private TextView succ;
    private TextView fail;
    private TextView userN;
    Context ctxt = this;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userN = (TextView) findViewById(R.id.username);
        succ = (TextView) findViewById(R.id.num_complete);
        fail = (TextView) findViewById(R.id.num_fail);


        setValues();
    }

    @Override
    protected void onResume(){
        super.onResume();

        setValues();
    }

    protected void setValues(){
        Cursor cr = userinfo.dbOP.getInfo(userinfo.dbOP);

        cr.moveToFirst();
        name = cr.getString(0);
        userN.setText(name);
        fail.setText("Failures: "+cr.getString(2));
        succ.setText("Completed: "+cr.getString(1));
    }
}
