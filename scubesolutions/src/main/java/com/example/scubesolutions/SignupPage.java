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

//import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignupPage extends AppCompatActivity {

    private EditText uname;
    private EditText email;
    private EditText pwd;
    private EditText postalcode;

    //private Firebase rootref;
    private DatabaseReference mData;
    private FirebaseDatabase myDatabase = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //refreance to the firebase

        mData= myDatabase.getReference();
        //rootref = new Firebase("https://chalpadabb.firebaseio.com/");


        //Refreance to the text fields

        uname = (EditText) findViewById(R.id.UserName);
        email = (EditText) findViewById(R.id.Email);
        pwd =  (EditText) findViewById(R.id.Pass);
        postalcode = (EditText) findViewById(R.id.PostalCode);

        //Refrance to the button

        Button add = (Button) findViewById(R.id.add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username= uname.getText().toString().trim();
                String email123= email.getText().toString().trim();
                String password= pwd.getText().toString().trim();
                String zipcode = postalcode.getText().toString().trim();


                HashMap<String, String> datamap= new HashMap<String, String>();
                datamap.put("Email", email123);
                datamap.put("Password", password);
                datamap.put("PostalCode", zipcode);

                mData.push().setValue(datamap);

            }
        });


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.salutation, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter);
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
                goToUrl();
                break;
            case R.id.help:
                goToUrl();
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

    private void goToUrl() {
        Uri uriUrl = Uri.parse("http://scube.com");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
