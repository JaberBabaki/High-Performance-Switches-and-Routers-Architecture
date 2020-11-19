package com.ario.original2_dranges;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ario.original2_dranges.model.CodeWordModel;
import com.ario.original2_dranges.model.ElemtryModel;
import com.ario.original2_dranges.model.ExampleClssifier;
import com.ario.original2_dranges.model.LimitedModel;
import com.ario.original2_dranges.model.RuleModel;
import com.ario.original2_dranges.model.TernaryModel;
import com.ario.original2_dranges.model.VestModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  List<RuleModel> ruleModel = new ArrayList<RuleModel>();
  ElemtryModel[][] Orginal2D = new ElemtryModel[16][16];
  LimitedModel[] limited = new LimitedModel[7];
  List<CodeWordModel> codeWord = new ArrayList<CodeWordModel>();
  List<CodeWordModel> codeWordOrginal = new ArrayList<CodeWordModel>();
  List<VestModel> vest = new ArrayList<VestModel>();
  List<TernaryModel> ternary = new ArrayList<TernaryModel>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ExampleClssifier examp = new ExampleClssifier();
    ruleModel = examp.MyExample();


    init();
    getLimted();
    setRule();
    setElemtryRegion();
    getVest();
    getCodeWord();
    getTernary();
    showOrginal2D(1);
    showOrginal2D(2);
    showOrginal2D(3);
    showVest();
    showCodeWord();
    showTernary();


  }

  public void init() {
    for (int i = 0; i < Orginal2D.length; i++) {
      for (int j = 0; j < Orginal2D.length; j++) {
        Orginal2D[i][j] = new ElemtryModel(null, null, " ");
      }
    }
  }

  public void getLimted() {
    for (int i = 0; i < ruleModel.size(); i++) {
      LimitedModel lim = new LimitedModel();
      String source = ruleModel.get(i).getSource();
      String dest = ruleModel.get(i).getDestedition();
      String sl = ruleModel.get(i).getSource();
      String su = ruleModel.get(i).getSource();
      if (!source.equals("*")) {
        int s = 4 - source.length();
        for (int j = 0; j < s; j++) {
          sl = sl + "0";
        }
        for (int j = 0; j < s; j++) {
          su = su + "1";
        }
      } else {
        sl = "0000";
        su = "1111";
      }
      lim.setSl(Integer.parseInt(sl, 2));
      lim.setSu(Integer.parseInt(su, 2));
      String dl = dest;
      String du = dest;
      if (!dest.equals("*")) {
        int d = 4 - dest.length();
        for (int j = 0; j < d; j++) {
          dl = dl + "0";
        }
        for (int j = 0; j < d; j++) {
          du = du + "1";
        }
      } else {
        sl = "0000";
        su = "1111";
      }
      lim.setDl(15 - (Integer.parseInt(du, 2)));
      lim.setDu(15 - (Integer.parseInt(dl, 2)));
      limited[i] = lim;
    }

  }

  public void setElemtryRegion() {
    int y = 0;
    for (int i = 0; i < limited.length; i++) {
      for (int j = 0; j < limited.length; j++) {
        if (i != j) {
          if (limited[i].getSl() >= limited[j].getSl() && limited[i].getSu() <= limited[j].getSu() &&
            limited[i].getDl() >= limited[j].getDl() && limited[i].getDu() <= limited[j].getDu()) {
            y++;
            setElemntry(limited[i], ("ER" + y));
            limited[i].setOkER(1);
            break;
          }
        }
      }
    }

    for (int i = 0; i < limited.length; i++) {
      for (int j = 0; j < limited.length; j++) {
        if (i != j && limited[i].getOkER() != 1) {
          if (limited[j].getSl() <= (limited[i].getSu() - limited[i].getSl()) && (limited[i].getSu() - limited[i].getSl()) < limited[j].getSu()
            && limited[j].getDl() <= (limited[i].getDu() - limited[i].getDl()) && (limited[i].getDu() - limited[i].getDl()) < limited[j].getDu()) {
            y++;
            Log.i("DEC", "" + i + " " + j);
            setElemntry(limited[i], ("ER" + y));
            limited[i].setOkER(1);
            break;
          }
        }
      }
    }

    for (int i = 0; i < limited.length; i++) {
      for (int j = 0; j < limited.length; j++) {
        if (i != j && limited[i].getOkER() != 1) {
          y++;
          setElemntry(limited[i], ("ER" + y));
          limited[i].setOkER(1);
        }
      }
    }

  }

  public void setElemntry(LimitedModel source, String ER) {
    for (int o = source.getSl(); o <= source.getSu(); o++) {
      for (int j = source.getDl(); j <= source.getDu(); j++) {
        if (Orginal2D[j][o].getElementaryRegion() == null) {
          Orginal2D[j][o].setElementaryRegion(ER);
        }
      }
    }

  }

  public void getCodeWord() {
    for (int i = 0; i < limited.length; i++) {
      for (int o = limited[i].getSl(); o <= limited[i].getSu(); o++) {
        for (int j = limited[i].getDl(); j <= limited[i].getDu(); j++) {
          if (!Orginal2D[j][o].getRule().equals("")) {
            CodeWordModel code = new CodeWordModel();
            String[] str = Orginal2D[j][o].getRule().split(",");
            for (int f = 0; f < str.length; f++) {
              if (f != 0) {
                code.setER(Orginal2D[j][o].getElementaryRegion());
                int p = Integer.parseInt(str[f].substring(1, str[f].length()));
                code.codeWord[p - 1] = "1";
              }
            }
            codeWord.add(code);
          }
        }
      }
    }

  }

  public void getVest() {
    for (int i = 0; i < limited.length; i++) {
      for (int j = 0; j < limited.length; j++) {
        if (i != j) {
          if (limited[i].getSl() >= limited[j].getSl() && limited[i].getSu() <= limited[j].getSu() &&
            limited[i].getDl() >= limited[j].getDl() && limited[i].getDu() <= limited[j].getDu()) {
            VestModel ves = new VestModel();
            ves.setRule(ruleModel.get(i).getName());
            ves.setNumberER(Orginal2D[limited[i].getSl()][limited[i].getSu()].getElementaryRegion() + "," + ves.getNumberER());
            vest.add(ves);
          }
        }
      }
    }

  }

  public void getTernary() {
    for (int i = 0; i < vest.size(); i++) {
      String[] v = vest.get(i).getNumberER().split(",");
      List<String[]> codeWord = new ArrayList<String[]>();
      for (int j = 0; j < v.length; j++) {
        String[] code = searchInCodeWord(v[j]);
        codeWord.add(code);
      }
      String ternarStr=getTernaryForOne(codeWord);
      TernaryModel ternar=new TernaryModel();
      ternar.setRule(vest.get(i).getRule());
      ternar.setTernary(ternarStr);
      ternary.add(ternar);
    }
  }

  public String[] searchInCodeWord(String er) {
    for (int i = 0; i < codeWordOrginal.size(); i++) {
      if (er.equals(codeWordOrginal.get(i).getER())) {
        return codeWordOrginal.get(i).codeWord;
      }
    }
    return null;
  }

  public String getTernaryForOne(List<String[]> codeWord) {
    String ternary = "";
    for (int i = 0; i < codeWord.size(); i++) {
      for (int j = 0; j < codeWord.get(i).length; j++) {
        int y = 1;
        for (int f = 0; f < codeWord.size(); f++) {
          if (i != codeWord.size() - 1) {
            if (codeWord.get(i)[j] != codeWord.get(i + 1)[f]) {
              y = 0;
            }
          }
        }
        if (y == 1) {
          ternary = ternary + "" + codeWord.get(i)[j];
        } else {
          ternary = ternary + "*";
        }

      }
    }
    return ternary;
  }

  public void setRule() {
    int m = 0;
    for (int i = 0; i < ruleModel.size(); i++) {
      for (int o = limited[i].getSl(); o <= limited[i].getSu(); o++) {
        for (int j = limited[i].getDl(); j <= limited[i].getDu(); j++) {
          Orginal2D[j][o].setRule(Orginal2D[j][o].getRule() + "," + ruleModel.get(i).getName());
          if (Orginal2D[j][o].getRegion() == null) {
            Orginal2D[j][o].setRegion("r" + m);
            m++;
          }
          //}
        }
      }

    }
  }

  public void showOrginal2D(int m) {
    for (int i = 0; i < Orginal2D.length; i++) {
      for (int j = 0; j < Orginal2D.length; j++) {
        String s = "";
        if (Orginal2D[i][j].getRule().length() < 10) {
          int gh = 10 - Orginal2D[i][j].getRule().length();
          for (int o = 0; o < gh; o++) {
           s=s+" ";
          }
          Orginal2D[i][j].setRule(Orginal2D[i][j].getRule()+s);
        }
      }
    }

    if (m == 1) {
      for (int i = 0; i < Orginal2D.length; i++) {
        String s = "";
        for (int j = 0; j < Orginal2D.length; j++) {
          s = s + " " + Orginal2D[i][j].getRule() + " || ";
        }
        Log.i("DEC", "" + s);
      }
    } else if (m == 2) {
      for (int i = 0; i < Orginal2D.length; i++) {
        String s = "";
        for (int j = 0; j < Orginal2D.length; j++) {
          s = s + " " + Orginal2D[i][j].getRegion() + " || ";
        }
        Log.i("DEC", "" + s);
      }
    } else if (m == 3) {
      for (int i = 0; i < Orginal2D.length; i++) {
        String s = "";
        for (int j = 0; j < Orginal2D.length; j++) {
          s = s + " " + Orginal2D[i][j].getElementaryRegion() + " || ";
        }
        Log.i("DEC", "" + s);
      }
    }

  }

  public void showVest() {
    for (int i = 0; i < vest.size(); i++) {
      String s = "";
      /*for (int j = (codeWordOrginal.get(i).codeWord.length - 1); j >= 0; j--) {
        s = s + " " + codeWordOrginal.get(i).codeWord[j];
      }*/
      Log.i("DEC", "" + vest.get(i).getRule() + " " + vest.get(i).getNumberER());
    }
  }

  public void showCodeWord() {
    for (int i = 0; i < codeWordOrginal.size(); i++) {
      String s = "";
      for (int j = (codeWordOrginal.get(i).codeWord.length - 1); j >= 0; j--) {
        s = s + " " + codeWordOrginal.get(i).codeWord[j];
      }
      Log.i("DEC", "" +codeWordOrginal.get(i).getER() + " " +s );
    }
  }

  public void showTernary() {
    for (int i = 0; i < ternary.size(); i++) {
      Log.i("DEC", "" + ternary.get(i).getRule() + " " + ternary.get(i).getTernary());
    }
  }
}




