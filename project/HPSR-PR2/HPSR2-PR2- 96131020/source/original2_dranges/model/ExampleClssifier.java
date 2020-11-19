package com.ario.original2_dranges.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaberALU on 16/01/2018.
 */

public class ExampleClssifier {
  public List<RuleModel> MyExample() {
    List<RuleModel> ruleModels = new ArrayList<RuleModel>();
    RuleModel R1 = new RuleModel("R1","00","110");
    ruleModels.add(R1);
    RuleModel R2 = new RuleModel("R2","00","11");
    ruleModels.add(R2);
    RuleModel R3 = new RuleModel("R3","10","1");
    ruleModels.add(R3);
    RuleModel R4 = new RuleModel("R4","0","01");
    ruleModels.add(R4);
    RuleModel R5 = new RuleModel("R5","0","10");
    ruleModels.add(R5);
    RuleModel R6 = new RuleModel("R6","0","1");
    ruleModels.add(R6);
    RuleModel R7 = new RuleModel("R7","*","00");
    ruleModels.add(R7);
    return ruleModels;
  }
  public List<RuleModel> MyExample2() {
    List<RuleModel> ruleModels = new ArrayList<RuleModel>();
    RuleModel R1 = new RuleModel("R1","00","110");
    ruleModels.add(R1);
    RuleModel R2 = new RuleModel("R2","00","11");
    ruleModels.add(R2);
    RuleModel R3 = new RuleModel("R3","10","1");
    ruleModels.add(R3);
    RuleModel R4 = new RuleModel("R4","0","01");
    ruleModels.add(R4);
    RuleModel R5 = new RuleModel("R5","0","10");
    ruleModels.add(R5);
    RuleModel R6 = new RuleModel("R6","0","1");
    ruleModels.add(R6);
    RuleModel R7 = new RuleModel("R7","*","00");
    ruleModels.add(R7);
    RuleModel R8 = new RuleModel("R8","11","10");
    ruleModels.add(R8);
    RuleModel R9 = new RuleModel("R9","10","11");
    ruleModels.add(R9);
    RuleModel R10 = new RuleModel("R10","01","01");
    ruleModels.add(R10);
    RuleModel R11 = new RuleModel("R11","111","11");
    ruleModels.add(R11);
    RuleModel R12 = new RuleModel("R12","011","0");
    ruleModels.add(R12);
    RuleModel R13 = new RuleModel("R13","101","011");
    ruleModels.add(R13);
    RuleModel R14 = new RuleModel("R14","110","111");
    ruleModels.add(R14);
    RuleModel R15 = new RuleModel("R15","100","1");
    ruleModels.add(R15);
    RuleModel R16 = new RuleModel("R16","000","101");
    ruleModels.add(R16);
    RuleModel R17 = new RuleModel("R17","11","011");
    ruleModels.add(R17);
    RuleModel R18 = new RuleModel("R18","00","011");
    ruleModels.add(R18);
    RuleModel R19 = new RuleModel("R19","1","111");
    ruleModels.add(R19);
    RuleModel R20 = new RuleModel("R20","111","111");
    ruleModels.add(R20);
    return ruleModels;
  }

}
