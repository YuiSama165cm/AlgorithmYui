package com.yui.algorithmYui.day01;

import com.yui.algorithmYui.TimeTool;

public class feibo {
    public static void main(String[] args) {
        int n = 46;
        TimeTool.check("fib01", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib(n));
            }
        });
        TimeTool.check("fib02", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib02(n));
            }
        });

    }

    public static int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fib02(int n){
        if (n<=1)
            return n;

        int first = 0;
        int second = 1;

        for (int i = 0; i < n-1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }
}
