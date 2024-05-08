package com.example.guess_number.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.guess_number.R

class GameFragment : Fragment(R.layout.fragment_game) {

    var result: Int = 0

    companion object {
        fun getRandomNumber(max: Int, min: Int): Int {
            return (Math.random() * (max - min) + min).toInt()
        }
    }

    fun makeToast(str: String) {
        Toast.makeText(requireContext(), str, Toast.LENGTH_SHORT).show()
    }

    fun clickFunction(view: View) {
        val variable = view.findViewById<EditText>(R.id.editId)
        val userGuessing = variable.text.toString().toInt()

        when {
            userGuessing < result -> makeToast("Think of Higher Number, Try Again")
            userGuessing > result -> makeToast("Think of Lower Number, Try Again")
            else -> makeToast("Congratulations, You Got the Number")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val min = 1
        val max = 100
        result = getRandomNumber(min, max)

        view.findViewById<Button>(R.id.btnUser).setOnClickListener {
            clickFunction(view)
        }
    }
}
