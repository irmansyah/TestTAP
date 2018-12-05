package com.irmansyah.testtap.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.irmansyah.testtap.data.local.db.reg.RegDao
import com.irmansyah.testtap.data.local.db.login.LoginDao
import com.irmansyah.testtap.data.local.db.reg.Reg
import android.arch.persistence.room.Room
import android.content.Context


@Database(entities = [Reg::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun regDao(): RegDao

    abstract fun loginDao(): LoginDao
}