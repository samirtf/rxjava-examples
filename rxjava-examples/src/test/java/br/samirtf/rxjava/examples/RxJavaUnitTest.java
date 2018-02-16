package br.samirtf.rxjava.examples;

import io.reactivex.Observable;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RxJavaUnitTest {
  String result = "";

  // Simple subscription to a fix value
  @Test
  public void returnAValue() {
    result = "";
    Observable<String> observer = Observable.just("Hello"); //provides data
    observer.subscribe( s -> result = s); // Callable as subscriber
    assertTrue(result.equals("Hello"));
  }
}
