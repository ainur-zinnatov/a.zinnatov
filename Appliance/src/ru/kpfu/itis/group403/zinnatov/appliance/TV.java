package ru.kpfu.itis.group403.zinnatov.appliance;

/**
 * Created by hp on 14.02.2015.
 */
public class TV extends  Appliance implements  Comparable{
	protected double diog;


	public TV(double aPr, double aWe, double aPo,double aDi) {
		super("TV",aPr, aWe, aPo);
		diog = aDi;
	}

	@Override
	public int getRate() {
		return (int)(super.getRate()*diog/28);
	}
}
