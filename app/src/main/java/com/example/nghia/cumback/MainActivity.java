package com.example.nghia.cumback;

import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nghia.cumback.expression.ExpressionList;

public class MainActivity extends AppCompatActivity {

    private TextView resultView, formulaBar;
    private Button[] btnNum;
    private Button btnClear, btnSign, btnPercent, btnDiv, btnMul, btnMinus, btnAdd, btnEval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Initialize TextViews
        // Due to ignorance, the developer can't get the job done with XML
        // he has to explicitly set the max size of TextViews to avoid theirs resizing
        int padding = Resources.getSystem().getDisplayMetrics().widthPixels / 20;

        resultView = findViewById(R.id.result_view);
        resultView.setMaxHeight(resultView.getHeight());
        resultView.setMaxWidth(resultView.getMaxWidth());
        resultView.setPadding(padding, 0, padding, 0);

        resultView.setTextSize(70);
        resultView.setText("6.5000000..");

        formulaBar = findViewById(R.id.formula_bar);
        formulaBar.setMaxHeight(formulaBar.getHeight());
        formulaBar.setMaxWidth(formulaBar.getWidth());
        formulaBar.setPadding(padding, 0, padding, 0);
        formulaBar.setText(formulaBar.getText(), TextView.BufferType.EDITABLE);

        formulaBar.setTextSize(45);
        formulaBar.setText("sin(30) + 9 * 10 /2 - 155 =");

        btnNum = new Button[10];
        for (int i = 0; i < 10; ++i) {
            btnNum[i] = findViewById(R.id.btn_num_0 + i);
            final int number = i;

            btnNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExpressionList.writeToExpression(number);
                    insertToFormulaBar(number);
                }
            });
        }

        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(btnClearClickListener);

        Shader textShader = new LinearGradient(0, 0, 0, btnClear.getLineHeight(),
                new int[] {getResources().getColor(R.color.start_color_gradient), getResources().getColor(R.color.end_color_gradient)},
                null, Shader.TileMode.CLAMP);
        btnClear.getPaint().setShader(textShader);
    }

    private View.OnClickListener btnClearClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public void insertToFormulaBar(String text) {
        ((Editable) formulaBar.getText()).insert(formulaBar.getText().length() - 1, text);
    }

    public void insertToFormulaBar(int number) {
        ((Editable) formulaBar.getText()).insert(formulaBar.getText().length() - 1, String.valueOf(number));
    }
}
