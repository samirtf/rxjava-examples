package br.samirtf.rxjava.examples.problemsolving;

import br.samirtf.rxjava.examples.Executable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

/**
 * https://github.com/ReactiveX/RxJava/wiki/Problem-Solving-Examples-in-RxJava#project-euler
 * -problem-1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class ProjectEuler implements Executable {


  @Override
  public void execute() {
    Observable<Integer> threes = Observable.range(1, 999)
        .map(val -> val * 3)
        .takeWhile(val -> val < 1000);

    Observable<Integer> fives = Observable.range(1, 999)
        .map(val -> val * 5)
        .takeWhile(val -> val < 1000);

    Maybe<Integer> threesAndFives = Observable.merge(threes, fives).distinct()
        .reduce((integer, integer2) -> integer + integer2);

    threesAndFives.subscribe(new MaybeObserver<Integer>() {
      @Override
      public void onSubscribe(Disposable disposable) {
        System.out.println("subscribe : Euler problem");
      }

      @Override
      public void onSuccess(Integer integer) {
        System.out.println("sum: " + integer);
      }

      @Override
      public void onError(Throwable throwable) {
        System.err.println("error");
      }

      @Override
      public void onComplete() {
        System.out.println("complete : Euler problem");
      }
    });
  }
}
