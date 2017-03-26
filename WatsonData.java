/**
 * Created by hshack on 3/25/17.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;

public class WatsonData {
    public static void main(String[] args) {

    }
    public static ArrayList<String> getData(File in) {
        String currentDir = System.getProperty("user.dir");
        JSONParser parser = new JSONParser();
        ArrayList<String> words = new ArrayList<String>();
        try {
            Object all = parser.parse(new FileReader(
                    currentDir + File.separator + "src/data.json"));
            JSONArray arr = (JSONArray) all;
            JSONObject jsonObject = (JSONObject) arr.get(0);
            JSONArray list = (JSONArray) jsonObject.get("classes");
            for(Object obj : list) {
                JSONObject jsonObj = (JSONObject) obj;
                if((Double) jsonObj.get("score") >= 0.9) {
                    words.add((String) jsonObj.get("class"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }
}
