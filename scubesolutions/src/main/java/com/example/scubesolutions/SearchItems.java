package com.example.scubesolutions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchItems extends AppCompatActivity implements View.OnClickListener {


    EditText searchDB;
    Button searchB;
    Button helpB;
    TextView trendingItem1;
    TextView trendingItem2;
    TextView trendingItem3;
    TextView trendingItem4;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    String storeName, trendingI1, trendingI2, trendingI3, trendingI4, searchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_items);

        searchDB = (EditText) findViewById(R.id.searchEdit);
        searchB = (Button) findViewById(R.id.searchButton);
        helpB = (Button) findViewById(R.id.helpButton);
        trendingItem1 = (TextView) findViewById(R.id.trendingItem1);
        trendingItem2 = (TextView) findViewById(R.id.trendingItem2);
        trendingItem3 = (TextView) findViewById(R.id.trendingItem3);
        trendingItem4 = (TextView) findViewById(R.id.trendingItem4);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_open,R.string.app_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void dataInitialise()
    {
        trendingI1 = trendingItem1.getText().toString();
        trendingI2 = trendingItem2.getText().toString();
        trendingI3 = trendingItem3.getText().toString();
        trendingI4 = trendingItem4.getText().toString();

        searchData = searchDB.getText().toString();

    }


    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        storeName=intent.getStringExtra("StoreName");//used further in database

        searchB.setOnClickListener(this);
        helpB.setOnClickListener(this);
        trendingItem1.setOnClickListener(this);
        trendingItem2.setOnClickListener(this);
        trendingItem3.setOnClickListener(this);
        trendingItem4.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, ItemDescription.class);
        intent.putExtra("StoreName",storeName);

        dataInitialise();

        switch (view.getId()){

            case R.id.searchButton:
                //Toast toast =Toast.makeText(this,searchData,Toast.LENGTH_SHORT);
                //toast.show();

                //TODO: add validation and then check the database for the item
                intent.putExtra("ItemName", searchData);
                startActivity(intent);
                break;

            case R.id.trendingItem1:
//                Toast toast1= Toast.makeText(this,trendingI1,Toast.LENGTH_SHORT);
//                toast1.show();
                intent.putExtra("ItemName", trendingI1);
                startActivity(intent);

                break;

            case R.id.trendingItem2:
//                Toast toast2= Toast.makeText(this,trendingI2,Toast.LENGTH_SHORT);
//                toast2.show();
                intent.putExtra("ItemName", trendingI2);
                startActivity(intent);

                break;

            case R.id.trendingItem3:
//                Toast toast3= Toast.makeText(this,trendingI3,Toast.LENGTH_SHORT);
//                toast3.show();
                intent.putExtra("ItemName", trendingI3);
                startActivity(intent);


                break;

            case R.id.trendingItem4:
//                Toast toast4= Toast.makeText(this,trendingI4,Toast.LENGTH_SHORT);
//                toast4.show();

                intent.putExtra("ItemName", trendingI4);
                startActivity(intent);

                break;

            case R.id.helpButton:
                //Toast.makeText(this,"Redirecting...",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, RequestHelp.class);
                startActivity(i);

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

