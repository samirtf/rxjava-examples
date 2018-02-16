package br.samirtf.rxjava.examples;

import br.samirtf.rxjava.examples.problemsolving.FibonacciSequenceV1;
import br.samirtf.rxjava.examples.problemsolving.FibonacciSequenceV2;
import br.samirtf.rxjava.examples.problemsolving.ProjectEuler;
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
		new FibonacciSequenceV2().execute();

	}
}
