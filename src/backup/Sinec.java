package backup;

import java.util.HashMap;
import java.util.Map;

public class Sinec {
    public static void main(String[] args) {
        Map<String, Object> languages = new HashMap<>();
        languages.put("Java","17");
        languages.put("Python","4.1");
        languages.put("C#","7");
        languages.put("C","21");
        languages.put("C++","19");
        languages.put("Data Science","1");
        languages.put("Selenium","15");
        printLanguages(languages);
    }

    private static void printLanguages(Map<String, Object> languages) {
        for (Map.Entry<String, Object> entry: languages.entrySet()) {
            if (entry != null) {
                System.out.println("Key:"+entry.getKey()+", Value:"+entry.getValue());
            }
        }
    }
}
