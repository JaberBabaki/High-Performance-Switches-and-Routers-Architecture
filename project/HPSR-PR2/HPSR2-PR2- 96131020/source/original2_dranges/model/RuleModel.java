package com.ario.original2_dranges.model;

/**
 * Created by jaberALU on 20/01/2018.
 */

public class RuleModel {
  private String name;
  private String source;
  private String destedition;

  public RuleModel(String name, String source, String destedition) {
    this.name = name;
    this.source = source;
    this.destedition = destedition;
  }

  public String getName() {
    return name;
  }

  public String getSource() {
    return source;
  }

  public String getDestedition() {
    return destedition;
  }

}
