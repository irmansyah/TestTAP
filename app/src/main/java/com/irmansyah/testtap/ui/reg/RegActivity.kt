package com.irmansyah.testtap.ui.reg

import android.annotation.SuppressLint
import android.os.Bundle
import com.irmansyah.testtap.R
import kotlinx.android.synthetic.main.activity_reg.*
import android.app.DatePickerDialog
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import com.irmansyah.testtap.data.local.db.AppDatabase
import com.irmansyah.testtap.data.local.db.reg.Reg
import com.irmansyah.testtap.ui.base.BaseActivity
import com.irmansyah.testtap.utils.DbWorkerThread
import java.text.SimpleDateFormat
import java.util.*


class RegActivity : BaseActivity(), RegView {

    companion object {
        const val TAG = "RegActivity"
    }

    private val myCalendar = Calendar.getInstance()
    private var name = ""
    private var nik = ""
    private var ttl = ""
    private var gender = ""
    private var address = ""
    private var hobby = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        input_ttl_layout.setOnClickListener {
            setDatePicker()
        }

        input_ttl.setOnClickListener {
            setDatePicker()
        }

        setGender()

        setDataBase()
    }

    private fun setDataBase() {
    }

    @SuppressLint("SimpleDateFormat")
    override fun setDatePicker() {
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val formatTanggal = "dd-MM-yyyy"
                val sdf = SimpleDateFormat(formatTanggal)
                Log.i(TAG, sdf.format(myCalendar.time))
                input_ttl.setText(sdf.format(myCalendar.time), TextView.BufferType.EDITABLE)
            },
            myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    override fun setGender() {
        val spinnerItems = resources.getStringArray(R.array.gender)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        gender_spinner.adapter = spinnerAdapter

        gender_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                gender = gender_spinner.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_gaming ->
                    if (checked) {
                        hobby = "Gaming"
                    }
                R.id.radio_climbing ->
                    if (checked) {
                        hobby = "Climbing"
                    }
                R.id.radio_fishing ->
                    if (checked) {
                        hobby = "Fishing"
                    }
            }
        }
    }

    fun registerButtonClicked(view: View) {
        val reg = Reg(name, nik, ttl, gender, address, hobby)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showProgress() { }

    override fun hideProgress() { }
}
