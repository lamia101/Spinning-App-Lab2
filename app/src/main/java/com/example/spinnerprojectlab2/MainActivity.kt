package com.example.spinnerprojectlab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var selectedmakeup: String?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val button:Button=findViewById(R.id.button_id)
        val spinner:Spinner=findViewById(R.id.spinner_id)
        val makeup=resources.getStringArray(R.array.makeup_product_string)

        if(spinner!=null){
            val adapter1= ArrayAdapter(this,android.R.layout.simple_spinner_item,makeup)
            spinner.adapter=adapter1
            spinner.onItemSelectedListener=object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    selectedmakeup=makeup[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

            button.setOnClickListener{
                val mk=selectedmakeup
                if(mk!=null)
                {
                    val message= (getMenu(mk)).toString()
                    val intent=Intent(applicationContext,SecondPage::class.java)
                    intent.putExtra("message",message)
                    startActivity(intent)
                }
            }

        }


    }
}

fun getMenu(makeupitem:String): List<String> {
    val Menu: MutableList<String> = ArrayList()
    if(makeupitem=="Eyes")
    {
        Menu.add("Eyeliner\nKajol\nMascara\nEyeshadow\nEyebrow pen or gel")
    }
    else if(makeupitem=="Face")
    {
        Menu.add("moisturizer \nPrimer \nFoundation \nConcealer \nBlush \nContour or Bronzer \nFace Powder \nSetting Spray")
    }
    else if(makeupitem=="Lips")
    {
        Menu.add("Lip Balm \nLip Liner \nLipStick")
    }
    else if(makeupitem=="Hair")
    {
        Menu.add("Hair Serum \nHair Styling kit")
    }
    return Menu

}