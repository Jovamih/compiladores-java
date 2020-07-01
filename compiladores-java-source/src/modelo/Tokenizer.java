/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Tokenizer {
    private int currentIndex;
    private int currentLine;
    private String cadena;
    private String ncad;
    private boolean hasVariable;
    private boolean hasMacro;
    private String lastType;
    private String lastMacro;
    public Tokenizer(String cadena){
        this.cadena=cadena;
    }
    public Token nextToken(){
        Token token = new Token();
        char character=this.cadena.charAt(this.currentIndex);
        if(Character.isLetter(character)){
            while(Character.isLetter(character) && Character.isDigit(character)){
                token.setValue(token.getValue()+character);
                this.currentIndex++;
                if(this.cadena.length()>this.currentIndex)
                        character=this.cadena.charAt(this.currentIndex);
                else break;
            }
            String subtype=this.searchToken(token.getValue(),"PR");
            token.setType(subtype!=null ?subtype:"ID");
      
        }
        else if("\"'".indexOf(character)!=-1){
            token.setValue(token.getValue()+character);
            this.currentIndex++;
            character=this.cadena.charAt(this.currentIndex);
            while("\"'".indexOf(character)==-1){
                token.setValue(token.getValue()+character);
                this.currentIndex++;
                character=this.cadena.charAt(this.currentIndex);
            }
            token.setValue(token.getValue()+character);
            this.currentIndex++;
            token.setType("CAD");
            
        }else if(Character.isDigit(character)){
            while(Character.isDigit(character)){
                token.setValue(token.getValue()+character);
                this.currentIndex++;
                if (this.cadena.length()>this.currentIndex)
                    character=this.cadena.charAt(this.currentIndex);
                else break;
            }
            token.setType("NUM");
        }else{
            String subtype=null;
            if((subtype=this.searchToken(String.valueOf(character),"OP"))!=null){
                token.setType(subtype);
                token.setValue(token.getValue()+character);
                this.currentIndex++;
                char nextChar= this.cadena.length()>this.currentIndex ? this.cadena.charAt(this.currentIndex):0;
                String doubleOperator= String.valueOf(character)+String.valueOf(nextChar);
               if((subtype=this.searchToken(doubleOperator,"OP"))!=null){
                    token.setValue(token.getValue()+character);
                    this.currentIndex++;
                    token.setType(subtype);
             }
            }
            //special en c++
            else if(character=='#'){
                token.setValue(token.getValue()+character);
                this.currentIndex++;
                while(this.cadena.charAt(this.currentIndex)==' ') this.currentIndex++;
                if(Character.isLetter(this.cadena.charAt(currentIndex)) || this.cadena.charAt(currentIndex)=='_'){
                    while(Character.isLetter(this.cadena.charAt(currentIndex)) || this.cadena.charAt(currentIndex)=='_'){
                        character=this.cadena.charAt(currentIndex);
                        token.setValue(token.getValue()+character);
                        this.currentIndex++;
                        if(this.cadena.length()>currentIndex) character=this.cadena.charAt(currentIndex);
                        else break;
                    }
                   // if(token.getValue().toLowerCase())
                   //lo suspedemos para mas rato
                }else System.out.println("Error lexico No se reconoce");
            }else System.out.println("Error lexico no s reconoce");
            
            
            
            
            
            
            
        }
        
        return token;
    
    }
    private String searchToken(String value, String type){
            return null;
    }
}
