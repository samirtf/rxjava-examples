package br.samirtf.rxjava.examples.baeldung;

import br.samirtf.rxjava.examples.Executable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Letters implements Executable {


  @Override
  public void execute() {
    final String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    final String[] result = {""};
    final Observable<String> observable = Observable.fromArray(letters);
    observable.subscribe(new Observer<String>() {
      @Override
      public void onSubscribe(Disposable disposable) {
        System.out.println("subscribed");
      }

      @Override
      public void onNext(String s) {

      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onComplete() {

      }
    });
  }
}
