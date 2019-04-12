package com.example.a0328work;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.dog3);
    }

    int size=30;

    public void respone(View V){

        EditText name = findViewById(R.id.editText);
        EditText height = findViewById(R.id.editText3);
        EditText weight = findViewById(R.id.editText2);
        TextView respone=findViewById(R.id.textView);
        float height1 = Float.parseFloat(height.getText().toString());
        float weight1 = Float.parseFloat(weight.getText().toString());
        float BMI =calculate(height1,weight1);
        respone.setTextSize(size);
        respone.setTextColor(Color.BLUE);
        respone.setText(name.getText().toString()
                +getResources().getString(R.string.txt_hello)
                +"\n"
                +getResources().getString(R.string.txt_ybmi)
                +BMI
        );
        Toast.makeText(this,answer(BMI),Toast.LENGTH_LONG).show();
    }

    public float calculate(float height,float weight){
        float BMI = (float) (weight/Math.pow((height/100),2));
        return BMI;
    }

    public String answer(float BMI){
        String answer=" ";
        if(BMI>25){
            answer = getResources().getString(R.string.txt_heavy);
            getWindow().setBackgroundDrawableResource(R.drawable.dog2);
        }
        else  if (BMI<18.5){
            answer = getResources().getString(R.string.txt_slim);
            getWindow().setBackgroundDrawableResource(R.drawable.dog1);
        }
        else {
            answer = getResources().getString(R.string.txt_good);
            getWindow().setBackgroundDrawableResource(R.drawable.dog3);
        }
        return answer;
    }

}
