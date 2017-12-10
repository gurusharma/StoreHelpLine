package com.example.scubesolutions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class StoreList extends AppCompatActivity implements View.OnClickListener {


    TextView store1 = (TextView)findViewById(R.id.storeLogo1);
    TextView store2 = (TextView)findViewById(R.id.storeLogo2);
    TextView store3 = (TextView)findViewById(R.id.storeLogo3);
    TextView store4 = (TextView)findViewById(R.id.storeLogo4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        store1.setOnClickListener(this);
        store2.setOnClickListener(this);
        store3.setOnClickListener(this);
        store4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.storeLogo1:

                Intent intent = new Intent(this, SearchItems.class);
                intent.putExtra("StoreName", "store1");
                startActivity(intent);
                break;

            case R.id.storeLogo2:

                Intent intent1 = new Intent(this, SearchItems.class);
                intent1.putExtra("StoreName", "store2");
                startActivity(intent1);
                break;

            case R.id.storeLogo3:

                Intent intent2 = new Intent(this, SearchItems.class);
                intent2.putExtra("StoreName", "store3");
                startActivity(intent2);

                break;

            case R.id.storeLogo4:

                Intent intent3 = new Intent(this, SearchItems.class);
                intent3.putExtra("StoreName", "store4");
                startActivity(intent3);

                break;

        }


    }
}
