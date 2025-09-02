package com.example.faculdadeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Instanciando os objetos da tela
    private EditText mEstado;
    private EditText mValor;
    private EditText mPorcentagem;

    private EditText mvalorTotal;
    private Button mCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //

        mEstado = findViewById(R.id.estado);
        mValor = findViewById(R.id.valor);
        mPorcentagem = findViewById(R.id.porcentagem);
        mvalorTotal = findViewById(R.id.valorTotal);
        mCalcular = findViewById(R.id.calcular);

    }

    public void calcularICMS(View view) {
        String estado = mEstado.getText().toString();
        String valor = mValor.getText().toString();

        float valorFloat = Float.parseFloat(valor);

        float porcentagem = 0;

        switch (estado) {
            case "SP":
                porcentagem = 0.45f;
                break;
            case "MG":
                porcentagem = 0.075f;
                break;
            case "RO":
                porcentagem = 17.5f;
                break;
        }

        float valorTotal = valorFloat * (1 + porcentagem);

        mvalorTotal.setText(String.format("R$%.2f", valorTotal));

    }
}