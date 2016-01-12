package day9.Adapter.math.v2;

import day9.Adapter.math.v2.calc.Calculator;
import day9.Adapter.math.v2.calc.DefaultCalculator;
import day9.Adapter.math.v2.calc.NewCalculator;

import java.util.Random;



public class Launcher {

	public static void main(String[] args) {
		Calculator calc = new NewCalculator();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}
	}
}
