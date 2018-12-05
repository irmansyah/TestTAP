package com.irmansyah.testtap.di

import android.arch.persistence.room.Room
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.model.MarkerOptions
import com.irmansyah.testtap.data.AppDataManager
import com.irmansyah.testtap.data.DataManager
import com.irmansyah.testtap.data.local.db.AppDatabase
import com.irmansyah.testtap.data.local.db.login.LoginRepo
import com.irmansyah.testtap.data.local.db.login.LoginRepository
import com.irmansyah.testtap.data.local.db.reg.RegRepository
import com.irmansyah.testtap.data.local.db.reg.RegRepo
import com.irmansyah.testtap.data.map.AppMapHelper
import com.irmansyah.testtap.data.map.MapHelper
import com.irmansyah.testtap.ui.reg.RegPresenter
import com.irmansyah.testtap.ui.reg.RegView
import com.irmansyah.testtap.ui.login.LoginPresenter
import com.irmansyah.testtap.ui.login.LoginView
import com.irmansyah.testtap.ui.map.MapsPresenter
import com.irmansyah.testtap.ui.map.MapsView
import com.irmansyah.testtap.utils.ScProvider
import com.irmansyah.testtap.utils.SchedulerProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object AppModule {

    fun getModule(): Module = applicationContext {

        factory { MapsPresenter<MapsView>(get(), get()) }
        factory { RegPresenter<RegView>(get(), get()) }
        factory { LoginPresenter<LoginView>(get(), get()) }

        bean { RegRepository(get()) as RegRepo }
        bean { LoginRepository(get()) as LoginRepo }

        bean { AppDataManager() as DataManager }
        bean { AppMapHelper(get()) as MapHelper }
        bean { SchedulerProvider() as ScProvider }
        bean {
            Room.databaseBuilder(get(), AppDatabase::class.java, "testTAP.db")
            .fallbackToDestructiveMigration()
            .build()
        }
    }
}