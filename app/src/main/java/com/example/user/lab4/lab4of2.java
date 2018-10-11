package com.example.user.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class lab4of2 extends AppCompatActivity {
Button sentbtn;
String suger="無糖";
EditText setdrink;
String iceopt="微冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4of2);
        RadioGroup rg1=(RadioGroup)findViewById(R.id.radiogroup1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        suger="無糖";
                        break;
                    case R.id.radioButton2:
                        suger="少糖";
                        break;
                    case R.id.radioButton3:
                        suger="半糖";
                        break;
                    case R.id.radioButton4:
                        suger="黃金比例";
                        break;
                }
            }
        });

        RadioGroup rg=(RadioGroup)findViewById(R.id.radiogroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton5:
                        iceopt="微冰";
                        break;
                    case R.id.radioButton6:
                        iceopt="少冰";
                        break;
                    case R.id.radioButton7:
                        iceopt="正常冰";
                        break;
                }
            }
        });

        sentbtn=(Button)findViewById(R.id.sent);
        sentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setdrink=(EditText)findViewById(R.id.editText);
                String temp=setdrink.getText().toString();
                Intent i=new Intent();
                Bundle b=new Bundle();
                b.putString("suger_level",suger);
                b.putString("drink_level",temp);
                b.putString("ice_level",iceopt);
                i.putExtras(b);
                setResult(101,i);
                finish();
            }
        });
    }
}
