package br.samirtf.rxjava.examples;

import br.samirtf.rxjava.examples.problemsolving.*;
import br.samirtf.rxjava.examples.reactiveaddition.DriverThree;
import br.samirtf.rxjava.examples.reactiveaddition.DriverTwo;

public class RxjavaExamplesApplication {

	public static void main(String[] args) {
		new BasicOne().execute();
		//new DriverOne().execute();
		//new DriverTwo().execute();
		//new DriverThree().execute();
		//new ProjectEuler().execute();
		//new FibonacciSequenceV1().execute();
		//new FibonacciSequenceV2().execute();
		//new FibonacciSequenceV3().execute();
		new FibonacciSequenceV4().execute();

	}
}
