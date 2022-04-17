package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnOshiru, btnC, btnPlus, btnMinus, btnX, btnBolu, btnTen , btnComma;
    TextView tvSan, tvZapis;

    String birinshiSan, ekisnshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        sandarMethods();
        oshiruPlusMinusMethod();
        functionMethod();

    }

    public void initViews(){

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnOshiru = findViewById(R.id.btn_dell);
        btnC = findViewById(R.id.btn_c);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);

        btnX = findViewById(R.id.btn_multi);
        btnBolu = findViewById(R.id.btn_div);
        btnTen = findViewById(R.id.btn_equal);
        btnComma =findViewById(R.id.btn_comma);

        tvSan = findViewById(R.id.san);
        tvZapis = findViewById(R.id.zapis);
    }
    public void sandarMethods(){

        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiResult = "";

                switch (view.getId()){
                    case R.id.btn0:
                        basilganSan =  "0";
                        break;
                    case R.id.btn1:
                        basilganSan =  "1";
                        break;
                    case R.id.btn2:
                        basilganSan =  "2";
                        break;
                    case R.id.btn3:
                        basilganSan =  "3";
                        break;
                    case R.id.btn4:
                        basilganSan =  "4";
                        break;
                    case R.id.btn5:
                        basilganSan =  "5";
                        break;
                    case R.id.btn6:
                        basilganSan =  "6";
                        break;
                    case R.id.btn7:
                        basilganSan =  "7";
                        break;
                    case R.id.btn8:
                        basilganSan =  "8";
                        break;
                    case R.id.btn9:
                        basilganSan =  "9";
                        break;
                    case R.id.btn_comma:
                        if(aldingiSan.contains(",")){
                            basilganSan = "";
                        }else{
                            basilganSan = ",";
                        }
                        break;
                    case R.id.btn_dell:
                        if(tvSan.length()>0){
                            String deltxt = aldingiSan.substring(0,aldingiSan.length()-1);
                            aldingiSan = deltxt;
                            basilganSan = "";
                        }
                        break;
                }

                if(!aldingiSan.equals("0")) songiResult = aldingiSan + basilganSan;
                else songiResult = basilganSan;

                tvSan.setText(songiResult);
            }
        };

        btn0.setOnClickListener(buttonSandar);
        btn1.setOnClickListener(buttonSandar);
        btn2.setOnClickListener(buttonSandar);
        btn3.setOnClickListener(buttonSandar);
        btn4.setOnClickListener(buttonSandar);
        btn5.setOnClickListener(buttonSandar);
        btn6.setOnClickListener(buttonSandar);
        btn7.setOnClickListener(buttonSandar);
        btn8.setOnClickListener(buttonSandar);
        btn9.setOnClickListener(buttonSandar);
        btnComma.setOnClickListener(buttonSandar);
    }
    public void oshiruPlusMinusMethod(){

        View.OnClickListener buttonOwiruPlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_c:

                        tvSan.setText("0");
                        tvZapis.setText("");
                        break;

                    case R.id.btn_dell:

                        String sanText = tvSan.getText().toString();
                        int sanInt = Integer.parseInt(sanText);
                        int sanIntC = sanInt / 10;
//                        int sanIntSony = sanInt-sanIntC;
                        tvSan.setText(""+sanIntC);
                        break;

                }
            }
        };

        btnOshiru.setOnClickListener(buttonOwiruPlusMinus);
        btnC.setOnClickListener(buttonOwiruPlusMinus);

    }
    public void functionMethod(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                birinshiSan = tvSan.getText().toString();

                switch (view.getId()){

                    case R.id.btn_plus:
                        znak = "+";
                        break;

                    case R.id.btn_minus:
                        znak = "-";
                        break;
                    case R.id.btn_multi:
                        znak = "*";
                        break;

                    case R.id.btn_div:
                        znak = "/";
                        break;
                }

                zapisText = birinshiSan + znak;
                tvZapis.setText(zapisText);
                tvSan.setText("0");
            }
        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnX.setOnClickListener(btnFunctions);
        btnBolu.setOnClickListener(btnFunctions);


        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekisnshiSan = tvSan.getText().toString();
                double res = 0;
                if(zapisText.contains(("0"))){
                    double san1 = Double.parseDouble(birinshiSan);
                    double san2 = Double.parseDouble(ekisnshiSan);

                    if(znak.equals("+")){
                        res = san1 + san2;
                    }else if(znak.equals("-")){
                        res = san1 - san2;
                    }else if(znak.equals("*")){
                        res = san1 * san2;
                    }else if(znak.equals("/")){
                        res = san1 / san2;
                    }
                }
                else {
                    int san1 = Integer.parseInt(birinshiSan);
                    int san2 = Integer.parseInt(ekisnshiSan);

                    if (znak.equals("+")) {
                        res = san1 + san2;
                    } else if (znak.equals("-")) {
                        res = san1 - san2;
                    } else if (znak.equals("*")) {
                        res = san1 * san2;
                    } else if (znak.equals("/")) {
                        res = san1 / san2;
                    }
                }
                zapisText = birinshiSan + znak + ekisnshiSan + " = "+res;

                tvZapis.setText(zapisText);
                tvSan.setText(""+res);
            }
        });
    }
}

