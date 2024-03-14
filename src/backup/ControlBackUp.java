package backup;

import java.util.ArrayList;
import java.util.List;

public class ControlBackUp {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(List.of("Guava", "Grapes", "Papaya", "Banana"));
        List<String> fruits1 = new ArrayList<>(List.of("Apple", "Watermelon", "Papaya", "Banana"));
        List<String> commonFruits = new ArrayList<>(fruits);
        commonFruits.retainAll(fruits1);
        /*System.out.println(commonFruits);
        System.out.println(fruits1);
        System.out.println(fruits);*/
        getOldExcludingNewNodeList(fruits, commonFruits);
        getNewExcludingOldNodeList(fruits1, commonFruits);
    }
    public static List<String> getOldExcludingNewNodeList(List<String> oldFruits, List<String> commonFruits) {
        List<String> oldExcludingNewList = new ArrayList<>(oldFruits);
        oldExcludingNewList.removeAll(commonFruits);
        System.out.println(oldExcludingNewList);
        return oldExcludingNewList;
    }
    public static List<String> getNewExcludingOldNodeList(List<String> newFruits, List<String> commonFruits) {
      List<String> newExcludingOldList = new ArrayList<>(newFruits);
      newExcludingOldList.removeAll(commonFruits);
      System.out.println(newExcludingOldList);
      return newExcludingOldList;
    }
}
