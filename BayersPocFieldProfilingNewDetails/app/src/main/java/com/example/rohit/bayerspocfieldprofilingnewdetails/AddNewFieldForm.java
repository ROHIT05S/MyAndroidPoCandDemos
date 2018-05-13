package com.example.rohit.bayerspocfieldprofilingnewdetails;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rohit.bayerspocfieldprofilingnewdetails.Database.DatabaseHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;

public class AddNewFieldForm extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    Button addnewVillage;
    private GoogleApiClient mGoogleApiClient;
    LatLng latLng,latLngmyOwn;
    DatabaseHelper databaseHelper;
    Latlong latlong = new Latlong();
    private LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_field_form);
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
        databaseHelper = new DatabaseHelper(this);

        addnewVillage = (Button) findViewById(R.id.buttonaddNewVillage);
        addnewVillage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.addnewfieldpin);
                Button submit = (Button) findViewById(R.id.button2submitform);
                Button myLocation = (Button) findViewById(R.id.button2mylocation);

                AutocompleteFilter autocompleteFilter = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_REGIONS).build();
                final PlaceAutocompleteFragment placeAutocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

                placeAutocompleteFragment.setFilter(autocompleteFilter);


                placeAutocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                    @Override
                    public void onPlaceSelected(Place place) {

                        String name = place.getName().toString();
                        LatLng latitude = place.getLatLng();


                        // Toast.makeText(getApplicationContext(),place.getName().toString()+place.getAddress().toString()+place.getLatLng().toString(),Toast.LENGTH_LONG).show();
                        Log.e("latlng", place.getLatLng().toString());
                        latLng = place.getLatLng();
                        latlong.setPincode(name);
                        latlong.setLatlng(latLng.toString());
                        databaseHelper.savePindetails(latlong);
                        List<Latlong> list = new ArrayList<>();
                        list = databaseHelper.getList();
                        Log.i("Ashish", "onPlaceSelected: " + list.size());

                    }

                    @Override
                    public void onError(Status status) {
                        Log.e("An error occurred: ", status.toString());
                    }
                });
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AddNewFieldForm.this, MapsActivity.class);
                        intent.putExtra("latlng", latLng);
                        startActivity(intent);

                    }
                });
              /*  myLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        LocationListener locationListener = new LocListener();

                        if (ActivityCompat.checkSelfPermission(AddNewFieldForm.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(AddNewFieldForm.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 0, locationListener);
                        Toast.makeText(getApplicationContext(),"location demanded....",Toast.LENGTH_LONG).show();
                        Intent intent1  = new Intent(AddNewFieldForm.this,MapsActivity.class);
                        intent1.putExtra("latlng",latLngmyOwn);
                        startActivity(intent1);
                    }
                });*/

            }
        });
    }
   /* class LocListener implements LocationListener
    {

        @Override
        public void onLocationChanged(Location location)
        {
            if(location!= null)
            {
                Toast.makeText(getApplicationContext(),""+location.getLatitude()+" and  "+location.getLongitude(),Toast.LENGTH_LONG).show();
                latLngmyOwn = new LatLng( location.getLatitude(),location.getLongitude());
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Please wait your location is getting ....",Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }
*/


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}
