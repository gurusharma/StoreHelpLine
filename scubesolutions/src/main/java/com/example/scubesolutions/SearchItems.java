package com.example.scubesolutions;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SearchItems extends AppCompatActivity implements View.OnClickListener {


    EditText searchDB = (EditText) findViewById(R.id.searchEdit);
    Button searchB = (Button) findViewById(R.id.searchButton);
    Button helpB = (Button) findViewById(R.id.helpButton);
    TextView trendingItem1 = (TextView) findViewById(R.id.trendingItem1);
    TextView trendingItem2 = (TextView) findViewById(R.id.trendingItem2);
    TextView trendingItem3 = (TextView) findViewById(R.id.trendingItem3);
    TextView trendingItem4 = (TextView) findViewById(R.id.trendingItem4);

    String trendingI1 = trendingItem1.getText().toString();
    String trendingI2 = trendingItem2.getText().toString();
    String trendingI3 = trendingItem3.getText().toString();
    String trendingI4 = trendingItem4.getText().toString();

    String searchData = searchDB.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_items);
    }


    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        String storeName=intent.getStringExtra("StoreName");//used further in database

        searchB.setOnClickListener(this);
        helpB.setOnClickListener(this);
        trendingItem1.setOnClickListener(this);
        trendingItem2.setOnClickListener(this);
        trendingItem3.setOnClickListener(this);
        trendingItem4.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.searchButton:
                Toast toast =Toast.makeText(this,searchData,Toast.LENGTH_SHORT);
                toast.show();
                break;

            case R.id.trendingItem1:
                Toast toast1= Toast.makeText(this,trendingI1,Toast.LENGTH_SHORT);
                toast1.show();
                break;

            case R.id.trendingItem2:
                Toast toast2= Toast.makeText(this,trendingI2,Toast.LENGTH_SHORT);
                toast2.show();
                break;

            case R.id.trendingItem3:
                Toast toast3= Toast.makeText(this,trendingI3,Toast.LENGTH_SHORT);
                toast3.show();
                break;

            case R.id.trendingItem4:
                Toast toast4= Toast.makeText(this,trendingI4,Toast.LENGTH_SHORT);
                toast4.show();
                break;

            case R.id.helpButton:
                Toast.makeText(this,"Redirecting...",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, RequestHelp.class);
                startActivity(i);

        }

    }
}

