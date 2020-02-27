package io.zipcoder.casino;
import com.google.gson.GsonBuilder;
import io.zipcoder.casino.utilities.Display;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
//import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Persistence {

    private static FileWriter file;

    public static void gatherData(AccountData ad) {

        JSONObject obj = new JSONObject();
        obj.put("id", ad.getId());
        obj.put("wallet", ad.getWallet().chipsBalance);

        try {
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

    public static AccountData readData(Integer id) {


        Gson gson = new Gson();

        try (Reader reader = new FileReader("/Users/ebeech/Downloads/casino.txt")) {
            // JSONObject jsonObject = (JSONObject) parser.parse(reader);

            AccountData userData = gson.fromJson(reader, AccountData.class);
            if (userData.getId() != id) {
                Menu menu = new Menu();
                System.out.println("account not found");
                menu.displayMenu();

            } else {
                return userData;
            }


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }


}