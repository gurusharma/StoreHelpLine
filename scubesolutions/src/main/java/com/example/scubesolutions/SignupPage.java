package com.example.scubesolutions;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignupPage extends AppCompatActivity implements View.OnClickListener {

    EditText uName;
    EditText postcode;
    EditText email;
    EditText pwd;
    EditText pwd2;
   
    Button addToDB;

    String userName, postalCode, eMail, password, password2;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        uName = (EditText) findViewById(R.id.userNameSignUp);
        postcode = (EditText)findViewById(R.id.postalCodeEdit);
        email  = (EditText)findViewById(R.id.emailEdit);
        pwd = (EditText)findViewById(R.id.pwdSignUp1);
        pwd2 = (EditText)findViewById(R.id.pwdSignUp2);
        addToDB = (Button)findViewById(R.id.signUpButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        
        addToDB.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View view) {

        dataInitialize();
        //TODO: add all the nessesory validation
        //1)username - no special char
        //2)postalcode - secific format
        //3)email - specific format
        //4)password - not more than 8 char, and can have anything
        //5)password2 = password

    }

    public void dataInitialize(){
        userName = uName.getText().toString().trim();
        postalCode = postcode.getText().toString().trim();
        eMail = email.getText().toString().trim();
        password = pwd.getText().toString();
        password2 = pwd2.getText().toString();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logo:
                goToUrl("http://scube.com");
                break;
            case R.id.help:
                goToUrl("http://scube.com");
                break;
            case R.id.name:
                recreate();
                break;
            case android.R.id.home:
                Intent intent = new Intent(SignupPage.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    
}
