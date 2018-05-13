package com.example.rohit.calculatorapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.rohit.calculatorapp.R.id.addi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        addi.setOnClickListener{
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            var firstno  = first_no.text.toString()
            var secondno = second_no.text.toString()
            var add = firstno.toInt() + secondno.toInt();
            result.text = add.toString()

        }
        sub.setOnClickListener{
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            var firstno  = first_no.text.toString()
            var secondno = second_no.text.toString()
            var add = firstno.toInt() - secondno.toInt();
            result.text = add.toString()

        }
        mult.setOnClickListener{
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            var firstno  = first_no.text.toString()
            var secondno = second_no.text.toString()
            var add = firstno.toInt() * secondno.toInt();
            result.text = add.toString()
        }
        div.setOnClickListener{
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            var firstno  = first_no.text.toString()
            var secondno = second_no.text.toString()
            var add = firstno.toInt() / secondno.toInt();
            result.text = add.toString()
        }



    }
}
