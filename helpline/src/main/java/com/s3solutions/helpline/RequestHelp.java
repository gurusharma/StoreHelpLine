package com.s3solutions.helpline;


import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RequestHelp extends AppCompatActivity implements View.OnClickListener {

    Button request;
    Button feedback;
    TextView timeToWait;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_help);
        request = (Button)findViewById(R.id.requestButton);
        feedback = (Button)findViewById(R.id.feedbackButton);
        timeToWait = (TextView)findViewById(R.id.waitText);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_open,R.string.app_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
//        switch (item.getItemId()) {
//            case R.id.logo:
//                goToUrl("http://scube.com");
//                break;
//            case R.id.help:
//                goToUrl("http://scube.com");
//                break;
//            case R.id.name:
//                recreate();
//                break;
//
//            case android.R.id.home:
//                Intent intent = new Intent(FeedbackPage.this, HomeActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                finish();
//                return true;
//        }
        return super.onOptionsItemSelected(item);
    }
}