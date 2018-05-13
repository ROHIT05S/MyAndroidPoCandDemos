package com.example.rohit.bayerspocfieldprofilingnewdetails;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.maps.android.SphericalUtil;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

   // private GoogleMap mMap;
    Button walkOnMap, drawOnMap, start, stop, showField,maptype,zoomIcon;
    TextView textView;
    private GoogleMap mMap;
    private LocationManager locationManager;
    LocationListener locationListener;
    LatLng latLngA;
    List<LatLng> geoPoints = new ArrayList<LatLng>();




    static Bitmap finalBitmap;
    double calculcatedArea;
    double areaCalculated;
    LatLng latlongremovePosition;
    ImageButton imageButton;
    private static final CharSequence[] MAP_TYPE_ITEMS = {"Road Map", "Satellite", "Terrain","Hybrid"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        walkOnMap = (Button) findViewById(R.id.button_walkaroundfield);
        drawOnMap = (Button) findViewById(R.id.buttondrawOnmap);
        start = (Button) findViewById(R.id.button4_start);
        stop = (Button) findViewById(R.id.button_stop);
        showField = (Button) findViewById(R.id.buttonShowMap);
        textView = (TextView)findViewById(R.id.textView2wether);
        //imageButton = (ImageButton)findViewById(R.id.imageButtonMap);
        maptype = (Button)findViewById(R.id.button4maptype);
        zoomIcon = (Button)findViewById(R.id.button2zoommm);
        zoomIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "location demanded....", Toast.LENGTH_LONG).show();
                keepGettingCoordinates();
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });


        maptype.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMapTypeSelectorDialog();
            }
        });

        Bundle bundle = getIntent().getExtras();
        latLngA = (LatLng) bundle.get("latlng");
        showField.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                captureImage();


            }
        });

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                keepGettingCoordinates();
                Toast.makeText(getApplicationContext(), "location demanded....", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showField.setVisibility(View.VISIBLE);
                stopGettingCoordinates();

            }
        });

        walkOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAllButton();
                hideAllButton();
                //walkOnMap();
            }


        });
        drawOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showAllButton();
                hideAllButton();
                drawOnMaps();
                showField.setVisibility(View.VISIBLE);
                stop.setVisibility(View.GONE);
                start.setVisibility(View.GONE);
               // mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
    }

    private void showMapTypeSelectorDialog()
    {
        final String fDialogTitle = "Select Map Type";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(fDialogTitle);
        int checkItem = mMap.getMapType()-1 ;
        builder.setSingleChoiceItems(
                MAP_TYPE_ITEMS,
                checkItem,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {
                        // Locally create a finalised object.

                        // Perform an action depending on which item was selected.
                        switch (item) {
                            case 1:
                                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                                break;
                            case 2:
                                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                                break;
                            case 3:
                                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                                break;
                            default:
                                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        }
                        dialog.dismiss();
                    }
                }
        );

        // Build the dialog and show it.
        AlertDialog fMapTypeDialog = builder.create();
        fMapTypeDialog.setCanceledOnTouchOutside(true);
        fMapTypeDialog.show();
    }

    private void removeMarkerPosition()
    {
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(final Marker marker)
            {
               latlongremovePosition = marker.getPosition();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                alertDialog.setTitle("Confirm Delete..");
                alertDialog.setMessage("What You Want to do With This Marker ");
                alertDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        marker.remove();
                        geoPoints.remove(latlongremovePosition);
                        Log.d("new list",""+geoPoints);
                        mMap.clear();
                        for (int i = 0; i < geoPoints.size(); i++)
                        {
                           mMap.addMarker(new MarkerOptions().position(geoPoints.get(i)));
                        }

                        mMap.addPolygon(new PolygonOptions().addAll(geoPoints).fillColor(Color.GREEN));
                        computeAreaofField();





                    }
                });


                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.cancel();
                    }
                });


                alertDialog.show();



                Log.d("postion removed",""+latlongremovePosition);


                return true;
            }
        });


    }

    private void hideAllButton() {

        walkOnMap.setVisibility(View.GONE);
        drawOnMap.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);

    }

    private void showAllButton() {

        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.VISIBLE);
    }


    private void computeAreaofField()
    {
        areaCalculated = SphericalUtil.computeArea(geoPoints);
        Log.d("area is",""+areaCalculated);



    }
    private void passData()
    {
        calculcatedArea = areaCalculated*0.000247105;
        Intent intent = new Intent(MapsActivity.this,FieldActivity.class);
        intent.putExtra("area",""+calculcatedArea);
        startActivity(intent);
    }



    private void captureImage()
    {
        mMap.snapshot(new GoogleMap.SnapshotReadyCallback()
        {
            @Override
            public void onSnapshotReady(Bitmap bitmap1)
            {
                File folder = new File(Environment.getExternalStorageDirectory().toString()+"/bayer/temp");
                folder.mkdirs();

                //Save the path as a string value
                String extStorageDirectory = folder.toString();

                //Create New file and name it Image2.PNG
                File file = new File(extStorageDirectory, "temp3.png");
                FileOutputStream fileOutputStream = null ;
                try
                {
                    fileOutputStream = new FileOutputStream(file);
                }
                catch (FileNotFoundException e)
                {

                    e.printStackTrace();
                }
               boolean i=  bitmap1.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                if(i)
                {
                    computeAreaofField();
                    passData();
                }

                try {
                    fileOutputStream.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
    }


    private  void keepGettingCoordinates()
    {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocListener();
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
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

    }

    private void stopGettingCoordinates()
    {

        locationManager.removeUpdates(locationListener);
        locationListener = null;
    }




    public void drawOnMaps() {
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                LatLng points = new LatLng(latLng.latitude, latLng.longitude);
                mMap.setMaxZoomPreference(25);


               // mMap.addMarker(new MarkerOptions().position(points)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(new MarkerOptions().position(points)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

                geoPoints.add(points);
                removeMarkerPosition();

                PolygonOptions polygonOptions = new PolygonOptions().fillColor(Color.GREEN);
                for (int i = 0; i < geoPoints.size(); i++)
                {
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(points));
                    polygonOptions.add(geoPoints.get(i));
                    Log.d("latlongs",geoPoints.get(i).toString());
                }

                mMap.addPolygon(polygonOptions);
                computeAreaofField();



            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.addMarker(new MarkerOptions().position(latLngA));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngA,15));


    }
    class LocListener implements LocationListener
    {

        @Override
        public void onLocationChanged(Location location)
        {
            if (location != null) {
                Toast.makeText(getApplicationContext(), "longitude=" + location.getLongitude() + "latitude=" + location.getLatitude(), Toast.LENGTH_LONG).show();
                LatLng points = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(points)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                geoPoints.add(points);
                PolygonOptions polygonOptions = new PolygonOptions().fillColor(Color.BLUE);
                for (int i = 0; i < geoPoints.size(); i++) {

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(points));
                    Log.e("LATLONG", geoPoints.get(i).toString());

                    polygonOptions.add(geoPoints.get(i));
                }
                mMap.addPolygon(polygonOptions);
                computeAreaofField();

            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }







}
