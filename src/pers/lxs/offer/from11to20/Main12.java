package pers.lxs.offer.from11to20;

import org.junit.Test;

public class Main12 {
	@Test
	public void test() {
		double base = 0.58D;
		int exponent = 15;

		System.out.println(Power(base, exponent));
	}

	public double Power(double base, int exponent) {
		return Math.pow(base, exponent);
	}
}