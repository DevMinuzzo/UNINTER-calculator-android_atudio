package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

// Ao implementar a interface View.OnClickListener é possível definir um OnClick padrão para a classe
// e passar o this como argumento do setOnClickListener de cada botão número e de operação.
// O código fica mais limpo do que sobrescrever manualmente um OnClick para cada botão.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declaração de variável que vai controlar se o display de expressões deve ou não ser resetado
    // Declaração de uma variável para mensagem de erro do display
    private boolean resetExpression = false;
    private static final String ERROR_MESSAGE = "ERROR";
    // Declaração das variáveis para os botões numéricos
    private Button btnNumber0, btnNumber1, btnNumber2, btnNumber3, btnNumber4, btnNumber5, btnNumber6,
            btnNumber7, btnNumber8, btnNumber9;
    // Declaração das variáveis para os botões de operações
    private Button btnDot, btnParenthesisLeft, btnParenthesisRight, btnEquals, btnAddition, btnSubtraction, btnMultiplication, btnDivision, btnClear;
    // Declaração das variáveis para os displays
    private TextView displayExpression, displayResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        _initNumbers();
        _initOperations();
        _initDisplays();

        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnDot.setOnClickListener(this);
        btnParenthesisLeft.setOnClickListener(this);
        btnParenthesisRight.setOnClickListener(this);
        btnAddition.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearDisplays();
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateExpression();
            }
        });
    }

    // Concatena os valores de cada botão número ou de operação no display de expressão
    private void addExpression(String string) {
        if (this.isResetExpression()) {
            displayExpression.setText("");
            displayResult.setText("");
            this.setResetExpression(false);
        }
        displayExpression.append(string);
    }

    // Faz a limpeza dos displays
    private void clearDisplays() {
        displayExpression.setText("");
        displayResult.setText("");
    }

    // Calcula o resultado final utilizando uma lib externa net.objecthunter:exp4j:0.4.8
    private void calculateExpression() {
        try {
            Expression expression = new ExpressionBuilder(displayExpression.getText().toString()).build();
            double result = expression.evaluate();
            // Remove casas decimais no caso da some ser um inteiro
            if (result == (int) result) {
                int intResult = (int) result;
                displayResult.setText(String.valueOf(intResult));
            } else {
                displayResult.setText(String.valueOf(result));
            }
            this.setResetExpression(true);
        } catch (Exception e) {
            Log.e("CALCULATOR ERROR", "Houve um problema ao realizar a operação!");
            displayResult.setText(ERROR_MESSAGE);
            this.setResetExpression(true);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNumber0:
                addExpression(btnNumber0.getText().toString());
                break;
            case R.id.btnNumber1:
                addExpression(btnNumber1.getText().toString());
                break;
            case R.id.btnNumber2:
                addExpression(btnNumber2.getText().toString());
                break;
            case R.id.btnNumber3:
                addExpression(btnNumber3.getText().toString());
                break;
            case R.id.btnNumber4:
                addExpression(btnNumber4.getText().toString());
                break;
            case R.id.btnNumber5:
                addExpression(btnNumber5.getText().toString());
                break;
            case R.id.btnNumber6:
                addExpression(btnNumber6.getText().toString());
                break;
            case R.id.btnNumber7:
                addExpression(btnNumber7.getText().toString());
                break;
            case R.id.btnNumber8:
                addExpression(btnNumber8.getText().toString());
                break;
            case R.id.btnNumber9:
                addExpression(btnNumber9.getText().toString());
                break;
            case R.id.btnDot:
                addExpression(btnDot.getText().toString());
                break;
            case R.id.btnParenthesisLeft:
                addExpression(btnParenthesisLeft.getText().toString());
                break;
            case R.id.btnParenthesisRight:
                addExpression(btnParenthesisRight.getText().toString());
                break;
            case R.id.btnAddition:
                addExpression(btnAddition.getText().toString());
                break;
            case R.id.btnSubtraction:
                addExpression(btnSubtraction.getText().toString());
                break;
            case R.id.btnMultiplication:
                addExpression(btnMultiplication.getText().toString());
                break;
            case R.id.btnDivision:
                addExpression(btnDivision.getText().toString());
                break;
        }
    }

    // Buscando e instanciando os elementos da view
    // Numéricos:
    private void _initNumbers() {
        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
    }

    // Operações:
    private void _initOperations() {
        btnDot = (Button) findViewById(R.id.btnDot);
        btnParenthesisLeft = (Button) findViewById(R.id.btnParenthesisLeft);
        btnParenthesisRight = (Button) findViewById(R.id.btnParenthesisRight);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnClear = (Button) findViewById(R.id.btnClear);
    }

    // Displays
    private void _initDisplays() {
        displayExpression = (TextView) findViewById(R.id.displayExpression);
        displayResult = (TextView) findViewById(R.id.displayResult);
    }


    private boolean isResetExpression() {
        return resetExpression;
    }

    private void setResetExpression(boolean resetExpression) {
        this.resetExpression = resetExpression;
    }
}