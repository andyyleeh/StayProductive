package me.andrewhanselee.stayproductive;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class in_progress extends AppCompatActivity {

    private TextView time_remaining;
    private TextView num_unlock_rem;
    private String value;
    public static BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_progress);
        time_remaining = (TextView) findViewById(R.id.time_remaining);
        num_unlock_rem = (TextView) findViewById(R.id.num_unlock_rem);

        br = new unlockReceiver();

        IntentFilter filter = new IntentFilter(Intent.ACTION_USER_PRESENT);
        this.registerReceiver(br, filter);

        num_unlock_rem.setText("Remaining unlocks: " + setup.str);
        reverseTimer(setup.time * 60, time_remaining);


    }

    @Override
    protected void onResume(){
        super.onResume();
        num_unlock_rem.setText("Remaining unlocks: " + setup.str);
    }


    public void reverseTimer(int Seconds,final TextView tv){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText("TIME : " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {

                tv.setText("Completed");
                unregisterReceiver(br);
            }
        }.start();
    }

}
