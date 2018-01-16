package com.s3solutions.helpline;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//Scubesolutions
public class SignIn extends AppCompatActivity implements View.OnClickListener {

    Button signInB;
    Button signUpB;

    EditText email;
    EditText pwd;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    String userName, password;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInB = findViewById(R.id.signinButton);
        signUpB = findViewById(R.id.signupButton);
        email = findViewById(R.id.userIdEdit);
        pwd = findViewById(R.id.pwdEdit);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_open,R.string.app_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(getApplicationContext(), StoreMapsActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {
            // User is signed out
            //Log.d(TAG, "onAuthStateChanged:signed_out");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        signInB.setOnClickListener(this);
        signUpB.setOnClickListener(this);



    }

    private void userLogin()
    {
        String eid = email.getText().toString().trim();
        String pass = pwd.getText().toString().trim();

        progressDialog.setMessage(getString(R.string.signinUser));
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(eid,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful())
                        {
                            String eid = email.getText().toString().trim();
//                            Intent i = new Intent(getApplicationContext(),StoreList.class);
                            Intent i = new Intent(getApplicationContext(),StoreMapsActivity.class);
                            i.putExtra(getString(R.string.userName),eid);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), R.string.wrongID,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean validate() {
        //TODO: VALIDATION HERE
        String eid = email.getText().toString().trim();
        String pid = pwd.getText().toString().trim();
        boolean valid = true;
        if(eid.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(eid).matches())
        {
            email.setError(getString(R.string.invalidEmailID));
            valid = false;
        }
        if(pid.isEmpty())
        {
            pwd.setError(getString(R.string.enterPsswd));
            valid = false;
        }
        if(pid.length()<8)
        {
            pwd.setError(getString(R.string.passwdLength));
            valid = false;
        }
        return valid;
    }

    @Override

    public void onClick(View view) {



        if(view == signInB) {
            initialize();

            if(!validate())
            {
                Toast.makeText(this, R.string.loninFail,Toast.LENGTH_SHORT).show();
            }
            else
                userLogin();

        }

        else if(view==signUpB)
        {

            String s = "login_act";
            Intent i = new Intent(getApplicationContext(), SignupPage.class); //'this' is Activity A
            i.putExtra("FROM_ACTIVITY", s);
            startActivity(i);
            finish();

        }

    }


    //        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            super.onCreateOptionsMenu(menu);
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.menu, menu);
//            return true;
//        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
//            switch (item.getItemId()) {
//                case R.id.logo:
//                    goToUrl("http://google.com");
//                    break;
//                case R.id.help:
//                    goToUrl("http://google.com");
//                    break;
//                case R.id.name:
//                    recreate();
//                    break;
//                case android.R.id.home:
//                    Intent intent = new Intent(SignIn.this, HomeActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                    finish();
//                    return true;
//            }
        return super.onOptionsItemSelected(item);
    }

    //    private void goToUrl (String url) {
//        Uri uriUrl = Uri.parse(url);
//        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
//        startActivity(launchBrowser);
//    }
    public void initialize()
    {
        userName = email.getText().toString().trim();
        password = pwd.getText().toString().trim();
    }


}