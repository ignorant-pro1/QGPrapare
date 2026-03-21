package com.example.mycounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //定义几个需要用到的字符串或者其他，一目了然。
    private TextView tvResult;
    private String firstNum = "";
    private String  operator = "";
    private String  secondNum = "";
    private String  result = "";
    private String  showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);

        //定义所有按钮
        Button btn_plus = findViewById(R.id.btn_plus);
        Button btn_minus = findViewById(R.id.btn_minus);
        Button btn_multiply = findViewById(R.id.btn_multiply);
        Button btn_divide = findViewById(R.id.btn_divide);
        Button btn_one = findViewById(R.id.btn_one);
        Button btn_two = findViewById(R.id.btn_two);
        Button btn_three = findViewById(R.id.btn_three);
        Button btn_four = findViewById(R.id.btn_four);
        Button btn_five = findViewById(R.id.btn_five);
        Button btn_six = findViewById(R.id.btn_six);
        Button btn_seven = findViewById(R.id.btn_seven);
        Button btn_eight = findViewById(R.id.btn_eight);
        Button btn_nine = findViewById(R.id.btn_nine);
        Button btn_zero = findViewById(R.id.btn_zero);
        Button btn_equal = findViewById(R.id.btn_equal);
        Button btn_AC = findViewById(R.id.btn_AC);
        Button btn_sqrt = findViewById(R.id.btn_sqrt);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_point = findViewById(R.id.btn_point);
        Button btn_reciprocal = findViewById(R.id.btn_reciprocal);

        //设置同一个监听器
        btn_AC.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_reciprocal.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_sqrt.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_zero.setOnClickListener(this);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v){
        //当点击的是数字或者根号时，需要在输入输出栏显示，所以定义一个inputText保存：
        String inputText;
        if(v.getId() == R.id.btn_sqrt){
            inputText = "√";
        }else{
            inputText = ((Button) v).getText().toString();
        }

        //对于除数字以外的按钮，点击的时候不是显示对应的数字，而应该进行独特的操作：
        if(v.getId() == R.id.btn_AC){
            clear();
        } else if (v.getId() == R.id.btn_plus) {
            operator = inputText;
            refreshText("");
        } else if (v.getId() == R.id.btn_minus) {
            operator = inputText;
            refreshText("");
        } else if (v.getId() == R.id.btn_multiply) {
            operator = inputText;
            refreshText("");
        } else if (v.getId() == R.id.btn_divide) {
            operator = inputText;
            refreshText("");
        } else if (v.getId() == R.id.btn_sqrt) {
            //parseDouble方法可以把字符串转换成double类型的数字//
            double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
            refreshOperate(String.valueOf(sqrt_result));
            refreshText(showText + "√" + result);
        } else if(v.getId() == R.id.btn_reciprocal){
            double reciprocal_result = 1.0/Double.parseDouble(firstNum);
            refreshOperate(String.valueOf(reciprocal_result));
            refreshText(result);
        } else if (v.getId() == R.id.btn_delete) {
            //填写内在逻辑//
        } else if (v.getId() == R.id.btn_equal){
            double calculate_result = calculateFour();
            refreshOperate(String.valueOf(calculate_result));
            refreshText(result);
        } else{
            if(operator.equals("")){
                firstNum = firstNum + inputText;
            }else {
                secondNum = secondNum + inputText;
            }
        }

        //点击按钮显示对应数字：
        String currentText = tvResult.getText().toString();
        if(currentText.equals("0")){
            if(inputText.equals("0") || inputText.equals("1") || inputText.equals("2") || inputText.equals("3") || inputText.equals("4") || inputText.equals("5") || inputText.equals("6") || inputText.equals("7") || inputText.equals("8") || inputText.equals("9")){
                tvResult.setText(inputText);
            }
        }else{
            if(inputText.equals("0") || inputText.equals("1") || inputText.equals("2") || inputText.equals("3") || inputText.equals("4") || inputText.equals("5") || inputText.equals("6") || inputText.equals("7") || inputText.equals("8") || inputText.equals("9")){
                tvResult.setText(currentText + inputText);
            }
        }
    }

    public double calculateFour(){
        switch (operator){
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "*":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            case "/":
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
        return 0;
    }
    public void clear(){
        refreshOperate("");
        refreshText("0");
    }

    public void refreshOperate(String new_result){
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";
    }

    public void refreshText(String text){
        showText = text;
        tvResult.setText(showText);
    }
}