package android.teste.matheusaguilar.bafometro_b2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int RETURN_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view){

        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        double peso = bundle.getDouble("peso");
        String sexo = bundle.getString("sexo");
        int copos = bundle.getInt("copos");
        String jejum = bundle.getString("jejum");

        double alcool = copos * 4.8, coef;

        if(jejum.equals("n"))
            coef = 1.1;
        else if(sexo.equals("m"))
            coef = 0.7;
        else
            coef = 0.6;

        double taxa = alcool/(peso * coef);
        String classificacao;

        if(taxa > 0.2)
            classificacao = "Pessoa Alcoolizada";
        else
            classificacao = "Pessoa NÃO Alcoolizada";

        it.putExtra("taxa", taxa);
        it.putExtra("classificacao", classificacao);

        setResult(RETURN_CODE, it);

        finish();
    }
}