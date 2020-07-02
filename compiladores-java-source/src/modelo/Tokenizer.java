/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Tokenizer{
    private int currentIndex;
    private final String cadena;
    public Tokenizer(String cadena){
        this.cadena=cadena;
    }
    public Token nextToken() throws Exception{
        Token token = new Token();
        char character=this.cadena.charAt(this.currentIndex);
        if(Character.isLetter(character)){
            while(Character.isLetter(character) || Character.isDigit(character)){
                token.setValue(token.getValue()+character);
                if(cadena.length()>this.currentIndex) this.currentIndex++;
                else character='$';
                if(this.cadena.length()>this.currentIndex)
                        character=this.cadena.charAt(this.currentIndex);
                else break;
            }
            if(Symbols.exists("PR",token.getValue())) token.setType("PR");
            else token.setType("ID");
        }
        else if(Character.isDigit(character)){
            while(Character.isDigit(character)){
                token.setValue(token.getValue()+character);
                this.currentIndex++;
                if (this.cadena.length()>this.currentIndex){   
                    character=this.cadena.charAt(this.currentIndex);}
                else break;
            }
            token.setType("NUM");
        }else if(Symbols.exists("OP",String.valueOf(character))){
                token.setType("OP");
                token.setValue(token.getValue()+character);
                this.currentIndex++;
                char nextChar= this.cadena.length()>this.currentIndex ? this.cadena.charAt(this.currentIndex):'$';
                String doubleOperator= String.valueOf(character)+String.valueOf(nextChar);
                if(Symbols.exists("OP",doubleOperator)){
                    token.setValue(token.getValue()+character);
                    this.currentIndex++;
             }
            
            }else throw new Exception("No se reconoce el caracter: "+String.valueOf(character));
        //para casos en los que se necesita reconocer una cadena
        /* 
        if("\"'".indexOf(character)!=-1){
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
            
        }
        */
        
        return token;
    
    }
    public boolean hasNextToken(){
        lineCleaner();
        return this.cadena.length()>this.currentIndex;
    }
    private void lineCleaner(){
        //limpia espacios
        if(cadena.length()>this.currentIndex){
            while(this.cadena.charAt(currentIndex)==' ') {
                if(cadena.length()>this.currentIndex) currentIndex++;
                else return;
            }
            //limpia comentarios de una linea
            if(cadena.charAt(currentIndex)=='/'&& cadena.charAt(currentIndex+1)=='/'){
                currentIndex=cadena.length();
            }
            /*char nextChar=0;
            while(cadena.length()>this.currentIndex){
                if(cadena.charAt(currentIndex)==' ') currentIndex++;
                else if(cadena.charAt(currentIndex)=='/' && nextChar=='/')
            } **/
        /*
        //codigo valido solo si se tiene una sola linea de texto ya que este comentario es multilinea
        if(cadena.charAt(currentIndex)=='/'&& cadena.charAt(currentIndex+1)=='*'){
            currentIndex+=2;
            while(!(cadena.charAt(currentIndex)=='*'&& cadena.charAt(currentIndex+1)=='/')){
                currentIndex++;
            }
            currentIndex+=2;
        }
*/
    }
    }
  

}