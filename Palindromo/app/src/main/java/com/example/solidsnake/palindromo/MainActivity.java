package com.example.solidsnake.palindromo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtpoli;
    private EditText txtresult;
    private Button btninver;
    private Button btnpoli;
    private Button btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtpoli=findViewById(R.id.txtPolindromo);
        txtresult=findViewById(R.id.txtResultado);

        btninver=findViewById(R.id.btnInvertir);
        btnpoli=findViewById(R.id.btnPolindromo);
        btnclear=findViewById(R.id.btnLimpiar);

        btninver.setOnClickListener(this);
        btnpoli.setOnClickListener(this);
        btnclear.setOnClickListener(this);

    }

    public void Palindromomod(String texto, String opcion){

        boolean isPoli=true;
        int con=texto.length()-1;
        String valor="";

        for (int i=0; i<texto.length();i++)
        {
            if(texto.charAt(i)==texto.charAt(con-i)){
                isPoli=true;
            }
            else{
                isPoli=false;
                break;
            }
        }

        for (int j=0;j<texto.length();j++){
            valor+=texto.charAt(con-j);
        }

        txtresult.setText(valor);
        switch (opcion) {
            case "polindromo":
                if (isPoli == true) {
                    Toast.makeText(this, "La palabra es palindromo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "La palabra no es Palindromo", Toast.LENGTH_SHORT).show();
                } break;
            case "invertir":
                Toast.makeText(this, "Convercion Completada", Toast.LENGTH_SHORT).show(); break;
        }

    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.btnPolindromo:
                    Palindromomod(txtpoli.getText().toString(), "polindromo");
                    break;
                case R.id.btnInvertir:
                    Palindromomod(txtpoli.getText().toString(), "invertir");
                    break;
                case R.id.btnLimpiar:
                     txtpoli.setText("");
                     txtresult.setText("Polindromo");
                     Toast.makeText(this, "Limpiando campos", Toast.LENGTH_LONG).show();
                    break;
            }
        }
        catch (Exception h){
            Toast.makeText(this,"Error: "+h.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
