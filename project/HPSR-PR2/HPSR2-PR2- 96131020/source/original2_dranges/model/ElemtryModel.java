package com.ario.original2_dranges.model;

/**
 * Created by jaberALU on 20/01/2018.
 */

public class ElemtryModel {


  private String region;
  private String elementaryRegion;
  private String rule;

  public ElemtryModel(String region, String elementaryRegion, String rule) {
    this.region = region;
    this.elementaryRegion = elementaryRegion;
    this.rule = rule;
  }
  public String getRegion() {
    return region;
  }
  public String getElementaryRegion() {
    return elementaryRegion;
  }
  public String getRule() {
    return rule;
  }
  public void setRegion(String region) {
    this.region = region;
  }
  public void setElementaryRegion(String elementaryRegion) {
    this.elementaryRegion = elementaryRegion;
  }
  public void setRule(String rule) {
    this.rule = rule;
  }
}
