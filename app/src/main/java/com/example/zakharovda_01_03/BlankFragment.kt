package com.example.zakharovda_01_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.commit

lateinit var login: EditText
lateinit var password: EditText
lateinit var button: Button

class BlankFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login = view.findViewById(R.id.login)
        password = view.findViewById(R.id.password)
        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            if (login.text.toString().isEmpty() or password.text.toString().isEmpty()){
                Toast.makeText(context, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            parentFragmentManager.commit {
                replace(R.id.fragment_container, MainFragment())
            }
        }
    }

}