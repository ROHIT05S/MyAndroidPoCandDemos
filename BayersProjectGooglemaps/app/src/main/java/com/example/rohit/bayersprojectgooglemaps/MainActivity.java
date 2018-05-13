package com.example.rohit.bayersprojectgooglemaps;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.rohit.bayersprojectgooglemaps.database.DatabaseHelper;
import com.example.rohit.bayersprojectgooglemaps.models.LocationDetails;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener
{
    private GoogleApiClient mGoogleApiClient;
    LatLng latLng,latLngmyOwn;
    double latitude,longitude;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
        final DatabaseHelper db = new DatabaseHelper(getApplicationContext());
      /*  Button submit = (Button) findViewById(R.id.button2submitform);*/
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        AutocompleteFilter autocompleteFilter = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_REGIONS).build();
        final PlaceAutocompleteFragment placeAutocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        placeAutocompleteFragment.setFilter(autocompleteFilter);
        placeAutocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                    @Override
                    public void onPlaceSelected(Place place) {

                        String name = place.getName().toString();
                        String placeSearched = place.getAddress().toString();
                        Log.e("latlng", place.getLatLng().toString());
                        latLng = place.getLatLng();
                        latitude = latLng.latitude;
                        longitude = latLng.longitude;
                        LocationDetails locationDetails = new LocationDetails();
                        locationDetails.setLatitude(latitude+"");
                        locationDetails.setLongitude(longitude+"");

                        locationDetails.setPlace(placeSearched);
                        boolean i = db.addLocation(locationDetails);
                        if(i)
                        {
                            Toast.makeText(getApplicationContext(),"value added succesfully",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"unsucesful",Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        intent.putExtra("latlng",latitude+"__"+longitude);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Status status) {
                        Log.e("An error occurred: ", status.toString());
                    }
                });
               /* submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        intent.putExtra("latlng", latLng);
                        startActivity(intent);


                    }
                });*/
        ArrayList<String> arrayList = new DatabaseHelper(getApplicationContext()).getAllPlaces();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedPlace = autoCompleteTextView.getText().toString();
                LocationDetails locationDetails =   db.getLocationDetails(selectedPlace);
                double latitude1 = Double.parseDouble(locationDetails.getLatitude());
                double longitude1 = Double.parseDouble(locationDetails.getLongitude());
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("latlng",latitude1+"__"+longitude1);
                startActivity(intent);

            }
        });



    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
