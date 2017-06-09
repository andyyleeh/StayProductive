package me.andrewhanselee.stayproductive;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class setup extends AppCompatActivity {

    private Button beginB;
    private EditText time_indic;
    private static EditText num;

    public static int num_rem;
    public static String str;
    public static int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        beginB = (Button) findViewById(R.id.begin_button);
        time_indic = (EditText) findViewById(R.id.time_indicator);
        num = (EditText) findViewById(R.id.num_unlock);


    }

    public void begin(View view){
        Intent intent = new Intent(this, in_progress.class);
        startActivity(intent);
        num_rem = getValue(num);
        time = getValue(time_indic);
    }


    private static int getValue(final EditText et){
        str = et.getText().toString();
        int val = Integer.parseInt(str);
        return val;
    }


}
