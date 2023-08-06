package com.test.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button btnSum ;
    Button btnSub ;
    Button btnDiv ;
    Button btnMul ;
    Button btnlg ;
    Button btnSquare ;
    Button btnClear;

    TextView txtResult ;
    TextView inptNum1;
    TextView inptNum2;

    private String getValue(TextView txt){
        return txt.getText().toString();
    }

    private String getResults(double result){


        String data = String.format("%.2f", result);
        if(result < 10 && result > 0){
            data = "0"+data;
        }
      if(data.length() > 7){
          return "N/A";
      }else{
          return data;
      }
    }


    private String calculation(String txt1, String txt2, char operation){

        double total = 00.0;
        if(txt1.equals("") || txt2.equals("")){

          Toast.makeText(MainActivity.this, "Please enter values!!", Toast.LENGTH_SHORT).show();
        }else {

            double num1 = Double.parseDouble(txt1);
            double num2 = Double.parseDouble(txt2);

            switch (operation) {
                case '+':
                    total = sum(num1, num2);
                    break;
                case '-':
                    total = sub(num1, num2);
                    break;
                case '*':
                    total = mul(num1, num2);
                    break;
                case '/':
                    total = div(num1, num2);
                    break;
                case '^':
                    total = square(num1, num2);
                    break;
                case 'l':
                    total = log(num1, num2);
                    break;
            }

        }

        return getResults(total);
    }

    private double sub(double num1, double num2){
        return num1 - num2;
    }

    private double sum(double num1, double num2){
        return num1 + num2;
    }

    private double mul(double num1, double num2){
        return num1 * num2;
    }

    private double div(double num1, double num2){
        return num1 / num2;
    }

    private double square(double num1, double num2){
        return Math.pow(num1, num2);
    }
    private double log(double num1, double num2){
        return Math.log(num1) / Math.log(num2);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Easy Cal");

        btnSum      = findViewById(R.id.btnAdd);
        btnSub       = findViewById(R.id.btnSub);
        btnDiv        = findViewById(R.id.btnDiv);
        btnMul       = findViewById(R.id.btnMul);
        btnlg          = findViewById(R.id.btnlg);
        btnSquare  = findViewById(R.id.btnSqura);
        btnClear     = findViewById(R.id.btnClear);

        txtResult     = findViewById(R.id.txtResult);
        inptNum1   = findViewById(R.id.inptNum1);
        inptNum2   = findViewById(R.id.inptNum2);



    btnSum.setOnClickListener(new View.OnClickListener() {
       double total = 0.0;
        @Override
        public void onClick(View view) {

            //get values from edit texts
            String num1 = getValue(inptNum1);
            String num2 = getValue(inptNum2);

            if(num1.equals("") || num2.equals("")){
                Toast.makeText(MainActivity.this, "Please enter values!!", Toast.LENGTH_LONG).show();
            }else{
                total = Double.parseDouble(num1) + Double.parseDouble(num2);
                txtResult.setText(getResults(total));
            }
        }
    });

    btnSub.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String num1 = getValue(inptNum1);
            String num2 = getValue(inptNum2);



           txtResult.setText(calculation(num1, num2, '-'));
        }
    });

    btnMul.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String num1 = getValue(inptNum1);
            String num2 = getValue(inptNum2);

            txtResult.setText(calculation(num1, num2, '*'));
        }
    });

    btnDiv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String num1 = getValue(inptNum1);
            String num2 = getValue(inptNum2);

            txtResult.setText(calculation(num1, num2, '/'));
        }
    });

    btnSquare.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String num1 = getValue(inptNum1);
            String num2 = getValue(inptNum2);

            txtResult.setText(calculation(num1, num2, '^'));
        }
    });

    btnlg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String num1 = getValue(inptNum1);
            String num2 = getValue(inptNum2);

            txtResult.setText(calculation(num1, num2, 'l'));
        }
    });

    btnClear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            txtResult.setText("00.0");
            inptNum1.setText("");
            inptNum2.setText("");
        }
    });







    }
}
