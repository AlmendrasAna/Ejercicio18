package com.example.ejercicio18

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.ejercicio18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
private lateinit var mSharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSharedPreferences = getSharedPreferences("cookie", Context.MODE_PRIVATE)

        binding.guardarB.setOnClickListener{

            var text = binding.stringEdit.text.toString()
            var number = binding.numberEdit.text.toString().toInt()
            var decimal = binding.numeroDesimalEdit.text.toString().toFloat()
            var boolean = binding.switch1.isChecked

            guardarDatos(text,number,decimal,boolean)

        }
        binding.mostrarDatosB.setOnClickListener{
            mostrarDatos()
        }

        binding.limpiarB.setOnClickListener{
            limparDatos()
        }

    }

    private fun guardarDatos(text: String, number: Int, decimal: Float, boolean: Boolean) {

        mSharedPreferences.edit().putString("text",text).apply()
        mSharedPreferences.edit().putInt("number",number).apply()
        mSharedPreferences.edit().putFloat("decimal",decimal).apply()
        mSharedPreferences.edit().putBoolean("boolean",boolean).apply()


    }

    private fun mostrarDatos() {
        var text = mSharedPreferences.getString("text","")
        var number = mSharedPreferences.getInt("number",0)
        var decimal = mSharedPreferences.getFloat("decimal",0f)
        var boolean = mSharedPreferences.getBoolean("boolean",false)

        binding.stringTxt.text = text
        binding.numberTxt.text =number.toString()
        binding.decimalTxt.text =  decimal.toString()
        binding.checkTxt.text = boolean.toString()

        binding.switch1.isChecked = boolean

    }

    private fun limparDatos() {

        binding.stringTxt.text = ""
        binding.numberTxt.text = ""
        binding.decimalTxt.text = ""
        binding.checkTxt.text = ""

        binding.stringEdit.text.clear()
        binding.numberEdit.text.clear()
        binding.numeroDesimalEdit.text.clear()
        binding.switch1.isChecked =false

        mSharedPreferences.edit().clear().apply()
    }
}