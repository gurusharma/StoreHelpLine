package com.example.scubesolutions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RequestHelp extends AppCompatActivity implements View.OnClickListener {

    Button request = (Button)findViewById(R.id.requestButton);
    Button feedback = (Button)findViewById(R.id.feedbackButton);



    TextView timeToWait = (TextView)findViewById(R.id.waitText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_help);
    }

    @Override
    protected void onStart() {
        super.onStart();

        feedback.setClickable(false);
        request.setOnClickListener(this);
        feedback.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.requestButton:
                timeToWait.setText("Help will be on the help desk in about 1 minutes");
                feedback.setClickable(true);

                break;

            case R.id.feedbackButton:
                Toast.makeText(this,"Redirecting...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, FeedbackPage.class);
                startActivity(intent);
                break;

        }

    }
}
