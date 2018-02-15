package br.samirtf.rxjava.examples.reactiveaddition;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SimpleObserver implements Observer<AVariable> {

  @Override
  public void onSubscribe(Disposable disposable) {
    System.out.println("added variables: " + DriverThree.VARIABLES.stream()
        .mapToDouble(x -> x
        .getVarValue()).sum());
    System.out.println("-------------------------------------------------------");
  }

  @Override
  public void onNext(AVariable aVariable) {
    System.out.println(aVariable.getVarName() + ": " + aVariable.getVarValue());
  }

  @Override
  public void onError(Throwable throwable) {
    System.err.println("error");
  }

  @Override
  public void onComplete() {
    System.out.println("completed");
  }
}
