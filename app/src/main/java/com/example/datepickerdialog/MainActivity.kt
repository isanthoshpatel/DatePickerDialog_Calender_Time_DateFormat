package com.example.datepickerdialog

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        Calendar.getInstance().time.let { date.text = DateFormat.getDateTimeInstance().format(it) }

        bt_datePickerDialog.setOnClickListener {
            DatePickerDialog_DialogFragment().show(supportFragmentManager, "")
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(this, "$dayOfMonth-$month-$year", Toast.LENGTH_LONG).show()
        var c = Calendar.getInstance()
        c.set(Calendar.YEAR, year)
        c.set(Calendar.MONTH, month)
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        var time = c.time

        DateFormat.getDateTimeInstance().format(time).let { tv_date.text = it }

    }
}
