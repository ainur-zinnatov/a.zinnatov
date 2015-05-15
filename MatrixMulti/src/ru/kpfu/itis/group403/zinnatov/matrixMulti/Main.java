package ru.kpfu.itis.group403.zinnatov.matrixMulti;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Random rnd = new Random();
        int [][]a =new int[200 ][200];

        int [][]b=new int [200][200];

        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                a[i][j]=rnd.nextInt(10);
                b[i][j]=rnd.nextInt(10);
            }

        }

        long timestart=System.currentTimeMillis() ;

        int c [][]=  new int [a.length][a.length];
            Thread [] threads = new Thread[20];
        int count = a.length/threads.length;

        threads[0] = new multiMat(a,b,0,count,c);
        threads[0].start();

        int begin = count;

        int tr=count*2;
        for (int i = 1; i <threads.length ; i++) {
            threads[i]=new multiMat(a,b,begin,tr,c);
            threads[i].start();
            threads[i].join();
            begin+= count;
            tr+=count;
        }



        long timeend=System.currentTimeMillis() ;



        for (int i = 0; i <c.length ; i++) {
            for (int j = 0; j <c[0].length ; j++) {
                System.out.print(c[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("Time: "+(timeend-timestart));
    }


    private static class multiMat extends Thread {
        public multiMat(final int[][] a, final int[][] b,int begin,int end,int [][] result) {
            for (int i =begin; i < end; i++) {

                for (int j = 0; j < a.length; j++) {

                    for (int k = 0; k < a.length; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
    }
}
