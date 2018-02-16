package br.samirtf.rxjava.examples.problemsolving;

import br.samirtf.rxjava.examples.Executable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public class FibonacciSequenceV2 implements Executable {
  @Override
  public void execute() {
    int[] array = {0, 1};
    Observable<int[]> fibonacci = Observable.fromArray(array).repeat().scan((ints, ints2) -> {
      final int[] fib = {ints[1], ints[0] + ints[1]};
      return fib;
    }).map(ints -> {
      final int[] fib = {ints[1]};
      return fib;
    }).takeWhile(ints -> ints[0] < 10000);

    fibonacci.subscribe(new Observer<int[]>() {
      @Override
      public void onSubscribe(Disposable disposable) {
        System.out.println("onSubscribe : Fibonacci Sequence V2");
      }

      @Override
      public void onNext(int[] ints) {
        System.out.println("fib: " + ints[0]);
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
