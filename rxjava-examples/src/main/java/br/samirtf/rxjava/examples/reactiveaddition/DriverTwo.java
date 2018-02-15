package br.samirtf.rxjava.examples.reactiveaddition;

import br.samirtf.rxjava.examples.Executable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverTwo implements Executable {

  @Override
  public void execute() {
    final List<AVariable> variables = Collections.synchronizedList(new ArrayList<AVariable>());
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
      if (variables.contains(aVariable)) {
        variables.get(variables.indexOf(aVariable)).setVarValue(aVariable.getVarValue());
      } else {
        variables.add(aVariable);
      }
      variables.stream().map(x -> x.getVarName() + ": " + x.getVarValue()).forEach(x -> System.out
          .println(x));
      System.out.println("added VARIABLES: " + variables.stream()
          .mapToDouble(x -> x.getVarValue()).sum()
      );
    }
  }
}
