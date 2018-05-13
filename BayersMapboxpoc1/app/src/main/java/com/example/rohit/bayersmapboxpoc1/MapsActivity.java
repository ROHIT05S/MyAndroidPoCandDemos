package com.example.rohit.bayersmapboxpoc1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.maps.android.SphericalUtil;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.PolygonOptions;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.MapboxMapOptions;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity
{
    double latiTude;
    double longiTude;
    private MapView mapView;
    private MapboxMap map;
    TextView areaText;
    List<LatLng> latlngpoints = new ArrayList<LatLng>();
    LatLng latlongremovePosition;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.accesstoken));
        setContentView(R.layout.activity_maps);
        areaText = (TextView)findViewById(R.id.textView_area);
        next = (Button)findViewById(R.id.button_next);
        Intent intent = getIntent();
        final String[] data =  getIntent().getStringExtra("latlng").split("__");
         /*double posiTion[]=

        for (int i=0;i<posiTion.length;i++)
        {
            Log.d("pos",""+posiTion[i]);
            latiTude = posiTion[0];
            longiTude = posiTion[1];
        }*/
        mapView = (MapView) findViewById(R.id.mapView);


        mapView.onCreate(savedInstanceState);
        final MapboxMapOptions options = new MapboxMapOptions();
        options.styleUrl(Style.SATELLITE_STREETS);
      /*  Log.d("lat",""+latiTude);
        Log.d("long",""+longiTude);*/
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final MapboxMap mapboxMap) {

    CameraPosition position = new CameraPosition.Builder()
                        .target(new LatLng(Double.parseDouble(data[0]), Double.parseDouble(data[1]))) // Sets the new camera position
                        .zoom(10) // Sets the zoom
                        .build(); // Creates a CameraPosition from the builder

                mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), 500, null);
                mapboxMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(data[0]), Double.parseDouble(data[1]))));
                options.logoEnabled(false);
                mapboxMap.setOnMapClickListener(new MapboxMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng point) {
                        mapboxMap.addMarker(new MarkerOptions().position(new LatLng(point)));
                        latlngpoints.add(point);

                        for (int i = 0; i < latlngpoints.size(); i++) {
                            Log.e("points", latlngpoints.get(i).toString());
                        }
                        computeArea();

                        mapboxMap.addPolygon(new PolygonOptions().addAll(latlngpoints).fillColor(Color.GREEN).strokeColor(Color.BLACK));
                        PolylineOptions polylineOptions = new PolylineOptions().addAll(latlngpoints);
                        mapboxMap.addPolyline(polylineOptions);
                        mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull final Marker marker) {
                                latlongremovePosition = marker.getPosition();
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                                alertDialog.setTitle("Confirm Delete..");
                                alertDialog.setMessage("What You Want to do With This Marker ");
                                alertDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        marker.remove();
                                        latlngpoints.remove(latlongremovePosition);
                                        Log.d("new list", "" + latlngpoints);
                                        mapboxMap.clear();
                                        for (int i = 0; i < latlngpoints.size(); i++) {
                                            mapboxMap.addMarker(new MarkerOptions().position(latlngpoints.get(i)));
                                        }

                                        mapboxMap.addPolygon(new PolygonOptions().addAll(latlngpoints).fillColor(Color.GREEN).strokeColor(Color.BLACK));
                                        computeArea();


                                    }
                                });


                                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {


                                        dialog.cancel();
                                    }
                                });


                                alertDialog.show();


                                Log.d("postion removed", "" + latlongremovePosition);


                                return true;
                            }


                        });
                    }


                    private void computeArea() {
                        List<com.google.android.gms.maps.model.LatLng> latLngs = new ArrayList<>();
                        for (LatLng latLng : latlngpoints) {
                            com.google.android.gms.maps.model.LatLng latLng1 = new com.google.android.gms.maps.model.LatLng(latLng.getLatitude(), latLng.getLongitude());
                            latLngs.add(latLng1);
                        }
                        double area = SphericalUtil.computeArea(latLngs);
                       // Toast.makeText(getApplicationContext(), "" + area, Toast.LENGTH_LONG).show();
                        areaText.setText("" + area);
                    }


                });
                next.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                     mapboxMap.snapshot(new MapboxMap.SnapshotReadyCallback()
                     {
                         @Override
                         public void onSnapshotReady(Bitmap snapshot)
                         {

                         }
                     });
                    }
                });

            }
        });
    }
}

