package br.samirtf.rxjava.examples.problemsolving;

import br.samirtf.rxjava.examples.Executable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FibonacciSequenceV3 implements Executable {
  @Override
  public void execute() {
    final FibonacciElement fibonacciElement = new FibonacciElement();
    final Observable<FibonacciElement> fibonacci = Observable.just(fibonacciElement)
        .repeat()
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
        })
        .takeWhile(fibonacciElement12 -> fibonacciElement12.getFib1() < 10000);

    fibonacci.subscribe(new Observer<FibonacciElement>() {
      @Override
      public void onSubscribe(Disposable disposable) {
        System.out.println("onSubscribe : FibonacciSequenceV3");
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

class FibonacciElement {
  private int fib1;
  private int fib2;

  FibonacciElement() {
    fib1 = 0;
    fib2 = 1;
  }

  public int getFib1() {
    return fib1;
  }

  public void setFib1(int fib1) {
    this.fib1 = fib1;
  }

  public int getFib2() {
    return fib2;
  }

  public void setFib2(int fib2) {
    this.fib2 = fib2;
  }

  @Override
  public String toString() {
    return "FibonacciElement{" +
        "fib1=" + fib1 +
        ", fib2=" + fib2 +
        '}';
  }
}
