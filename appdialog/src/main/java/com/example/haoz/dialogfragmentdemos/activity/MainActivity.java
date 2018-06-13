package com.example.haoz.dialogfragmentdemos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dialoglibrary.AlertDialog;
import com.example.haoz.dialogfragmentdemos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_activity_main);


    }
    public void tvClick(View view){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setContentView(R.layout.widget_md_dialog).addDefaultAnimation()
                .formBottom(true).fullWidth().show();
    }
}
