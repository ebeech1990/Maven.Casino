package io.zipcoder.casino;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import java.util.*;

public class Persistence {


    public static void gatherData(AccountData ad) {

        if(doesUserExist(ad)) {
           ArrayList <JSONObject> updatedList = updateExistingUser(ad);

            try {
                FileWriter fw = new FileWriter("/Users/ebeech/Downloads/casino.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                for (JSONObject obj : updatedList) {
                    bw.write(String.valueOf(obj));
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                FileWriter fw = new FileWriter("/Users/ebeech/Downloads/casino.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                JSONObject newUser = new JSONObject();
                newUser.put("id", ad.getId().toString());
                newUser.put("wallet", ad.getWallet().chipsBalance.toString());
                bw.write(String.valueOf(newUser));
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static Integer highestID(){
        ArrayList <JSONObject> dataOnFile = readFile();
        Integer currentHighest = Integer.MIN_VALUE;
        for(JSONObject obj : dataOnFile){
           String s = (String) obj.get("id");
            if(Integer.parseInt(s) > currentHighest) {
                currentHighest = Integer.parseInt(s);
            }
        }
        return currentHighest;
    }


    public static Boolean doesUserExist(AccountData ad){
        ArrayList <JSONObject> dataOnFile = readFile();
        for(JSONObject obj : dataOnFile){
            if(ad.getId().toString().equals(obj.get("id"))) {
                return true;
            }
        }
        return false;
    }

        public static ArrayList <JSONObject> updateExistingUser(AccountData ad){
            ArrayList <JSONObject> dataOnFile = readFile();
            for(JSONObject obj : dataOnFile){
                if(ad.getId().toString().equals(obj.get("id"))){

                    obj.replace("wallet", ad.getWallet().balance().toString());
                }
            }
            return dataOnFile;
        }



       public static ArrayList<JSONObject> readFile(){
           ArrayList<JSONObject> dataOnFile=new ArrayList<>();
           JSONObject individualAccount;
           String fileName = "/Users/ebeech/Downloads/casino.txt";
           String line = null;
           try {
               FileReader fileReader = new FileReader(fileName);
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               while((line = bufferedReader.readLine()) != null) {
                   individualAccount = (JSONObject) new JSONParser().parse(line);
                   dataOnFile.add(individualAccount);
               }
               bufferedReader.close();
           } catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + fileName + "'");
    } catch(IOException | ParseException ex) {
        System.out.println("Error reading file '" + fileName + "'");
    }
           return dataOnFile;
       }


        public static AccountData readData(Integer id) throws Exception {
            AccountData account = new AccountData();

                ArrayList <JSONObject> dataOnFile = readFile();
                for(JSONObject obj : dataOnFile){
                    if(obj.get("id").equals(id.toString())){
                        account.loadId(id);
                        String s = (String) obj.get("wallet");
                        account.setChips(Integer.parseInt(s) );
                        return account;
                    }
                }
            Menu menu = new Menu();
            System.out.println("account not found");
            menu.displayMenu();

            return null;
        }
}

