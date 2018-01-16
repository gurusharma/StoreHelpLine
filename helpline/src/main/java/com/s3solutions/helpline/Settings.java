package com.s3solutions.helpline;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.settings);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.check(R.id.radio_green);
        final RadioButton radio_green = (RadioButton) findViewById(R.id.radio_green);
        final RadioButton radio_purple = (RadioButton) findViewById(R.id.radio_purple);
        final RadioButton radio_orange = (RadioButton) findViewById(R.id.radio_orange);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radio_green.isChecked()) {
                    rl.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                }
                if (radio_purple.isChecked()){
                    rl.setBackgroundColor(getResources().getColor(R.color.colorPurple));
                }
                if (radio_orange.isChecked()){
                    rl.setBackgroundColor(getResources().getColor(R.color.colorDarkOrange));
                }
            }
        });
    }
//    SharedPreferences sharedPrefs = getSharedPreferences("Settings", Context.MODE_PRIVATE);
//
//        radio_green.setChecked(sharedPrefs.getBoolean("Green", true));
//        radio_purple.setChecked(sharedPrefs.getBoolean("Purple", false));
//        radio_orange.setChecked(sharedPrefs.getBoolean("Orange", false));
}
