package ru.kpfu.itis.group403.zinnatov.findMaxAndMin;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    System.out.println("Размер массива (не меньше 2):");
	    int size = scan.nextInt();
	    int [] array = new int [size];
	    for (int i = 0; i <size; i++) {
			array[i]=scan.nextInt();
	    }

	    System.out.println("Max: "+findMaxMin(array)[1]+", Min: "+findMaxMin(array)[0]);

    }


	public static int [] findMaxMin (int [] a,int start, int end){

		int [] minAndMax = new int [2];

		if(end-start == 1) {
			if (a[end] < a[start]) {
				minAndMax[0] = a[end];
				minAndMax[1] = a[start];
			} else {
				minAndMax[0] = a[start];
				minAndMax[1] = a[end];
			}
			return minAndMax;
		}
		else {
			int[] right = findMaxMin(a, start, (end+start)/2);
			int[] left = findMaxMin(a, (end+start)/2, end);
			return new int[]{Math.min(right[0], left[0]),Math.max(right[1], left[1])};
		}

	}

	private static int[] findMaxMin(int []a){
		return  findMaxMin(a,0,a.length-1);
	}

}
