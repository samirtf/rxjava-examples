package br.samirtf.rxjava.examples.reactiveaddition;

import java.util.Objects;

public class AVariable {
  private String varName = null;
  private Double varValue = 0.0;

  public AVariable(String varName, Double varValue) {
    this.varName = varName;
    this.varValue = varValue;
  }

  public Double getVarValue() {
    return varValue;
  }

  public void setVarValue(Double varValue) {
    this.varValue = varValue;
  }

  public String getVarName() {
    return varName;
  }

  public void setVarName(String varName) {
    this.varName = varName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AVariable aVariable = (AVariable) o;
    return Objects.equals(varName, aVariable.varName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(varName);
  }
}
