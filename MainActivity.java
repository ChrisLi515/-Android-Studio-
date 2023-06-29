# -Android-Studio-
  package com.example.myapplication;
import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import android.os.Build;
import android.widget.ImageButton;
import com.example.myapplication.R;
public class MainActivity extends AppCompatActivity {
    Button btn_1,btn_2,btn_3,btn_4,btn_5;// 数字
    Button btn_6,btn_7,btn_8,btn_9,btn_0;
    Button add,sub,mul,div,dot,percentSign,ac,equ,backspace,btn_sin; //符号
    TextView result,record; // 显示结果
    String record_string; // String类型的运算步骤
    ArrayList<String> operatorStack = new ArrayList<>();
    ArrayList<Double> operandStack = new ArrayList<>();
    ArrayList<String> operatorList = new ArrayList<>();
    int previousOperatorSubscript = 0;
    int nextOperatorSubscript = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("×");
        operatorList.add("÷");
        operatorList.add("sin");

        // 获取页面上的控件
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        mul = findViewById(R.id.btn_mul);
        div = findViewById(R.id.btn_div);
        equ = findViewById(R.id.btn_equ);
        dot = findViewById(R.id.btn_dot);
        ac = findViewById(R.id.btn_clear);
        btn_sin = findViewById(R.id.btn_sin);
        percentSign = findViewById(R.id.btn_percentSign);
        backspace = findViewById(R.id.btn_delete);
        record = findViewById(R.id.et_record);
        result = findViewById(R.id.et_result);

        // 按钮的单击事件
        btn_1.setOnClickListener(new Click());
        btn_2.setOnClickListener(new Click());
        btn_3.setOnClickListener(new Click());
        btn_4.setOnClickListener(new Click());
        btn_5.setOnClickListener(new Click());
        btn_6.setOnClickListener(new Click());
        btn_7.setOnClickListener(new Click());
        btn_8.setOnClickListener(new Click());
        btn_9.setOnClickListener(new Click());
        btn_0.setOnClickListener(new Click());
        add.setOnClickListener(new Click());
        sub.setOnClickListener(new Click());
        mul.setOnClickListener(new Click());
        div.setOnClickListener(new Click());
        equ.setOnClickListener(new Click());
        dot.setOnClickListener(new Click());
        ac.setOnClickListener(new Click());
        btn_sin.setOnClickListener(new Click());
        backspace.setOnClickListener(new Click());
        percentSign.setOnClickListener(new Click());

    }

    // 设置按钮点击后的监听
    class Click implements View.OnClickListener {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @SuppressLint("NonConstantResourceId")
        public void onClick(View v) {
            if (v.getId() == R.id.btn_0) {
                // 获取0，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "0";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_1) {
                // 获取1，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "1";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_2) {
                // 获取2，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "2";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_3) {
                // 获取3，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "3";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_4) {
                // 获取4，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "4";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_5) {
                // 获取5，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "5";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_6) {
                // 获取6，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "6";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_7) {
                // 获取7，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "7";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_8) {
                // 获取8，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "8";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_9) {
                // 获取9，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "9";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_dot) {
                // 获取小数点，并在编辑框显示
                record_string = record.getText().toString();
                record_string += ".";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_add) {
                // 添加加号，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "+";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_sub) {
                // 添加减号，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "-";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_mul) {
                // 添加乘号，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "×";
                record.setText(record_string);
            } else if (v.getId() == R.id.btn_div) {
                // 添加除号，并在编辑框显示
                record_string = record.getText().toString();
                record_string += "÷";
                record.setText(record_string);
            }else if (v.getId() == R.id.btn_sin) {
                    // 添加除号，并在编辑框显示
                    record_string = record.getText().toString();
                    record_string += "sin";
                    record.setText(record_string);
            } else if (v.getId() == R.id.btn_delete) {
                // 删除最后一个字符
                record_string = record.getText().toString();
                if (record_string.length() > 0) {
                    record_string = record_string.substring(0, record_string.length() - 1);
                    record.setText(record_string);
                }
            } else if (v.getId() == R.id.btn_clear) {
                // 清除编辑框和结果
                record.setText(null);
                result.setText(null);
                previousOperatorSubscript = 0;
                nextOperatorSubscript = 0;
                operandStack.clear();
                operatorStack.clear();
            } else if (v.getId() == R.id.btn_equ) {
                // 执行计算
                if ("错误".equals(result.getText().toString())) return;
                record_string = record.getText().toString();
                record_string += "=";
                if ("".equals(record_string)) return;


                // 遍历运算记录，调整运算优先级，使运算记录中只剩下加减操作
                for (int i = 0; i < record_string.length(); i++) {
                    String operator = String.valueOf(record_string.charAt(i));
                    // 如果遍历到运算符
                    if (operatorList.contains(operator)) {

                        // 插入新的操作数
                        nextOperatorSubscript = i;
                        try {
                            operandStack.add(Double.parseDouble(record_string.substring(previousOperatorSubscript, nextOperatorSubscript)));
                        } catch (Exception e) {
                            result.setText("错误");
                            return;
                        }
                        previousOperatorSubscript = nextOperatorSubscript + 1;

                        // 如果运算符栈中没有运算符
                        if (operatorStack.size() == 0) {
                            operatorStack.add(operator);
                        } else {
                            // 找出上一个运算符
                            String pre_operator = operatorStack.get(operatorStack.size() - 1);

                            if ("×".equals(pre_operator)) {
                                // 移除上一个运算符
                                operatorStack.remove(operatorStack.size() - 1);
                                Double num1 = operandStack.get(operandStack.size() - 2);
                                Double num2 = operandStack.get(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.add(num1 * num2);
                            } else if ("÷".equals(pre_operator)) {
                                // 移除上一个运算符
                                operatorStack.remove(operatorStack.size() - 1);
                                Double num1 = operandStack.get(operandStack.size() - 2);
                                Double num2 = operandStack.get(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.add(num1 / num2);
                            }
                            // 插入新的运算符
                            operatorStack.add(operator);
                        }
                    } else if (i == record.length() - 1) {
                        // 如果遍历到末尾，添加最后一个操作数
                        try {
                            operandStack.add(Double.parseDouble(record_string.substring(previousOperatorSubscript, record.length())));
                        } catch (Exception e) {
                            result.setText("错误");
                            return;
                        }
                        // 如果上一个操作数是乘法或除法，则进行运算
                        if (operatorStack.size() > 0) {
                            String pre_operator = operatorStack.get(operatorStack.size() - 1);
                            if ("×".equals(pre_operator)) {
                                // 移除上一个运算符
                                operatorStack.remove(operatorStack.size() - 1);
                                Double num1 = operandStack.get(operandStack.size() - 2);
                                Double num2 = operandStack.get(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.add(num1 * num2);
                            } else if ("÷".equals(pre_operator)) {
                                // 移除上一个运算符
                                operatorStack.remove(operatorStack.size() - 1);
                                Double num1 = operandStack.get(operandStack.size() - 2);
                                Double num2 = operandStack.get(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.remove(operandStack.size() - 1);
                                operandStack.add(num1 / num2);
                            }
                        }
                    }
                }

                // 判断两个栈是否合法
                if (operandStack.size() != operatorStack.size() + 1) {
                    result.setText("错误");
                    return;
                }

                // 完成剩余栈中的运算
                for (int i = 0; i < operatorStack.size(); i++) {
                    String operator = operatorStack.get(i);
                    if ("+".equals(operator)) {
                        Double num1 = operandStack.get(0);
                        Double num2 = operandStack.get(1);
                        operandStack.remove(0);
                        operandStack.remove(0);
                        operandStack.add(num1 + num2);
                    } else if ("-".equals(operator)) {
                        Double num1 = operandStack.get(0);
                        Double num2 = operandStack.get(1);
                        operandStack.remove(0);
                        operandStack.remove(0);
                        operandStack.add(0, num1 - num2);
                    } else if ("×".equals(operator)) {
                        Double num1 = operandStack.get(0);
                        Double num2 = operandStack.get(1);
                        operandStack.remove(0);
                        operandStack.remove(0);
                        operandStack.add(0, num1 * num2);
                    } else if ("÷".equals(operator)) {
                        Double num1 = operandStack.get(0);
                        Double num2 = operandStack.get(1);
                        operandStack.remove(0);
                        operandStack.remove(0);
                        operandStack.add(0, num1 / num2);
                    }
                    else if ("sin".equals(operator)) {
                        Double num1 = operandStack.get(0);
                        Double num2 = operandStack.get(1);
                        operandStack.remove(0);
                        operandStack.remove(0);
                        operandStack.add(0, Math.sin(num1));
                    }
                }
                result.setText(String.valueOf(operandStack.get(0)));    //将结果完整输出
                record.setText(String.valueOf(operandStack.get(0)));
                previousOperatorSubscript = 0;
                nextOperatorSubscript = 0;
                operandStack.clear();
                operatorStack.clear();
            }

        }
    }
}
