/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_vr1;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author inber
 */
public class WriteFormula {

    private JTextArea tArea;
    private String formula;

    public WriteFormula(JTextArea tArea) {
        this.tArea = tArea;
    }

    public JTextArea gettArea() {
        return tArea;
    }

    public void settArea(JTextArea tArea) {
        this.tArea = tArea;
    }

    public void writeFormula(String texto) {
        String formula = tArea.getText();

        texto = formula + texto;
        tArea.setText(texto);

    }

    public ArrayList<Float> devNumeros() {
        ArrayList<Float> nums = new ArrayList();
        int countNums = 0;
        float num = 0;
        boolean cen = false;
        String numStr = "";

        for (int i = 0; i < tArea.getText().length(); i++) {
            if (!isSimbol("" + tArea.getText().charAt(i))) {
                numStr += tArea.getText().charAt(i);

            } else {
                String s = "" + tArea.getText().charAt(i);
                if (s.equals(" ")) {
                    if(!cen){
                    num = Integer.parseInt(numStr);
                    nums.add(num);
                    countNums++;
                    numStr = "";
                    num = 0;
                    cen = true;
                    }else{
                        cen = false;
                    }
                } else {
                    nums.add(tipeFormula());
                }
            }
        }

        return nums;
    }

    public float tipeFormula() {
        int i = 0;
        return i;
    }

    public void resolveFormula(ArrayList<Float> nums) {
        
        float num1 = nums.get(0);
        float num2 = nums.get(2);
        float sim = nums.get(1);
        
        match(num1, num2, (int) sim);
    }
    
    public void match(float num1, float num2, int sim){
        Calc c;
        switch (sim) {
            case 0: 
                c = new Calc(num1, num2);
                writeFormula(""+c.sum());
                break;
                
        }
        
    }

    public boolean isSimbol(String e) {
        boolean is = false;
        switch (e) {
            case "+":
                is = true;
                break;
            case "-":
                is = true;
                break;
            case "*":
                is = true;
                break;
            case "/":
                is = true;
                break;
            case " ":
                is = true;
                break;

        }
        return is;
    }
}
