package calculator.com.example.dewioktaviani.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    TextView tvResult;
    Button btnDelete, btn_small_bracket, btn_percentage, btn_back, btn_seven, btn_eight, btn_nine, btn_multiple;
    Button btn_four, btn_five, btn_six, btn_minus, btn_one, btn_two, btn_three, btn_plus, btn_dot, btn_zero, btn_divide, btn_equal;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = 'x';
    private static final char DIVISION = '/';
    private static final char PERCENTAGE = '%';
    private String LASTSTRING = "";
    private char CURRENT_ACTION;
    StringBuilder currentValue = new StringBuilder();
    private double valueOne = Double.NaN;
    private double valueLast = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.##########");

        etInput = (EditText) findViewById(R.id.etInput);
        tvResult = (TextView)findViewById(R.id.tvResult);
        btnDelete = (Button)findViewById(R.id.btn_delete);
        btn_small_bracket = (Button)findViewById(R.id.btn_small_bracket);
        btn_percentage = (Button)findViewById(R.id.btn_percentage);
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_seven = (Button)findViewById(R.id.btn_seven);
        btn_eight = (Button)findViewById(R.id.btn_eight);
        btn_nine = (Button)findViewById(R.id.btn_nine);
        btn_multiple = (Button)findViewById(R.id.btn_multiple);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_five = (Button)findViewById(R.id.btn_five);
        btn_six = (Button)findViewById(R.id.btn_six);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_one = (Button)findViewById(R.id.btn_one);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_dot = (Button)findViewById(R.id.btn_dot);
        btn_zero = (Button)findViewById(R.id.btn_zero);
        btn_divide = (Button)findViewById(R.id.btn_divide);
        btn_equal = (Button)findViewById(R.id.btn_equal);


        etInput.requestFocus();
        etInput.setEnabled(false);
        etInput.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_one.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_one.getText().toString());
                tvResult.setText("");
            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_two.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_two.getText().toString());
                tvResult.setText("");
            }
        });

        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_three.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_three.getText().toString());
                tvResult.setText("");
            }
        });

        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_four.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_four.getText().toString());
                tvResult.setText("");
            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_five.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_five.getText().toString());
                tvResult.setText("");
            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_six.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_six.getText().toString());
                tvResult.setText("");
            }
        });

        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_seven.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_seven.getText().toString());
                tvResult.setText("");
            }
        });

        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_eight.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_eight.getText().toString());
                tvResult.setText("");
            }
        });


        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_nine.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_nine.getText().toString());
                tvResult.setText("");
            }
        });

        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.append(btn_zero.getText().toString());
                etInput.setText(etInput.getText().toString()+ btn_zero.getText().toString());
                tvResult.setText("");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentValue.length()>0&&!currentValue.substring(currentValue.length()-1, currentValue.length()).equals(".")){
                    etInput.setText(etInput.getText().toString()+ btn_dot.getText().toString());
                    currentValue.append(btn_dot.getText().toString());
                }else if (currentValue.length()==0){
                    etInput.setText("0" + btn_dot.getText().toString());
                    currentValue.append("0" + btn_dot.getText().toString());
                }
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LASTSTRING = etInput.getText().toString();
                boolean valid = true;
                if (LASTSTRING.endsWith("+")||LASTSTRING.endsWith("-")||LASTSTRING.endsWith("x")||LASTSTRING.endsWith("/")||LASTSTRING.endsWith("%")){
                    valid = false;
                }
                if (etInput.getText().length()>0&&valid){
                    etInput.setText(etInput.getText().toString()+ btn_plus.getText().toString());
                    tvResult.setText("");
                    computeCalculation();
                    currentValue.delete(0, currentValue.length());
                    CURRENT_ACTION = ADDITION;
                    if (tvResult.getText().length()>0){
                        valueLast = Double.parseDouble(tvResult.getText().toString());
                    }
                }
            }
        });


        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LASTSTRING = etInput.getText().toString();
                boolean valid = true;
                if (LASTSTRING.endsWith("+")||LASTSTRING.endsWith("-")||LASTSTRING.endsWith("x")||LASTSTRING.endsWith("/")||LASTSTRING.endsWith("%")){
                    valid = false;
                }
                if (etInput.getText().length()>0&&valid){
                    etInput.setText(etInput.getText().toString()+ btn_minus.getText().toString());
                    tvResult.setText("");
                    computeCalculation();
                    currentValue.delete(0, currentValue.length());
                    CURRENT_ACTION = SUBTRACTION;
                    if (tvResult.getText().length()>0){
                        valueLast = Double.parseDouble(tvResult.getText().toString());
                    }
                }
            }
        });


        btn_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LASTSTRING = etInput.getText().toString();
                boolean valid = true;
                if (LASTSTRING.endsWith("+")||LASTSTRING.endsWith("-")||LASTSTRING.endsWith("x")||LASTSTRING.endsWith("/")||LASTSTRING.endsWith("%")){
                    valid = false;
                }
                if (etInput.getText().length()>0&&valid){
                    etInput.setText(etInput.getText().toString()+ btn_multiple.getText().toString());
                    tvResult.setText("");
                    computeCalculation();
                    currentValue.delete(0, currentValue.length());
                    CURRENT_ACTION = MULTIPLICATION;
                    if (tvResult.getText().length()>0){
                        valueLast = Double.parseDouble(tvResult.getText().toString());
                    }
                }
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LASTSTRING = etInput.getText().toString();
                boolean valid = true;
                if (LASTSTRING.endsWith("+")||LASTSTRING.endsWith("-")||LASTSTRING.endsWith("x")||LASTSTRING.endsWith("/")||LASTSTRING.endsWith("%")){
                    valid = false;
                }
                if (etInput.getText().length()>0&&valid){
                    etInput.setText(etInput.getText().toString()+ btn_divide.getText().toString());
                    tvResult.setText("");
                    computeCalculation();
                    currentValue.delete(0, currentValue.length());
                    CURRENT_ACTION = DIVISION;
                    if (tvResult.getText().length()>0){
                        valueLast = Double.parseDouble(tvResult.getText().toString());
                    }
                }
            }
        });


        btn_small_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue.delete(0, currentValue.length());
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LASTSTRING = etInput.getText().toString();
                if (LASTSTRING.endsWith("+")||LASTSTRING.endsWith("-")||LASTSTRING.endsWith("x")||LASTSTRING.endsWith("/")||LASTSTRING.endsWith("%")){
                    Toast.makeText(getApplicationContext(), "Format yang digunakan tidak valid", Toast.LENGTH_SHORT).show();
                }else {
                    computeCalculation();
                }
                currentValue.delete(0, currentValue.length());

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                valueLast = Double.NaN;
                etInput.setText("");
                tvResult.setText("");
                currentValue.delete(0, currentValue.length());
            }
        });

    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            if (currentValue.length()>0){
                valueTwo = Double.parseDouble(String.valueOf(currentValue));
                if (!Double.isNaN(valueLast)){
                    valueOne = valueLast;
                }
                if(CURRENT_ACTION == ADDITION)
                    valueOne = this.valueOne + valueTwo;
                else if(CURRENT_ACTION == SUBTRACTION)
                    valueOne = this.valueOne - valueTwo;
                else if(CURRENT_ACTION == MULTIPLICATION)
                    valueOne = this.valueOne * valueTwo;
                else if(CURRENT_ACTION == DIVISION)
                    valueOne = this.valueOne / valueTwo;

                tvResult.setText(decimalFormat.format(valueOne));
            }

        }
        else {
            try {
                valueOne = Double.parseDouble(String.valueOf(currentValue));
            }
            catch (Exception e){}
        }
    }
}
