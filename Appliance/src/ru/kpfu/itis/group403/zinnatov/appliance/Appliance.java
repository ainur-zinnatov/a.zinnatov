package ru.kpfu.itis.group403.zinnatov.appliance;

/**
 * Created by hp on 14.02.2015.
 */
public class Appliance implements Comparable {
	protected double price;
	protected double weidht;
	protected double power;
	protected String name;
	private static final double E = 0.001;

	public Appliance(String n,double aPr,double aWe,double aPo){
		price = aPr;
		weidht = aWe;
		power = aPo;
		name = n;
	}


	public int getRate() {
		return (int) ((power*1000)+(price*500)+(weidht/100));
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Appliance) {
			if (Math.abs(((Appliance) o).getRate()-this.getRate()) <= E) {
				return 0;
			}
			return ((Appliance) o).getRate() - this.getRate();
		}
		return Integer.MIN_VALUE;
	}

	public String toStr(){
		return name+": "+this.getRate();

	}
}
