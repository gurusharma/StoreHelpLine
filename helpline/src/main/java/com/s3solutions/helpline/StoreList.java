package com.s3solutions.helpline;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//Scubesolutions
public class StoreList extends AppCompatActivity implements View.OnClickListener {


    TextView store1, store2, store3, store4;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private static final int MY_PERMISSIONS_REQUEST_COARSE_LOCATION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        store1 = (TextView) findViewById(R.id.storeLogo1);
        store2 = (TextView) findViewById(R.id.storeLogo2);
        store3 = (TextView) findViewById(R.id.storeLogo3);
        store4 = (TextView) findViewById(R.id.storeLogo4);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_open, R.string.app_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

// Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                //makeUseOfNewLocation(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

// Register the listener with the Location Manager to receive location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        else {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_COARSE_LOCATION);

        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2, 100, locationListener);
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