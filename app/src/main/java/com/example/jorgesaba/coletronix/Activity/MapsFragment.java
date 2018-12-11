package com.example.jorgesaba.coletronix.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import Config.ConfiguracaoFirebase;
import Model.Deposito;
import Model.Entrega;

public class MapsFragment extends  SupportMapFragment implements OnMapReadyCallback , GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    DatabaseReference firebaseref = ConfiguracaoFirebase.getFirebaseDatabase();
    DatabaseReference depositos = firebaseref.child("depositos");
    Deposito deposito = null;
    List<Deposito> depositosCadastrados;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // For showing a move to my location button
        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION },
                    1);
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        LatLng ceara = new LatLng(-4.968293, -39.015717);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(ceara).zoom(16).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

//

        Deposito d1 = new Deposito("Rodrigues Júnior", "88 999034671", "Até as 22:00", "Lixão do gordin");
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng (-4.969729, -39.014646))
                .title("Lixão do gordin")
        );


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng (-4.962229, -39.016646))
                .title("Lixão do jorge")
        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng (-4.979466, -39.056297))
                .title("Bar do cabeludin")
        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng (-4.969866, -39.016126))
                .title("Lixão da UFC")
        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng (-4.978493, -39.058299))
                .title("Lixão do IFCE")
        );



        mMap.setOnMarkerClickListener(this);
    }


    @Override
    public boolean onMarkerClick(Marker marker) {

        Intent intent = new Intent(getActivity(), infoDep.class);
        intent.putExtra("nome", marker.getTitle());
        startActivity(intent);
        return false;
    }

}