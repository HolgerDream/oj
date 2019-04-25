package com.holger.hdoj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String line;
	int a, b, n;
	while (!(line = sc.nextLine()).equals("0 0 0")) {
	    a = Integer.parseInt(line.split("\\s+")[0]);
	    b = Integer.parseInt(line.split("\\s+")[1]);
	    n = Integer.parseInt(line.split("\\s+")[2]);
	    int res = calc(a, b, n);
	    System.out.println(res);
	}
    }

    private static int calc(int a, int b, int n) {
	if (a < 1 & a > 1000 & b < 1 & b > 1000 & b < 1 & a > 100000000){
	    System.exit(0);
	}
	int f[] = new int[50];
	for (int i = 1; i < 50; i++) {
	    if (i == 1 || i == 2) {
		f[i] = 1;
	    } else {
		f[i] = (a * f[i - 1] + b * f[i - 2]) % 7;
	    }
	}
	return f[n % 49];
    }
}
