package br.samirtf.rxjava.examples.problemsolving;

import br.samirtf.rxjava.examples.Executable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * https://github.com/ReactiveX/RxJava/wiki/Problem-Solving-Examples-in-RxJava#generate-the
 * -fibonacci-sequence
 * How could you create an Observable that emits the Fibonacci sequence?
 *
 */
public class FibonacciSequenceV1 implements Executable {
  @Override
  public void execute() {
    Observable<Integer> fibonacci = Observable.create( observer -> {
      int fib1 = 0, fib2 = 1, fib = 1;
      while(!observer.isDisposed() && fib < 10000) {
        observer.onNext(fib);
        fib = fib1 + fib2;
        fib1 = fib2;
        fib2 = fib;
      }
    });

    fibonacci.subscribe(new Observer<Integer>() {
      @Override
      public void onSubscribe(Disposable disposable) {
        System.out.println("onSubscribe : Fibonacci Sequence");
      }

      @Override
      public void onNext(Integer integer) {
        System.out.println("fib: " + integer);
      }

      @Override
      public void onError(Throwable throwable) {
        System.err.println("error: " + throwable.getMessage());
      }

      @Override
      public void onComplete() {
        System.out.println("onComplete");
      }
    });
  }
}
