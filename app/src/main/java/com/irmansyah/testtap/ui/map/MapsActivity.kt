package com.irmansyah.testtap.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.os.Bundle
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.irmansyah.testtap.R
import com.irmansyah.testtap.data.DataManager
import com.irmansyah.testtap.ui.base.BaseActivity
import com.irmansyah.testtap.ui.login.LoginActivity
import com.irmansyah.testtap.utils.SchedulerProvider
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import org.koin.android.ext.android.inject

class MapsActivity : BaseActivity(), OnMapReadyCallback, MapsView {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        askPermission()

    }

    private fun askPermission(): Unit? = Dexter.withActivity(this)
        .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
        .withListener(object : MultiplePermissionsListener {
            @SuppressLint("MissingPermission")
            override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                if (report.areAllPermissionsGranted()) {
//                        checkIsLogin(googleMap)
                    fusedLocationClient.lastLocation
                        .addOnSuccessListener { location : Location? ->
                            val loc = LatLng(location?.latitude!!, location?.longitude)
                            mMap.addMarker(MarkerOptions().position(loc).title("Marker in here"))
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc))
                        }

                } else if (report.isAnyPermissionPermanentlyDenied) {
                    finish()
                }
            }
            override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>?, token: PermissionToken?) {}})
        .check()

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showProgress() { }

    override fun hideProgress() { }
}
