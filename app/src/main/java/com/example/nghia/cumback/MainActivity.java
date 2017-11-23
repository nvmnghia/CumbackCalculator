package com.example.nghia.cumback;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.nghia.cumback.expression.ExpressionList;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private Button[] numButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        resultView = findViewById(R.id.result_view);

        numButtons = new Button[10];
        for (int i = 0; i < 10; ++i) {
            numButtons[i] = findViewById(R.id.btn_num_0 + i);
            final int number = i;

            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExpressionList.writeToExpression(String.valueOf(number));

                    resultView.setText(ExpressionList.getCurrentExpression());
                }
            });
        }



        Button btnAC = findViewById(R.id.btn_ac);
        Shader textShader = new LinearGradient(0, 0, 0, btnAC.getLineHeight(),
                new int[] {getResources().getColor(R.color.start_color_gradient), getResources().getColor(R.color.end_color_gradient)},
                null, Shader.TileMode.CLAMP);
        btnAC.getPaint().setShader(textShader);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
