package io.zipcoder.casino;
import com.google.gson.*;
//import com.google.gson.stream.JsonReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Persistence {

    private static FileWriter file;

    public static void gatherData(AccountData ad)  {
        try {
            FileWriter fw = new FileWriter("/Users/ebeech/Downloads/casino.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            JSONObject obj = new JSONObject();
            obj.put("id", ad.getId().toString());
            obj.put("wallet", ad.getWallet().chipsBalance.toString());
            bw.write(String.valueOf(obj));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/ebeech/Downloads/casino.txt", "rw");
//            long pos = randomAccessFile.length();
//            while (randomAccessFile.length() > 0) {
//                pos--;
//                randomAccessFile.seek(pos);
//                if (randomAccessFile.readByte() == ']') {
//                    randomAccessFile.seek(pos);
//                    break;
//                }
//            }
//            JSONObject obj = new JSONObject();
//            obj.put("id", ad.getId().toString());
//            obj.put("wallet", ad.getWallet().chipsBalance.toString());
//            String jsonElement = obj.toJSONString();
//            randomAccessFile.writeBytes("," + jsonElement + "]}");
//            randomAccessFile.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //{"user":[{"wallet":200,"id":5},{"wallet":200,"id":6},{"wallet":200,"id":4}]}

    }




        public static AccountData readData(Integer id) {
            AccountData account = new AccountData();
            ArrayList<JSONObject> json=new ArrayList<JSONObject>();
            JSONObject obj;
            // The name of the file to open.
            String fileName = "/Users/ebeech/Downloads/casino.txt";

            // This will reference one line at a time
            String line = null;

            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    obj = (JSONObject) new JSONParser().parse(line);
                    json.add(obj);
                    if(obj.get("id").equals(id.toString())){
                        account.loadId(id);
                        String s = (String) obj.get("wallet");
                        account.setChips(Integer.parseInt(s) );
                        return account;
                    }
//                    System.out.println((String)obj.get("id")+":"+
//                            (String)obj.get("wallet"));
                }

                // Always close files.
                bufferedReader.close();
            }catch(FileNotFoundException ex) {
                System.out.println("Unable to open file '" + fileName + "'");
            }
            catch(IOException ex) {
                System.out.println("Error reading file '" + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            } catch (ParseException e) {
                Menu menu = new Menu();
                System.out.println("account not found");
                menu.displayMenu();
            }
            return null;
        }
        }

