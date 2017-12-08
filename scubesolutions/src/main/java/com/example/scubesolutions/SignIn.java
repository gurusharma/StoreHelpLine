package com.example.scubesolutions;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    Button signInB = (Button)findViewById(R.id.signinButton);
    Button signUpB = (Button)findViewById(R.id.signupButton);

    EditText uName = (EditText)findViewById(R.id.userIdEdit);
    EditText pwd = (EditText)findViewById(R.id.pwdEdit);

    String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


    }

    @Override
    protected void onStart() {
        super.onStart();

        signInB.setOnClickListener(this);
        signUpB.setOnClickListener(this);

        userName = uName.getText().toString().trim();
        password = pwd.getText().toString().trim();

    }
    @Override

    public void onClick(View view) {

        switch (view.getId()){

            //TODO: also add the sign in information in the shared preferance, and fingerprint thing.
            case R.id.signinButton:
                if(userName.equals("")|| password.equals(""))
                    Toast.makeText(this,"Please fill Credentials",Toast.LENGTH_SHORT).show();

                //TODO:add validation and then pass the value to the database to check

                else{
                    Toast.makeText(this,"Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignIn.this, StoreList.class);
                    startActivity(i);
                }
                break;
            case R.id.signupButton:
                Intent i1 = new Intent(this, SignupPage.class);
                startActivity(i1);


        }

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
                    goToUrl("http://google.com");
                    break;
                case R.id.help:
                    goToUrl("http://google.com");
                    break;
                case R.id.name:
                    recreate();
                    break;
                case android.R.id.home:
                    Intent intent = new Intent(SignIn.this, HomeActivity.class);
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