package Chapter03.use;

import Chapter03.used.AddCalc;
import Chapter03.used.Calculator;

public class Call {

	public static void main(String[] args) {
		Calculator calculator = new AddCalc();
		Integer result = calculator.calc(10, 5);

		System.out.println(result);
	}

}
