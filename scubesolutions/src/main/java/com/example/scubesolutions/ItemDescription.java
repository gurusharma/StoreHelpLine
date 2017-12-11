package com.example.scubesolutions;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemDescription extends AppCompatActivity implements View.OnClickListener{

    TextView storeNametext, itemNametext, itemPrice, aisleNumber, shelfNumber;
    Button backToSearch;
    String storeName, itemName;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        storeNametext = findViewById(R.id.storeNameHeader);
        itemNametext = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.price);
        aisleNumber = findViewById(R.id.aisleNumber);
        shelfNumber = findViewById(R.id.shelfNumber);

        backToSearch = findViewById(R.id.backToSearch);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_open,R.string.app_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        backToSearch.setOnClickListener(this);
        Intent intent = getIntent();
        storeName=intent.getStringExtra("StoreName");
        itemName = intent.getStringExtra("ItemName");

        storeNametext.setText(storeName);
        itemNametext.setText(itemName);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this,SearchItems.class);
        startActivity(i);

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
