package jobs;

import java.util.ArrayList;
import java.util.List;

public class GlobalJob {

    public static void main(String[] args) {

        String str = "Sinecnms";
        byte[] arr = str.getBytes();
        System.out.println(arr);
        String str2 = new String(arr);
        System.out.println(str2);
        // C:0-O:11, C:0-O:3, C:0-O:4, C:0-O:10, C:0-O:5, C:0-O:20, C:0-O:6, C:0-O:1, C:0-O:2, C:0-O:7, C:0-O:8, C:0-O:9, C:0-O:19, C:0-O:18,
        //C:0-O:17, C:0-O:16, C:0-O:15, C:0-O:14, C:0-O:13, C:0-O:12
        List<String> oldNodeList = List.of("C:0-O:3"," C:0-O:11", "C:0-O:4", "C:0-O:5", "C:0-O:20", "C:0-O:6", "C:0-O:1",
               " C:0-O:2", "C:0-O:7", "C:0-O:8", "C:0-O:9", "C:0-O:19", "C:0-O:18"," C:0-O:17", "C:0-O:16", "C:0-O:15", "C:0-O:14",
                "C:0-O:13", "C:0-O:12");
        List<String> policyNodeList = List.of("C:0-O:3"," C:0-O:11", "C:0-O:4", "C:0-O:10", "C:0-O:5", "C:0-O:20", "C:0-O:6", "C:0-O:1",
                " C:0-O:2", "C:0-O:7", "C:0-O:8", "C:0-O:9", "C:0-O:19"," C:0-O:17", "C:0-O:16", "C:0-O:15", "C:0-O:14",
                "C:0-O:13", "C:0-O:12");
        List<String> commonList = getCommonList(oldNodeList, policyNodeList);
        System.out.println("CommonList "+commonList);
        List<String> unScheduleJobInNodes = getOldExcludingNewNodeList(oldNodeList, commonList);
        System.out.println("oldExcludingNewNodeList "+unScheduleJobInNodes);
        List<String> createJobInNodes = getNewExcludingOldNodeList(policyNodeList, commonList);
        System.out.println("newExcludingOldNodeList "+createJobInNodes);
    }

    private static List<String> getCommonList(List<String> globalNodeList, List<String> oldNodeList) {
        List<String> commonList = new ArrayList<>(globalNodeList);
        commonList.retainAll(oldNodeList);
        return commonList;
    }

    private static List<String> getOldExcludingNewNodeList(List<String> oldNodeList, List<String> commonList) {
       List<String> oldExcludingNewNodeList = new ArrayList<>(oldNodeList);
       oldExcludingNewNodeList.removeAll(commonList);
       return oldExcludingNewNodeList;
    }
    private static List<String> getNewExcludingOldNodeList(List<String> newNodeList, List<String> commonList) {
        List<String> newExcludingOldList = new ArrayList<>(newNodeList);
        newExcludingOldList.removeAll(commonList);
        return newExcludingOldList;
    }
}
