package com.example.mahe.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Scr;
    private float NumberBf;
    private String Operation;
    private ButtonClickListener btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scr = (EditText) findViewById(R.id.editText);
        Scr.setEnabled(false);

        int idList[] = {R.id.buttonadd, R.id.button2, R.id.buttonminus, R.id.buttonequal, R.id.button5, R.id.button6,
                R.id.buttonC, R.id.button8, R.id.buttonmult, R.id.button10, R.id.buttondiv, R.id.button12,
                R.id.button, R.id.buttondot, R.id.button15, R.id.button9, R.id.button3
        };
        for (int id : idList) {
            View v = (View) findViewById(id);
            v.setOnClickListener(btnClick);
        }
    }

    public void mMath(String str){
        NumberBf = Float.parseFloat(Scr.getText().toString());
        Operation = str;
        Scr.setText("0");
    }

    public void getKeyboard(String str) {
        String ScrCurrent = Scr.getText().toString();
        if(ScrCurrent.equals("0"))
            ScrCurrent = "";
        ScrCurrent += str;
        Scr.setText(ScrCurrent);
    }

    public void mResult() {
        float NumAf = Float.parseFloat(Scr.getText().toString());
        float result = 0;
        if (Operation.equals("+")) {
            result = NumAf + NumberBf;
        }

        if (Operation.equals("-")) {
            result = NumAf - NumberBf;
        }

        if (Operation.equals("*")) {
            result = NumAf * NumberBf;
        }

        if (Operation.equals("/")) {
            Scr.setText(String.valueOf(result))
        }
    }
    private Class ButtonClickListener
    implements View.OnClickListener

    {
        public void onClick (View v){
          switch (v.getId()) {
             case R.id.buttonC:
                Scr.setText("0");
                NumberBf = 0;
                Operation = "";
                break;
             case R.id.buttonadd:
                mMath("+");
                break;
             case R.id.buttonminus:
                mMath("-");
                break;
             case R.id.buttonmult:
                mMath("*");
                break;
             case R.id.buttondiv:
                mMath("/");
                break;
             case R.id.buttonequal:
                mResult();
                break;
             default:
                String numb = ((Button) v).getText().toString();
                getKeyboard(numb);
                break;
          }
        }
    }
}
