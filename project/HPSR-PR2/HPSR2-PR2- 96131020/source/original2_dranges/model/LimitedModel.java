package com.ario.original2_dranges.model;

/**
 * Created by jaberALU on 31/12/2017.
 */


public class LimitedModel {

  private int dl = 0;
  private int du = 0;
  private int Sl = 0;
  private int Su = 0;
  private int okER = 0;

  public int getOkER() {
    return okER;
  }
  public void setOkER(int okER) {
    this.okER = okER;
  }
  public int getSl() {
    return Sl;
  }
  public int getSu() {
    return Su;
  }
  public int getDl() {
    return dl;
  }
  public int getDu() {
    return du;
  }
  public void setSl(int sl) {
    Sl = sl;
  }
  public void setSu(int su) {
    Su = su;
  }
  public void setDl(int dl) {
    this.dl = dl;
  }
  public void setDu(int du) {
    this.du = du;
  }

}

