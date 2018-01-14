package com.s3solutions.helpline;

import android.content.Context;
<<<<<<< HEAD
import android.content.Intent;
>>>>>>> AbhayGeoLocation3
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
<<<<<<< HEAD
=======
import android.widget.Toast;
>>>>>>> AbhayGeoLocation3

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
<<<<<<< HEAD
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class StoreMapsActivity extends FragmentActivity implements OnMapReadyCallback {
=======
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class StoreMapsActivity extends FragmentActivity implements OnMapReadyCallback{
>>>>>>> AbhayGeoLocation3

    private GoogleMap mMap;
    private double currentLat;
    private double currentLong;
<<<<<<< HEAD
=======
    private Marker Store1;
>>>>>>> AbhayGeoLocation3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

// Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                //makeUseOfNewLocation(location);

                currentLat= location.getLatitude();
                currentLong =location.getLongitude();
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

// Register the listener with the Location Manager to receive location updates
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, 0);

        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2, 100, locationListener);


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng currentLoc = new LatLng(currentLat, currentLong);
        mMap.addCircle(new CircleOptions().center(currentLoc));

        LatLng store1 = new LatLng(43.652067, -79.74249800000001);
<<<<<<< HEAD
        mMap.addMarker(new MarkerOptions().position(store1).title("Store1"));
        LatLng store2 = new LatLng(43.728971, -79.605458);
        mMap.addMarker(new MarkerOptions().position(store2).title("Store2"));
        LatLng store3 = new LatLng(43.6425662, -79.38705679999998);
        mMap.addMarker(new MarkerOptions().position(store3).title("Store3"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLoc));
    }
=======
        Store1 = mMap.addMarker(new MarkerOptions().position(store1).title("Store1").snippet("Store 1"));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
            @Override
            public boolean onMarkerClick(Marker marker) {
                //int position = (int)(marker.getTag());
                //Using position get Value from arraylist
                if (marker.getTitle().equals("Store1")){
                    Toast.makeText(getApplicationContext(),"Store1",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SearchItems.class);
                    intent.putExtra("StoreName", "store1");
                    startActivity(intent);
                }

                return false;
            }
        });

        LatLng store2 = new LatLng(43.728971, -79.605458);
        mMap.addMarker(new MarkerOptions().position(store2).title("Store2"));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
            @Override
            public boolean onMarkerClick(Marker marker) {
                //int position = (int)(marker.getTag());
                //Using position get Value from arraylist
                if (marker.getTitle().equals("Store2")){
                    Toast.makeText(getApplicationContext(),"Store2",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SearchItems.class);
                    intent.putExtra("StoreName", "store2");
                    startActivity(intent);
                }

                return false;
            }
        });

        LatLng store3 = new LatLng(43.6425662, -79.38705679999998);
        mMap.addMarker(new MarkerOptions().position(store3).title("Store3"));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
            @Override
            public boolean onMarkerClick(Marker marker) {
                //int position = (int)(marker.getTag());
                //Using position get Value from arraylist
                if (marker.getTitle().equals("Store3")){
                    Toast.makeText(getApplicationContext(),"Store3",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SearchItems.class);
                    intent.putExtra("StoreName", "store3");
                    startActivity(intent);
                }

                return false;
            }
        });


        mMap.moveCamera(CameraUpdateFactory.newLatLng(store1));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLoc));
    }


>>>>>>> AbhayGeoLocation3
}
