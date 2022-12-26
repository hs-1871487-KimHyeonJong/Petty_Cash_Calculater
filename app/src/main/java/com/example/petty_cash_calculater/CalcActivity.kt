package com.example.petty_cash_calculater

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.get
import com.example.petty_cash_calculater.databinding.ActivityCalcBinding
import java.text.DecimalFormat

class CalcActivity : AppCompatActivity(),Calculate {

    private lateinit var binding : ActivityCalcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textChange(500,binding.fiveHunEdit,binding.fiveHunResult)
        textChange(500,binding.fiveHunEdit2,binding.fiveHunResult2)
        textChange(1000,binding.oneThEdit,binding.oneThResult)
        textChange(1000,binding.oneThEdit2,binding.oneThResult2)
        textChange(5000,binding.fiveThEdit,binding.fiveThResult)
        textChange(5000,binding.fiveThEdit2,binding.fiveThResult2)
        textChange(10000,binding.oneMilEdit,binding.oneMilResult)
        textChange(10000,binding.oneMilEdit2,binding.oneMilResult2)
        textChange(25000,binding.twoMilEdit,binding.twoMilResult)
        textChange(25000,binding.twoMilEdit2,binding.twoMilResult2)
        textChange(50000,binding.fiveMilEdit,binding.fiveMilResult)
        textChange(50000,binding.fiveMilEdit2,binding.fiveMilResult2)
        textChange(100000,binding.tenMilEdit,binding.tenMilResult)
        textChange(100000,binding.tenMilEdit2,binding.tenMilResult2)
        textChange(100,binding.oneHunEdit,binding.oneHunResult)
        textChange(100,binding.oneHunEdit2,binding.oneHunResult2)

        binding.copyBtn.setOnClickListener {
            var clip : ClipboardManager = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            var clipData :ClipData = ClipData.newPlainText("Result",binding.AllResult.text)

            clip.setPrimaryClip(clipData)

            Toast.makeText(applicationContext,"복사되었습니다.",Toast.LENGTH_SHORT).show()
        }



    }



    override fun onDestroy() {
        super.onDestroy()

        Log.d("Calc_Activity","Destory")
    }

    override fun Plus(Red:String, Blue:String) : String {
        var result = Red.toInt() + Blue.toInt()
        val dec = DecimalFormat("#,###")
        dec.format(result)

        return result.toString()
    }

    override fun Multiply(Cost: Int, Count: String): String {
        var result = Cost * Count.toInt()
        val dec = DecimalFormat("#,###")


        return dec.format(result)
    }

    fun textChange(cost:Int,EditText : EditText,TextView : TextView){

        val dec = DecimalFormat("#,###")
        var result = ""
        var All_result = ""

        EditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if(EditText.text.toString() == ""){
                     TextView.text= Multiply(cost,"0")
                }else{
                    TextView.text = Multiply(cost,EditText.text.toString())

                    if(EditText.equals(binding.fiveHunEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.oneThEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.fiveThEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())
                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.oneMilEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.twoMilEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.fiveMilEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.tenMilEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.oneHunEdit2)){
                        result = (binding.fiveHunResult2.text.toString().replace(",","").toInt()+binding.fiveMilResult2.text.toString().replace(",","").toInt()+
                                binding.fiveThResult2.text.toString().replace(",","").toInt()+binding.oneHunResult2.text.toString().replace(",","").toInt()+
                                binding.oneMilResult2.text.toString().replace(",","").toInt()+binding.oneThResult2.text.toString().replace(",","").toInt()+
                                binding.twoMilResult2.text.toString().replace(",","").toInt()+binding.tenMilResult2.text.toString().replace(",","").toInt()).toString()

                        binding.RedResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }
                    else if(EditText.equals(binding.fiveHunEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.oneThEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.fiveThEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.oneMilEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.twoMilEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.fiveMilEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.tenMilEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }else if(EditText.equals(binding.oneHunEdit)){
                        result = (binding.fiveHunResult.text.toString().replace(",","").toInt()+binding.fiveMilResult.text.toString().replace(",","").toInt()+
                                binding.fiveThResult.text.toString().replace(",","").toInt()+binding.oneHunResult.text.toString().replace(",","").toInt()+
                                binding.oneMilResult.text.toString().replace(",","").toInt()+binding.oneThResult.text.toString().replace(",","").toInt()+
                                binding.twoMilResult.text.toString().replace(",","").toInt()+binding.tenMilResult.text.toString().replace(",","").toInt()).toString()

                        binding.BlueResult.text = dec.format(result.toInt())

                        All_result = (binding.RedResult.text.toString().replace(",","").toInt()+binding.BlueResult.text.toString().replace(",","").toInt()).toString()

                        binding.AllResult.text = dec.format(All_result.toInt())
                    }

                }
            }

        })
    }


}