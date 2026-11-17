package com.example.zakharovda_01_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.timer

lateinit var metres: EditText
lateinit var spinner: Spinner
lateinit var result: TextView
lateinit var button_do: Button

class MainFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        metres = view.findViewById(R.id.metres)
        spinner = view.findViewById(R.id.spinner)
        result = view.findViewById(R.id.result)
        button_do = view.findViewById(R.id.button_do)

        val roomTypes = listOf(
            "1-о комнатная квартира",
            "2-х комнатная квартира",
            "3-х комнатная квартира",
            "Студия"
        )
        val adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_item,
            roomTypes)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter

        button_do.setOnClickListener {
            if (metres.text.toString().isEmpty()) {
                Toast.makeText(context, "Введите количество метров", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val select_type = spinner.selectedItem.toString()
            val metr = metres.text.toString().toDouble()
            val price = when(select_type){
                "1-о комнатная квартира" -> 1.4
                "2-х комнатная квартира" -> 1.0
                "3-х комнатная квартира" -> 0.8
                "Студтия" -> 1.1
                else -> 0.0
            }

            val totalprice = 80 * metr * price
            result.text = totalprice.toString()

            lifecycleScope.launch {
                delay(5000)
                parentFragmentManager.commit {
                    replace(R.id.fragment_container, ResultFragment(metr, totalprice))
                }
            }
        }
    }
}