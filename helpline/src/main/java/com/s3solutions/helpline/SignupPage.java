package com.s3solutions.helpline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//Scubesolutions
public class SignupPage extends AppCompatActivity{ //implements View.OnClickListener {

    EditText uName;
    EditText postcode;
    EditText ed1;
    EditText pwd;
    EditText pwd2;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    Button signUpButton;

    //String userName, postalCode, eMail, password, password2;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String s = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s = extras.getString("FROM_ACTIVITY");
        }
        if (!s.equals("login_act")) {
            if (firebaseAuth.getCurrentUser() != null) {
                startActivity(new Intent(this, StoreList.class));
                finish();
            }
        }


        //uName = (EditText) findViewById(R.id.userNameSignUp);
        // postcode = (EditText)findViewById(R.id.postalCodeEdit);
        ed1 = (EditText) findViewById(R.id.emailEdit);
        pwd = (EditText) findViewById(R.id.pwdSignUp1);
        pwd2 = (EditText) findViewById(R.id.pwdSignUp2);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_open, R.string.app_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v == signUpButton) {
                    if (!validate()) {
                        Toast.makeText(getApplicationContext(), R.string.signupFail, Toast.LENGTH_SHORT).show();
                    } else {
                        registerUser();
                        startActivity(new Intent(getApplicationContext(), SignIn.class));
                        registerUser();
                    }
                }
            }
        });
    }
    private  void registerUser(){
        String email = ed1.getText().toString().trim();
        String password = pwd.getText().toString().trim();

//        if (TextUtils.isEmpty(email)){
//            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (TextUtils.isEmpty(password)){
//            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
//            return;
//        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignupPage.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                            //finish();
                            //Intent i = new Intent(getApplicationContext(), LogInActivity.class);
                            //startActivity(i);
                        }
                        else {
                            Toast.makeText(SignupPage.this, "Registration Error", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                        }
                    }
                });
    }


//    private void registerUser()
//    {
//        String eid = email.getText().toString().trim();
//        String pass = pwd.getText().toString().trim();
//
//
//
//        firebaseAuth.createUserWithEmailAndPassword(eid,pass)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful())
//                        {
//                            finish();
//                            Toast.makeText(getApplicationContext(), R.string.regSucc,Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(),SignIn.class));
//                        }else
//                        {
//                            Toast.makeText(getApplicationContext(), R.string.resFail,Toast.LENGTH_SHORT).show();
//
//                        }
//
//                    }
//                });
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        addToDB.setOnClickListener(this);
//
//    }

//    @Override
//    public void onClick(View view) {
//
//
//        dataInitialize();
//        if(!validate())
//        {
//            Toast.makeText(this, R.string.signupFail,Toast.LENGTH_SHORT).show();
//        }
//        else
//            registerUser();
//            //startActivity(new Intent(getApplicationContext(),StoreList.class));
//
//    }

    private boolean validate() {

        String eid = ed1.getText().toString().trim();
        String pass = pwd.getText().toString().trim();
        String pass2 = pwd2.getText().toString().trim();
        boolean valid = true;
        if(eid.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(eid).matches())
        {
            ed1.setError("Please enter valid e-mail");
            valid = false;
        }
        else if(pass.isEmpty())
        {
            pwd.setError("Please enter your Password");
            valid = false;
        }
        else if(pass.length()<8)
        {
            pwd.setError("Password must be 8 characters long");
            valid = false;
        }
        else if(!pass.equals(pass2))
        {
            pwd2.setError("Password didn't match");
            valid = false;
        }
        return valid;
    }

//    public void dataInitialize(){
//       // userName = uName.getText().toString().trim();
//       // postalCode = postcode.getText().toString().trim();
//        eMail = email.getText().toString().trim();
//        password = pwd.getText().toString();
//        password2 = pwd2.getText().toString();
//
//
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
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
//            case android.R.id.home:
//                Intent intent = new Intent(SignupPage.this, HomeActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                finish();
//                return true;
//        }
        return super.onOptionsItemSelected(item);
    }

//    private void goToUrl (String url) {
//        Uri uriUrl = Uri.parse(url);
//        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
//        startActivity(launchBrowser);
//    }


}