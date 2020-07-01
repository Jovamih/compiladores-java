/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
/**
 *
 * @author JOHAN
 */
public class Token {
    private String type;
    private String value;
    public Token(){
        this.type="";
        this.value="";
    }
    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
    
}
