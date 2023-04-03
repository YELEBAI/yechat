package com.example.yechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class grade extends AppCompatActivity {
    private TextView numbersTextView;
    private TextView minTextView;
    private TextView maxTextView;
    private TextView avgTextView;
    private TextView sumTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new array();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        numbersTextView = findViewById(R.id.numbersTextView);
        minTextView = findViewById(R.id.minTextView);
        maxTextView = findViewById(R.id.maxTextView);
        avgTextView = findViewById(R.id.avgTextView);
        sumTextView = findViewById(R.id.sumTextView);

        Intent intent = getIntent();
        List<Integer> numbers = intent.getIntegerArrayListExtra("numbers");

        if (numbers != null && numbers.size() > 0) {
            int min = numbers.get(0);
            int max = numbers.get(0);
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            int i =1;

            for (int number : numbers) {
                if (number < min) {
                    min = number;
                }
                if (number > max) {
                    max = number;
                }
                sum += number;
            }
            for (i = 0; i<numbers.size(); i++){
                sb.append("("+(i+1)+")").append(".").append(numbers.get(i)).append("  ");
            }

            double avg = (double) sum / numbers.size();

            numbersTextView.setText(sb.toString());
            minTextView.setText("Min: " + min);
            maxTextView.setText("Max: " + max);
            avgTextView.setText("平均成绩: " + String.format("%.2f", avg));
            sumTextView.setText("总和: " + sum);

        }

    }
}

