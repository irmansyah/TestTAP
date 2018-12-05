package com.irmansyah.testtap.data.local.db.reg

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface RegDao {

    @Query("SELECT * FROM Reg WHERE nik LIKE :nik LIMIT 1")
    fun findFormById(nik: Long?): Reg

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReg(reg: Reg)
}