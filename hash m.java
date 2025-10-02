import java.util.Map;
import java.util.LinkedHashMap;

public class Storage {
    public static void main(String[] args) {
        Map<String, Integer> collection = new LinkedHashMap<>();
        
        collection.put("lamp", 4);
        collection.put("table", 1);
        
        System.out.println(collection.get("lamp"));
    }
}
