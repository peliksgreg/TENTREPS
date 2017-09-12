package com.google.maps.android.utils.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Help extends AppCompatActivity {

    private TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        text1 = (TextView)findViewById(R.id.help);
        text2 = (TextView)findViewById(R.id.instructions);


    }
}
