package me.andrewhanselee.stayproductive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Andrew on 2017-05-29.
 */

public class unlockReceiver extends BroadcastReceiver{


    public unlockReceiver(){

    }
    private static final String TAG = "unlockReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
        setup.num_rem -= 1;
        if(setup.num_rem == 0){

            in_progress.cdt.cancel();
        }
        setup.str = Integer.toString(setup.num_rem);
    }


}

