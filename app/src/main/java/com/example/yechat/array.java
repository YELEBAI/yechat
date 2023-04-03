package com.example.yechat;

import android.widget.TextView;

public class array {
    TextView input;
        int a = 5;
        int[] arr1 = new int[a];
        int[] arr2 = new int[2];


    public int[] setarray() {
        input.findViewById(R.id.input);
   int value = Integer.parseInt(input.getText().toString());
     

for(int i = 0; i<arr1.length; i++)
{
    while(arr1[i]<0||arr1[i]>100)
    {
        arr1[i]=value;
    }
}
return arr1;
    }
}



