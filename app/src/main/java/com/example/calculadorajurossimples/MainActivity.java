package com.example.calculadorajurossimples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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


        EditText txtJuros;
        EditText txtCapital;
        EditText txtTaxa;
        EditText txtPrazo;
        RadioButton rbtJuros;
        RadioButton rbtTaxa;
        RadioButton rbtCapital;
        RadioButton rbtPrazo;
        RadioGroup rgpGrupo;
        Button btnCalc;
        Button btnLimp;
        TextView txtResult;

        txtJuros = findViewById(R.id.txtJuros);
        txtCapital = findViewById(R.id.txtCapital);
        txtTaxa = findViewById(R.id.txtTaxa);
        txtPrazo = findViewById(R.id.txtPrazo);

        rbtJuros = findViewById(R.id.btnJuros);
        rbtCapital = findViewById(R.id.btnCapital);
        rbtTaxa = findViewById(R.id.btnTaxa);
        rbtPrazo = findViewById(R.id.btnPrazo);
        rgpGrupo = findViewById(R.id.rgpGroup);

        btnCalc = findViewById(R.id.btnCalc);
        btnLimp = findViewById(R.id.btnLimpar);

        txtResult = findViewById(R.id.txtResult);

        txtJuros.setOnClickListener(v -> txtJuros.setText(""));
        txtCapital.setOnClickListener(v -> txtCapital.setText(""));
        txtTaxa.setOnClickListener(v -> txtTaxa.setText(""));
        txtPrazo.setOnClickListener(v -> txtPrazo.setText(""));

        txtPrazo.setEnabled(true);
        txtCapital.setEnabled(true);
        txtTaxa.setEnabled(true);
        txtJuros.setEnabled(true);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double juros;
                double capital;
                double taxa;
                double prazo;
                double result;

                if (rbtJuros.isChecked() && txtCapital.getText() != null && txtPrazo.getText() != null && txtTaxa.getText() != null) {
                    txtJuros.setText(null);
                    capital = Double.parseDouble(String.valueOf(txtCapital.getText()));
                    taxa = Double.parseDouble(String.valueOf(txtTaxa.getText()));
                    prazo = Double.parseDouble(String.valueOf(txtPrazo.getText()));
                    juros = capital * taxa * prazo;
                    result = juros;
                    txtResult.setText(String.valueOf(result));
                }

            }
        });

        btnLimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(null);
                txtCapital.setText(null);
                txtPrazo.setText(null);
                txtTaxa.setText(null);
                txtJuros.setText(null);
                }
            });

        /* rgpGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Reabilita todos os campos primeiro
                txtJuros.setEnabled(true);
                txtCapital.setEnabled(true);
                txtTaxa.setEnabled(true);
                txtPrazo.setEnabled(true);

                // Desativa o campo conforme a opção escolhida
                switch (checkedId) {
                    case R.id.btnJuros:
                        txtJuros.setEnabled(false);
                        break;
                    case R.id.btnCapital:
                        txtCapital.setEnabled(false);
                        break;
                    case R.id.btnTaxa:
                        txtTaxa.setEnabled(false);
                        break;
                    case R.id.btnPrazo:
                        txtPrazo.setEnabled(false);
                        break;
                }
            }
        });

        /* Força o comportamento inicial com base no botão já selecionado
        int checkedId = rgpGrupo.getCheckedRadioButtonId();
        switch (checkedId) {
            case R.id.btnJuros:
                txtJuros.setEnabled(false);
                break;
            case R.id.btnCapital:
                txtCapital.setEnabled(false);
                break;
            case R.id.btnTaxa:
                txtTaxa.setEnabled(false);
                break;
            case R.id.btnPrazo:
                txtPrazo.setEnabled(false);
                break;
        }*/
    }
}
