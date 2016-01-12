package day9.Adapter.math.v1.calc;

import day9.Adapter.math.Arifmetika;

public class Calculator {

/*
	public int summa(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}
*/

    private Arifmetika arifmetika=new Arifmetika();

    public int summa(int a, int b) {
        int[] numbers=new int[]{a,b};
        int resultSumma=arifmetika.summa(numbers);
        return resultSumma;
    }

    public int multiply(int a, int b) {
        int resultMultiply=arifmetika.multiply(a,b);
        return resultMultiply;
    }

}
