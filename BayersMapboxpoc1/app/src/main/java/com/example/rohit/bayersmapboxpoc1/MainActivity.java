package com.example.rohit.bayersmapboxpoc1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rohit.bayersmapboxpoc1.database.DatabaseHelper;
import com.example.rohit.bayersmapboxpoc1.models.LocationDetails;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.services.android.ui.geocoder.GeocoderAutoCompleteView;
import com.mapbox.services.api.geocoding.v5.GeocodingCriteria;
import com.mapbox.services.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.services.commons.models.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener
{
    private MapView mapView;
    private MapboxMap map;
    double latitude;
    double longitude;
    Button submit;
    AutoCompleteTextView autoCompleteTextView;
    HashMap<String, double[]> latlongMap;
    com.google.android.gms.maps.model.LatLng latLng;



    Spinner spinner;

    String address = "";
    double pos[];


    private GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.accesstoken));
        setContentView(R.layout.activity_main);
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        final DatabaseHelper db = new DatabaseHelper(getApplicationContext());
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
                Log.d("latlong",""+latitude+""+longitude);
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


        //spinner = (Spinner)findViewById(R.id.spinner_searchedplaces);
       /* GeocoderAutoCompleteView autocomplete = (GeocoderAutoCompleteView) findViewById(R.id.query);
        autocomplete.setAccessToken(Mapbox.getInstance(this,getString(R.string.accesstoken)).getAccessToken());*/


        ArrayList<String> arrayList = new DatabaseHelper(getApplicationContext()).getAllPlaces();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        autoCompleteTextView.setAdapter(adapter);

       /* autocomplete.setType(GeocodingCriteria.TYPE_POI);
        autocomplete.setOnFeatureListener(new GeocoderAutoCompleteView.OnFeatureListener() {
            @Override
            public void onFeatureClick(CarmenFeature feature)
            {
                Position position = feature.asPosition();
                //placeaName = new ArrayList<String>();

                latitude=Double.parseDouble(String.valueOf(position.getLatitude()));
                longitude=Double.parseDouble(String.valueOf(position.getLongitude()));
                address = feature.getPlaceName();

                LocationDetails locationDetails = new LocationDetails();
                locationDetails.setLatitude(latitude+"");
                locationDetails.setLongitude(longitude+"");

                locationDetails.setPlace(address);
                boolean i = db.addLocation(locationDetails);
                if(i)
                {
                    Toast.makeText(getApplicationContext(),"value added succesfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"unsucesful",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("latlng",latitude+"__"+longitude);
                startActivity(intent);

            }


        });*/


               autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener()
               {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                   {
                    String selectedPlace = autoCompleteTextView.getText().toString();
                    LocationDetails locationDetails =   db.getLocationDetails(selectedPlace);

                       startActivity(new Intent(getApplicationContext(), MapsActivity.class).putExtra("latlng",locationDetails.getLatitude()+"__"+locationDetails.getLongitude()));

                   }
               });






    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
