package me.andrewhanselee.stayproductive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class in_progress extends AppCompatActivity {

    private TextView time_remaining;
    private TextView num_unlock_rem;
    private String value;
    public static BroadcastReceiver br;
    public static CountDownTimer cdt;
    int complete;
    int fail;
    String newComplete;
    Context ctxt = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_progress);

        time_remaining = (TextView) findViewById(R.id.time_remaining);
        num_unlock_rem = (TextView) findViewById(R.id.num_unlock_rem);

        //setup receiver
        br = new unlockReceiver();

        IntentFilter filter = new IntentFilter(Intent.ACTION_USER_PRESENT);
        this.registerReceiver(br, filter);


        num_unlock_rem.setText("Remaining unlocks: " + setup.str);
        reverseTimer(setup.time * 60, time_remaining);

        Cursor cr = userinfo.dbOP.getInfo(userinfo.dbOP);
        cr.moveToFirst();

        complete = Integer.parseInt(cr.getString(1));
        fail = Integer.parseInt(cr.getString(2));




    }

    @Override
    protected void onResume(){
        super.onResume();
        num_unlock_rem.setText("Remaining unlocks: " + setup.str);
    }


    public void reverseTimer(int Seconds,final TextView tv){

        cdt = new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText("TIME : " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                complete ++;
                newComplete = String.valueOf(complete);
                StringBuffer buffer = new StringBuffer();
                Cursor res = userinfo.dbOP.getInfo(userinfo.dbOP);
                res.moveToFirst();
                while (res.moveToNext()) {
                    buffer.append("Name :"+ res.getString(0)+"\n");
                    buffer.append("Complete :"+ res.getString(1)+"\n");
                    buffer.append("Fail :"+ res.getString(2)+"\n");
                }
                res.moveToFirst();

                showMessage("Data",buffer.toString());

                Log.d("fail", "here?");
                userinfo.dbOP.updateInfo(userinfo.dbOP, res.getString(0), newComplete, res.getString(2));
                Log.d("fail", "or here?");


                tv.setText("Completed");

                res.close();
                unregisterReceiver(br);
            }
        }.start();
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
