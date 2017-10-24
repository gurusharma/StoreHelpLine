package com.example.scubesolutions;

import android.content.Intent;
import android.graphics.Color;
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

public class FourthPage extends AppCompatActivity {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);

        b1 = (Button)findViewById(R.id.button_next);
        ed1 = (EditText)findViewById(R.id.editText_userName);
        ed2 = (EditText)findViewById(R.id.editText_password);

//        b2 = (Button)findViewById(R.id.button2);
//        tx1 = (TextView)findViewById(R.id.textView3);
//        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("") ||  ed2.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please fill Credentials",Toast.LENGTH_SHORT).show();
                }
                else if(ed1.getText().toString().equals("admin") &&  ed2.getText().toString().equals("admin"))
                {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(FourthPage.this, SecondPage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
//                            tx1.setVisibility(View.VISIBLE);
//                    tx1.setBackgroundColor(Color.RED);
//                    counter--;
//                    tx1.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        b1.setEnabled(false);
//                    }
                }
            }
        });

    }
    public void GoNext(View view) {
        Intent i = new Intent(this, SignupPage.class);
        startActivity(i);
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
                    Intent intent = new Intent(FourthPage.this, HomeActivity.class);
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