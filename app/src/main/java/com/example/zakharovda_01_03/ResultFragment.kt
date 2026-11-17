package com.example.zakharovda_01_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit

class ResultFragment(
    private val m: Double,
    private val totalResult: Double
) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var button_reg = view.findViewById<Button>(R.id.button_reg)
        var result_next_metres = view.findViewById<TextView>(R.id.result_next_metres)
        var result_next_price = view.findViewById<TextView>(R.id.result_next_price)

        result_next_metres.text = m.toString()
        result_next_price.text = totalResult.toString()

        button_reg.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, BlankFragment())
            }
        }
    }
}