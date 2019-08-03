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
    private float simb = 0;

    public WriteFormula(JTextArea tArea) {
        this.tArea = tArea;

    }

    public void cleanTArea() {
        tArea.setText("");
    }

    public void re() {
        try{
        String t = tArea.getText();
        String t2 = t.substring(t.length()-1);
        tArea.setText(t.replace(t2, ""));
        }
        catch (StringIndexOutOfBoundsException ex){
            System.out.println("No le des maaaas");
        }
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
                    if (!cen) {
                        num = Float.parseFloat(numStr);
                        nums.add(num);
                        countNums++;
                        numStr = "";
                        num = 0;
                        cen = true;
                    } else {
                        cen = false;
                    }
                } else {
                    nums.add(simb);
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
        /*  float num1 = nums.get(0);
        float num2 = nums.get(2);
        float sim = nums.get(1);
        
        match(num1, num2, (int) sim);
         */
        float result = 0;

        while (nums.size() > 1) {
            for (int i = 0; i < nums.size(); i++) {
                float num1 = nums.get(0);
                float num2 = nums.get(2);
                float sim = nums.get(1);
                nums.remove(0);
                nums.remove(0);
                nums.remove(0);
                result = match(num1, num2, (int) sim);
                nums.add(0, result);

            }
        }
        writeFormula("" + result);
    }

    public float match(float num1, float num2, int sim) {
        Calc c = new Calc(num1, num2);
        float result = 0;
        switch (sim) {
            case 0:
                result = c.sum();
                break;
            case 1:
                result = c.res();
                break;
            case 2:
                result = c.multi();
                break;
            case 3:
                result = c.div();
                break;

        }
        return result;

    }

    public boolean isSimbol(String e) {
        boolean is = false;
        switch (e) {
            case "+":
                is = true;
                simb = 0;
                break;
            case "-":
                is = true;
                simb = 1;
                break;
            case "*":
                is = true;
                simb = 2;
                break;
            case "/":
                is = true;
                simb = 3;
                break;
            case " ":
                is = true;
                break;

        }
        return is;
    }
}
