/**
 * Created by hshack on 3/25/17.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.commons.lang3.StringUtils;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;



public class Search {
    static ArrayList<String> foods;
    public static void main(String[] args) {
        ArrayList<String> list = findClosestMatch("");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static void createList() {
        String currentDir = System.getProperty("user.dir");
        JSONParser parser = new JSONParser();
        foods = new ArrayList<String>();
        try {

            Object all = parser.parse(new FileReader(
                    currentDir + File.separator + "src/data.json"));
            JSONArray arr = (JSONArray) all;
            for(Object obj : arr) {
                JSONObject jsonObject = (JSONObject) obj;
                foods.add((String) jsonObject.get("Short_Description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> findClosestMatch(String in) {
        createList();
        ArrayList<Integer> distances = new ArrayList<Integer>();
        ArrayList<String> output = new ArrayList<String>();
        for(String name : foods) {
            distances.add(StringUtils.getLevenshteinDistance(in.toUpperCase(),name));
        }
        for(int j = 0; j < 8; j++) {
            int shortestIndex = 0;
            int shortestDistance = distances.get(0);
            for (int i = 0; i < distances.size(); i++) {
                if (distances.get(i) < shortestDistance) {
                    shortestIndex = i;
                    shortestDistance = distances.get(i);
                }
            }
            output.add(foods.get(shortestIndex));
            foods.remove(shortestIndex);
            distances.remove(shortestIndex);
        }
        return output;
    }
}
