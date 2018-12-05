package com.irmansyah.testtap.ui.map

import com.google.android.gms.maps.GoogleMap
import com.irmansyah.testtap.data.DataManager
import com.irmansyah.testtap.ui.base.BasePresenter
import com.irmansyah.testtap.utils.ScProvider

class MapsPresenter<V : MapsView> constructor(dataManager: DataManager, scProvider: ScProvider) : BasePresenter<V>(dataManager = dataManager, scProvider = scProvider)  {

//    fun setGoogleMap(googleMap: GoogleMap?) {
//        dataManager.setGoogleMap(googleMap)
//    }
//
//    fun setCurrentLoc() {
//    }
//
//    fun showCurrentLoc() {
//        dataManager.showCurrentLoc()
//    }
}