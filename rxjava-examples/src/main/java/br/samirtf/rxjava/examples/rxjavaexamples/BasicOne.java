package br.samirtf.rxjava.examples.rxjavaexamples;


import io.reactivex.Observable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BasicOne implements Executable {
  @Override
  public void execute() {
    final String[] shapesArray = new String[]{"rectangle", "square", "triangle"};
    final List<String> shapesList = Arrays.asList(shapesArray);

    System.out.println("--------------Observable.from--------------");
    Observable.fromIterable(shapesList).subscribe(
        x -> System.out.println(x),
        x -> System.err.println("error"),
        () -> System.out.println("completed - List")
    );
    Observable.fromArray(shapesArray).subscribe(
        x -> System.out.println(x),
        x -> System.err.println("error"),
        () -> System.out.println("completed - Array")
    );

    System.out.println("--------------Observable.just--------------");
    Observable.just(shapesList).subscribe(
        x -> System.out.println(x),
        x -> System.err.println("error"),
        () -> System.out.println("completed - List")
    );
    Observable.just(shapesArray).subscribe(
        x -> System.out.println(Arrays.toString(x)),
        x -> System.err.println("error"),
        () -> System.out.println("completed - Array")
    );

    System.out.println("--------------Observable.create--------------");
    Observable.create(subscriber -> {
      try {
        final Iterator<String> iterator = shapesList.iterator();
        while(iterator.hasNext()) {
          subscriber.onNext(iterator.next());
        }
        if(!subscriber.isDisposed()) {
          subscriber.onComplete();
        }
      } catch (Exception exc) {
        if(!subscriber.isDisposed()) {
          subscriber.onError(exc);
        }
      }
    }).subscribe(x -> System.out.println(x),
        x -> System.err.println("error"),
        () -> System.out.println("completed"));
  }
}
