package day9.Adapter.math.v2.calc;

import day9.Adapter.math.Arifmetika;

public class NewCalculator implements Calculator {

    private Arifmetika arifmetika=new Arifmetika();

    @Override
    public int summa(int a, int b) {
        int[] numbers=new int[]{a,b};
        int resultSumma=arifmetika.summa(numbers);
        return resultSumma;
    }

    @Override
    public int multiply(int a, int b) {
        int resultMultiply=arifmetika.multiply(a,b);
        return resultMultiply;
    }
}
