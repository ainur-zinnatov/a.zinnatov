package ru.kpfu.itis.group403.zinnatov.appliance;

/**
 * Created by hp on 14.02.2015.
 */
public class VaccumCleaner extends Appliance implements  Comparable{
	protected double volume;


	public VaccumCleaner(double aPr, double aWe, double aPo,double aVo) {
		super("VaccumCleaner",aPr, aWe, aPo);
		volume = aVo;
	}

	@Override
	public int getRate() {
		return (int)(super.getRate()*volume/4.5);
	}
}
