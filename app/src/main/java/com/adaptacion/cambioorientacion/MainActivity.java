package com.adaptacion.cambioorientacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG ="DEPURACIOIN";
    private EditText txtnombre;
    private EditText txtapellidos;
    private Button btnboton;
    private int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnombre = findViewById(R.id.txtnombre);
        txtapellidos = findViewById(R.id.txtapellido);
        this.btnboton = findViewById(R.id.btnContador);

        txtnombre.setText("");
        txtapellidos.setText(Integer.toString(this.contador));
        //Verificar los Eventos
        Log.d(TAG,"Estamos en el evento onCreate");

        btnboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                txtapellidos.setText(Integer.toString(contador));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Estamos en el evento onStart");
    }

    //GUARDAR TODAS LAS VARIABLES INICIALIZADAS
    @Override
    protected void onSaveInstanceState(Bundle GuardarDatos) {
        super.onSaveInstanceState(GuardarDatos);
        ///Guardamos la informacion
        GuardarDatos.putInt("CONTADOR",this.contador);
    }

    //METODO QUE RESTAURA  LA INSTANCIA DE LO QUE AGUARDAMOS EN EL METODO ANTERIOR
    @Override
    protected void onRestoreInstanceState(Bundle estadoAnterior) {
        super.onRestoreInstanceState(estadoAnterior);
        //Restauramos las Variables
        this.contador = estadoAnterior.getInt("CONTADOR");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Verificar los Eventos
        Log.d(TAG,"Estamos en el evento onResume");
        //Validamos si el altos es mayor que el alto
        //WindowManager Obtiene la Instancia de la Pantalla
        if(this.getWindowManager().getDefaultDisplay().getHeight()>this.getWindowManager().getDefaultDisplay().getWidth()){
            this.getWindowManager().getDefaultDisplay().getWidth();
            Toast.makeText(this,"Esta en Vertical",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Esta en Horizontal",Toast.LENGTH_SHORT).show();
        }
    }
    //en este metodo se guarda la instancia del estado de la aplicacion
    @Override
    protected void onPause() {
        super.onPause();
        //Verificar los Eventos
        Log.d(TAG,"Estamos en el evento onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Verificar los Eventos
        Log.d(TAG,"Estamos en el evento onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Verificar los Eventos
        Log.d(TAG,"Estamos en el evento onDestroy");
    }
}
