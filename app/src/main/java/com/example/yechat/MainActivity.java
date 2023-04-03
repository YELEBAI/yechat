package com.example.yechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private Button addButton;
    private Button clearButton;
    private Button displayButton;
    private EditText inputEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.add);
        clearButton = findViewById(R.id.clear);
        displayButton = findViewById(R.id.show);
        inputEditText = findViewById(R.id.input);
        resultTextView = findViewById(R.id.rgrade);
        List<Integer> numbers = new ArrayList<>();
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String numbersString = sharedPref.getString("numbers", "");
        if (!numbersString.isEmpty()) {
            String[] numbersArray = numbersString.split(",");
            for (String numString : numbersArray) {
                int num = Integer.parseInt(numString);
                numbers.add(num);
            }
        }
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputEditText.getText().toString();
                if (!input.isEmpty()) {
                    int num = Integer.parseInt(input);
                    numbers.add(num);
                    inputEditText.setText("");
                    resultTextView.setText("已添加");
                    saveData(numbers);
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.clear();
                resultTextView.setText("已清除");
                saveData(numbers);
            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbers.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, grade.class);
                    intent.putIntegerArrayListExtra("numbers", (ArrayList<Integer>) numbers);
                    startActivity(intent);
                }
                else resultTextView.setText("未查询到成绩！");
            }
        });
    }
    private void  saveData(List<Integer>numbers){  //保存数据方法
        SharedPreferences sharePref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePref.edit();
        StringBuilder sb = new StringBuilder();
        for(Integer num:numbers)
        {
            sb.append(num).append(",");
        }
        editor.putString("numbers", sb.toString());
        editor.apply();
    }
}
