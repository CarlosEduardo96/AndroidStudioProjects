package com.example.solidsnake.speedofcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtdis;
    private EditText txttime;

    private Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtdis=findViewById(R.id.txtDistancia);
        txttime=findViewById(R.id.txtTiempo);
        btncalcular=findViewById(R.id.btnCalcular);

        btncalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            double dis = Double.valueOf(txtdis.getText().toString());
            double time = Double.valueOf(txttime.getText().toString());
            double res = 0;

            if (v.getId() == R.id.btnCalcular) {
                res = dis / time;
                Toast.makeText(this, "La velocidad es de: " + res + " km/h", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception g){
            Toast.makeText(this, "Error al introducir los datos tipo:"+g.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
