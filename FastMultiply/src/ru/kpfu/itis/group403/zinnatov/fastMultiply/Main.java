package ru.kpfu.itis.group403.zinnatov.fastMultiply;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите 1ое число:");
		long x = scan.nextLong();
		System.out.println("Введите 2ое число:");
		long y = scan.nextLong();
		long num = fastMulti(x,y);
		System.out.println("Ответ: "+num);


	}
	public static long fastMulti(long x,long y){
		return fastMulti(x,y,64);
	}
	public static long fastMulti(long x, long y,int n){
		long m1,m2,m3;

		int s = (int) (Math.signum(x)*Math.signum(y));
		x = Math.abs(x);
		y = Math.abs(y);

		if(n == 1) {
			if (x == 1 && y == 1) {
				return s;
			}
			return 0;
		}


		long a = x>>(n/2);
		long b =(x<<(64-(n/2)));
			 b=b>>>(64-(n/2));
		long c = y>>(n/2);
		long d =(y<<(64-(n/2)));
			 d=d>>>(64-(n/2));


		m1 = fastMulti(a,c,n/2);
		m2 = fastMulti(a-b,d-c,n/2);
		m3 = fastMulti(b,d,n/2);
		return  s*(m1*(long)(Math.pow(2, n) ) + (m1 + m2 + m3) * (long)(Math.pow(2, n/2)) + m3);

	}

}
