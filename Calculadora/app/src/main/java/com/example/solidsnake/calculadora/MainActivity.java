package com.example.solidsnake.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textnum1;
    private EditText textnum2;

    private Button btnSumar;
    private Button btnRestar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textnum1=findViewById(R.id.txt_num1);
        textnum2=findViewById(R.id.txt_num2);

        btnSumar=findViewById(R.id.btnsuma);
        btnRestar=findViewById(R.id.btnresta);

        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            float num1= Float.valueOf(textnum1.getText().toString());
            float num2= Float.valueOf(textnum2.getText().toString());
            float resultado;
            if (v.getId()==R.id.btnresta){
                resultado=num1-num2;
            }
            else{
                resultado=num1+num2;
            }

            Toast.makeText(this,"El resultado es: "+resultado,Toast.LENGTH_SHORT).show();
        }
        catch (Exception d){
            Toast.makeText(this,"Error: "+d.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
