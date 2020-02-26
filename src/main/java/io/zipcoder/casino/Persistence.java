package io.zipcoder.casino;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
public class Persistence {

    private static FileWriter file;

    public static void gatherData(){
        JSONObject obj = new JSONObject();
        obj.put("id", "gg");
        try{
            file = new FileWriter("/Users/ebeech/Downloads/casino.txt");
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Boolean save(AccountData ad){
        return null;
    }

    public void load(){

    }
}
