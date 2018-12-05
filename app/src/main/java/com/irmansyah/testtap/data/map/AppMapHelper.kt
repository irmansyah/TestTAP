package com.irmansyah.testtap.data.map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import io.reactivex.Single

class AppMapHelper constructor(private val context: Context
//                               private var fusedLocation: FusedLocationProviderClient,
//                               private val markerOptions: MarkerOptions,
//                               private var locationRequest: LocationRequest
): MapHelper {

    private var googleMap: GoogleMap? = null
    private lateinit var googleApiClient: GoogleApiClient

//    override fun setGoogleMap(gMap: GoogleMap?) {
//        this.googleMap = gMap
//        this.googleMap?.let {
//            it.uiSettings?.isZoomControlsEnabled = false
//            it.uiSettings.isRotateGesturesEnabled = false
//        }
//    }
//
//    override fun showCurrentLoc() {
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) return
//        this.googleMap?.isMyLocationEnabled = true
//        this.googleMap?.uiSettings?.isZoomControlsEnabled = true
//        getGoogleApiClient()
//    }
//
//    override fun getGoogleApiClient(): GoogleApiClient {
//        googleApiClient = GoogleApiClient.Builder(context)
//            .addConnectionCallbacks(object : GoogleApiClient.ConnectionCallbacks {
//                override fun onConnected(p0: Bundle?) {
////                    locationRequest.interval = 1000
////                    locationRequest.fastestInterval = 1000
////                    locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//                }
//
//                override fun onConnectionSuspended(p0: Int) {
//                    googleApiClient.connect()
//                }
//            })
//            .addOnConnectionFailedListener {
//
//            }
//            .addApi(LocationServices.API)
//            .build()
//        googleApiClient.connect()
//        return googleApiClient
//    }

//    override fun getCurrentLocTask(): Single<Task<Location>> = Single.fromCallable { if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { null } else { fusedLocation.lastLocation }}
}