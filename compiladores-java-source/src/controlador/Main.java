/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import modelo.Token;
import modelo.Tokenizer;

public class Main {
    public static void main(String[] args){
        String path="codigo.txt";
        try(FileReader fw= new FileReader(path)){
            BufferedReader br= new BufferedReader(fw);
            String line;
            while((line=br.readLine())!=null){
                Tokenizer tok= new Tokenizer(line.strip());
                while(tok.hasNextToken()){
                    Token token= tok.nextToken();
                    System.out.println(String.format("%s -> %s",token.getType(),token.getValue()));
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
    }
    }
}
