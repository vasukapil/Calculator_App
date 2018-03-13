package com.example.user.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMul, btnDiv, btnDot, btnDel, btnEqual,btnClear;

    TextView tvResult;

    public static boolean dotFlag = false;
    public static final String TAG = "MainActivity";

    public static String expression = "";
    public static HashMap<Character, Integer> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnClear=(Button)findViewById(R.id.buttonClear);

        if (savedInstanceState != null) {
            String text = savedInstanceState.getString("text");
            tvResult.setText(text);
            expression = savedInstanceState.getString("expression");
        }

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvResult.getText().toString();
                tvResult.setText(text.equals("") ? "" : text + "0");
                expression += text.equals("") ? "" : "0";
                Log.d(TAG, "onClick: " + text);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "1");
                expression += "1";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "2");
                expression += "2";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "3");
                expression += "3";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "4");
                expression += "4";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "5");
                expression += "5";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "6");
                expression += "6";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "7");
                expression += "7";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "8");
                expression += "8";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "9");
                expression += "9";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dotFlag) {
                    tvResult.setText(tvResult.getText().toString() + ".");
                    expression += ".";
                    Log.d(TAG, "onClick: " + tvResult.getText().toString());
                    dotFlag = true;
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvResult.getText().toString().length() > 0) {
                    String text = tvResult.getText().toString();
                    if (text.charAt(text.length() - 1) == '.') {
                        dotFlag = false;
                    }
                    tvResult.setText(text.substring(0, text.length() - 1));
                    int x = expression.length() - 1;
                    while (x >= 0 && expression.charAt(x) == ' ')
                        x--;

                    expression = expression.substring(0, x);
                    Log.d(TAG, "onClick: " + tvResult.getText().toString());
                    Log.d(TAG, "expression: " + expression);
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "+");
                dotFlag = false;
                expression += " + ";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
                Log.d(TAG, "onClick: " + expression);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "-");
                dotFlag = false;
                expression += " - ";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
                Log.d(TAG, "onClick: " + expression);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "*");
                dotFlag = false;
                expression += " * ";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
                Log.d(TAG, "onClick: " + expression);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(tvResult.getText().toString() + "/");
                dotFlag = false;
                expression += " / ";
                Log.d(TAG, "onClick: " + tvResult.getText().toString());
                Log.d(TAG, "onClick: " + expression);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postfix = postfix(expression);
                Log.d(TAG, "POSTFIX: " + postfix);
                String result = evaluate(postfix);
                Log.d(TAG, "Result: " + result);
                dotFlag = false;
                tvResult.setText(result);
                expression = result;
            }
        });
    }

    public static String postfix(String infix) {
        Stack<Character> s = new Stack<>();
        String postfix = "";
        int x = 0;
        if (infix.charAt(infix.length() - 1) != ' ') {
            infix += " ";
        }
        while (x < infix.length()) {
            if (infix.charAt(x) == ' ') {
                x++;
                continue;
            }
            if (infix.charAt(x) != '+' && infix.charAt(x) != '-' && infix.charAt(x) != '*' && infix.charAt(x) != '/') {
                while (x < infix.length() && infix.charAt(x) != ' ') {
                    postfix += infix.charAt(x);
                    x++;
                }
                postfix += ' ';

            } else {
                if (s.isEmpty()) {
                    s.push(infix.charAt(x));
                } else {
                    while (!s.isEmpty() && map.get(infix.charAt(x)) <= map.get(s.peek())) {
                        postfix += s.pop() + " ";
                    }
                    s.push(infix.charAt(x));
                }

            }
            x++;
        }
        while (!s.isEmpty()) {
            postfix += s.pop() + " ";
        }
        return postfix;
    }

    public static String evaluate(String postfix) {
        Stack<Double> s = new Stack<>();

        String[] terms = postfix.split(" ");

        for (int i = 0; i < terms.length; i++) {
            Log.d(TAG, "Term " + i + ": " + terms[i]);
        }

        for (int i = 0; i < terms.length; i++) {
            if (!terms[i].equals("+") && !terms[i].equals("-") && !terms[i].equals("*") && !terms[i].equals("/")) {
                s.push(Double.parseDouble(terms[i]));
            } else {
                Double a = s.pop();
                Double b = s.pop();

                if (terms[i].equals("+")) {
                    s.push(b + a);
                } else if (terms[i].equals("-")) {
                    s.push(b - a);
                } else if (terms[i].equals("*")) {
                    s.push(b * a);
                } else if (terms[i].equals("/")) {
                    s.push(b / a);
                }
            }
        }

        return String.valueOf(s.pop());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("expression", expression);
        outState.putString("text", ((TextView) findViewById(R.id.tvResult)).getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        expression = "";
        tvResult.setText("");
        super.onStop();
    }
}