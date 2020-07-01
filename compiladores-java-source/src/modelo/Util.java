/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author JOHAN
 */
public class Util {
    private static final Map<String,Vector> variables=new HashMap<String,Vector>();
    public static void saveVariable(String type,String value){
        if(!variables.containsKey(type)){
            variables.put(type,new Vector());
        }
        if(!variables.get(type).contains(value)){
            boolean add = variables.get(type).add(value);
        }
    }
    public static String getNameOfVariable(String type,String value){
        String name;
        if(variables.get(type).contains(value)){
            name=type.charAt(0)+String.valueOf(variables.get(type).indexOf(value)+1);
        }else name=value;
        return name;
    }
    private static String fillZero(String value,int len){
        int agregate=len-value.length();
        String ag="";
        for(int i=0;i<agregate;i++) ag+="0";
        return ag+value;
    }
}
