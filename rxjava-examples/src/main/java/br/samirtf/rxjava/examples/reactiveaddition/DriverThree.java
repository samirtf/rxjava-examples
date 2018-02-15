package br.samirtf.rxjava.examples.reactiveaddition;

import br.samirtf.rxjava.examples.Executable;
import io.reactivex.Observable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverThree implements Executable {

  public static final List<AVariable> VARIABLES = Collections.synchronizedList(new
      ArrayList<AVariable>());
  @Override
  public void execute() {

    final Observable<AVariable> observable = Observable.fromIterable(VARIABLES);
    final SimpleObserver simpleObserver = new SimpleObserver();
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    AVariable aVariable = null;
    String varName = null;
    Double varValue = 0.0;
    System.out.println("----------reactive example [change is propagated]----------");
    while (true) {
      System.out.println("please enter var name:");
      try {
        varName = bufferedReader.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (varName.equalsIgnoreCase("exit")) {
        break;
      } else if (varName.isEmpty()) {
        continue;
      }
      System.out.println("please enter var value:");
      try {
        varValue = Double.valueOf(bufferedReader.readLine());
      } catch (NumberFormatException | IOException exc) {
        // ignore variable;
        continue;
      }
      aVariable = new AVariable(varName, varValue);
      if (VARIABLES.contains(aVariable)) {
        VARIABLES.get(VARIABLES.indexOf(aVariable)).setVarValue(aVariable.getVarValue());
      } else {
        VARIABLES.add(aVariable);
      }
      observable.subscribe(simpleObserver);
      System.out.println("added VARIABLES: " + VARIABLES.stream()
          .mapToDouble(x -> x.getVarValue()).sum()
      );
    }
  }
}
