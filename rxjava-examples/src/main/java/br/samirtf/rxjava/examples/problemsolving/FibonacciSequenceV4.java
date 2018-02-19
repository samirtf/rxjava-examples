package br.samirtf.rxjava.examples.problemsolving;

import br.samirtf.rxjava.examples.Executable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FibonacciSequenceV4 implements Executable {
  @Override
  public void execute() {
    final FibonacciElement fibonacciElement = new FibonacciElement();
    final Observable<FibonacciElement> fibonacci = Observable.just(fibonacciElement)
        .repeat(20)
        .scan((fibonacciElement1, fibonacciElement2) -> {
          FibonacciElement result = new FibonacciElement();
          result.setFib1(fibonacciElement1.getFib2());
          result.setFib2(fibonacciElement1.getFib1() + fibonacciElement1.getFib2());
          return result;
        })
        .map(val -> {
          FibonacciElement fibElement = new FibonacciElement();
          fibElement.setFib1(val.getFib2());
          return fibElement;
        });

    fibonacci.subscribe(new Observer<FibonacciElement>() {
      @Override
      public void onSubscribe(Disposable disposable) {
        System.out.println("onSubscribe : FibonacciSequenceV4");
      }

      @Override
      public void onNext(FibonacciElement fibonacciElement) {
        System.out.println("fib: " + fibonacciElement.getFib1());
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
