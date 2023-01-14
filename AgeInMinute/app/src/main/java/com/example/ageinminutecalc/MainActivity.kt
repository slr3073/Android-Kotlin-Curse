package com.example.ageinminutecalc

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var dateSelectedHint: TextView? = null
    private var dateSelected: TextView? = null
    private var nbMinHint: TextView? = null
    private var nbMin: TextView? = null
    private var btnDatePick: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateSelectedHint = findViewById<TextView>(R.id.dateSelectedHint)
        dateSelected = findViewById<TextView>(R.id.dateSelected)
        nbMinHint = findViewById<TextView>(R.id.nbMinHint)
        nbMin = findViewById<TextView>(R.id.nbMin)



        btnDatePick = findViewById<Button>(R.id.buttonDatePicker)
        btnDatePick?.setOnClickListener { onClickDatePicker() }
    }

    private fun onClickDatePicker() {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE)

                val date = sdf.parse("$selectedDay/${selectedMonth + 1}/$selectedYear")
                val timePassedInMinuteSincePickedDate = (date.time) / 60000
                val timePassedInMinuteSinceCurrentTime = sdf.parse(sdf.format(System.currentTimeMillis())).time / 60000

                dateSelected?.text = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                nbMin?.text = "${timePassedInMinuteSinceCurrentTime - timePassedInMinuteSincePickedDate}"
                dateSelectedHint?.visibility = View.VISIBLE
                dateSelected?.visibility  = View.VISIBLE
                nbMinHint?.visibility  = View.VISIBLE
                nbMin?.visibility  = View.VISIBLE
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis() - (24 * 60 * 60 * 1000) // Hier
        datePickerDialog.show()


    }
}