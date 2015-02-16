package ru.kpfu.itis.group403.zinnatov.appliance;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

	    Appliance [] a = new Appliance[10];

	    a[0]= new TV(3000,10,120,18);
	    a[1]= new Blender(1200,2.4,100);
	    a[2]= new Toster(670,3.4,180);
	    a[3]= new VaccumCleaner(3500,8.3,180,6);
	    a[4]= new TV(12000,15,180,28);
	    a[5]= new Blender(870,2.1,120);
	    a[6]= new Toster(1070,4.2,120);
	    a[7]= new VaccumCleaner(1200,5.3,180,4);
	    a[8]= new Blender(1250,2.4,120);
	    a[9]= new Toster(470,2.4,120);

	    Arrays.sort(a);
	    for (Appliance anA : a) {
		    System.out.println(anA.toStr());
	    }
    }
}
