package com.irmansyah.testtap.data.local.db.reg

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Reg")
data class Reg(@PrimaryKey
                 val nik: String? = null,
               @ColumnInfo(name = "name")
               val name: String? = null,
               @ColumnInfo(name = "ttl")
               val ttl: String? = null,
               @ColumnInfo(name = "gender")
               val gender: String? = null,
               @ColumnInfo(name = "address")
               val address: String? = null,
               @ColumnInfo(name = "hobby")
               val hobby: String? = null)