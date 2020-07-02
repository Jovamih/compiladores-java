/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
public class Symbols {
    private static  JSONObject jsonObject;
    public static boolean exists(String type,String value){
        if(jsonObject==null){
            readJSON();
        } 
        JSONArray types=(JSONArray)jsonObject.get(type);
        Iterator<String> iterator= types.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(value)) return true;
        }
        return false;
    }
    private static void readJSON(){
         try{
                JSONParser parser= new JSONParser();
                Object obj=parser.parse(new FileReader("tabla.json"));
                jsonObject=(JSONObject)obj;
           }catch(FileNotFoundException fn){
               System.out.println(fn.getMessage());
           }catch(IOException | ParseException e){
                System.out.println(e.getMessage());
           }
    }
}
