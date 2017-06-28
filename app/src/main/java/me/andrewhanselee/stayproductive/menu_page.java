package me.andrewhanselee.stayproductive;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onResume(){
        super.onResume();

        userinfo.dbOP = new dataOperations(this);

        StringBuffer buffer = new StringBuffer();
        Cursor res = userinfo.dbOP.getInfo(userinfo.dbOP);
        while (res.moveToNext()) {
            buffer.append("Name :"+ res.getString(0)+"\n");
            buffer.append("Complete :"+ res.getString(1)+"\n");
            buffer.append("Fail :"+ res.getString(2)+"\n");
        }
        res.close();

        showMessage("Data",buffer.toString());
        Log.d("name", dataTable.tableInfo.USER_ID);
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
