package com.example.color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
View vColor;
TextView tvCode,tvValue;
SeekBar sbRed,sbGreen,sbBlue;
int red=0,green=0,blue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vColor=findViewById(R.id.v_color);
        tvCode=findViewById(R.id.tv_code);
        tvValue=findViewById(R.id.tv_value);
        sbRed=findViewById(R.id.sb_red);
        sbGreen=findViewById(R.id.sb_green);
        sbBlue=findViewById(R.id.sb_blue);

        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //Use switch condition
        switch(seekBar.getId()){
            case R.id.sb_red:
                //when click or drag red seek bar
                // set red color
                red = i;
                break;
            case R.id.sb_green:
                //when click or drag green seek bar
                // set green color
                green=i;
                break;
            case R.id.sb_blue:
                //when click or drag blue seek bar
                // set blue  color
                blue=i;
                break;
        }

        //set background color on view
        vColor.setBackgroundColor(Color.rgb(red,green,blue));
        //Intialize string hex code
        String code=HexCode(red,green,blue);
        //set code on text view
        tvCode.setText(code.toUpperCase());
        //set Value on text View
        tvValue.setText(String.format("RGB(%d,%d,%d)",red,green,blue));
    }

    private String HexCode(int red, int green, int blue) {
        //Intialize String Code
        String code;
        //Add hash tag
        code = "#";
        //add red Color
        code+=Integer.toHexString(red);
        //add green Color
        code+=Integer.toHexString(green);
        //add blue Color
        code+=Integer.toHexString(blue);
          //return code
        return code;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}