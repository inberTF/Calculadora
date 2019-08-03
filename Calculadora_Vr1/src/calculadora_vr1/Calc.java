/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_vr1;

import java.util.ArrayList;

/**
 *
 * @author inber
 */
public class Calc {
    
    private float Num1 ;
    private float Num2 ;

    public Calc(float Num1, float Num2) {
        this.Num1 = Num1;
        this.Num2 = Num2;
    }

    public float getNum1() {
        return Num1;
    }

    public void setNum1(float Num1) {
        this.Num1 = Num1;
    }

    public float getNum2() {
        return Num2;
    }

    public void setNum2(float Num2) {
        this.Num2 = Num2;
    }

    

    
    public float sum(){
        float result = 0; 
        result = Num1 + Num2;
        return result;
    }
    public float res(){
        float result = 0; 
        result = Num1 - Num2;
        return result;
    }
    public float multi(){
        float result = 0; 
        result = Num1 * Num2;
        return result;
    }
    public float div(){
        float result = 0; 
        result = Num1 / Num2;
        return result;
    }
    
}
