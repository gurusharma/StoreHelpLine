package com.example.scubesolutions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemDescription extends AppCompatActivity implements View.OnClickListener{

    TextView storeNametext, itemNametext, itemPrice, aisleNumber, shelfNumber;
    Button backToSearch;
    String storeName, itemName;

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
}
