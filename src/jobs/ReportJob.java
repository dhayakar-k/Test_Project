package jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportJob {
    public static void main(String[] args) {
        List<String> globalNodeList = List.of(
                "C:0-O:3", "C:0-O:11", "C:0-O:4", "C:0-O:10",
                "C:0-O:5", "C:0-O:20", "C:0-O:6", "C:0-O:1", "C:0-O:2", "C:0-O:7", "C:0-O:8", "C:0-O:9", "C:0-O:19", "C:0-O:18", "C:0-O:17",
                "C:0-O:16", "C:0-O:15", "C:0-O:14", "C:0-O:13"
        );
        List<String> policyOprList = List.of("C:0-O:3", "C:0-O:11", "C:0-O:4", "C:0-O:10", "C:0-O:5", "C:0-O:20", "C:0-O:6", "C:0-O:1",
                "C:0-O:2",
                "C:0-O:7", "C:0-O:8", "C:0-O:9", "C:0-O:19", "C:0-O:18",
                "C:0-O:17", "C:0-O:16", "C:0-O:15", "C:0-O:14", "C:0-O:13", "C:0-O:12");
        List<String> commonList = getCommonList(policyOprList, globalNodeList);
        System.out.println("CommonList: "+commonList);
        List<String> unScheduleJobInNodes = getOldExcludingNewNodeList(globalNodeList, commonList);
        System.out.println("unScheduleJobInNodes: "+unScheduleJobInNodes);
        List<String> createJobInNodes = getNewExcludingOldNodeList(policyOprList, commonList);
        System.out.println("createJobInNodes: "+createJobInNodes);
        Map<String, Object> customHeaders = new HashMap<>();
        customHeaders.put("edit_unschedule", unScheduleJobInNodes);
        customHeaders.put("edit_create", createJobInNodes);
        if (customHeaders != null && customHeaders.size() > 0) {
            customHeaders.forEach((key, value) -> {
                String val1 = String.valueOf(value);
                if (key != null && key.equals("edit_unschedule")) {
                    if (val1 != null && !val1.equals("[]")) {
                        System.out.println("Checking edit_unschedule_job_in_node_list ");
                        System.out.println("Appending edit1 info");
                    }
                } else if (key != null && key.equals("edit_create")) {
                    if (val1 != null && !val1.equals("[]")) {
                        System.out.println("Checking edit_create_job_in_node_list ");
                        System.out.println("Appending edit2 info");
                    }
                }
            });
        }

    }

    private static List<String> getCommonList(List<String> globalNodeList, List<String> oldOprList) {
        List<String> commonList = new ArrayList<>(globalNodeList);
        commonList.retainAll(oldOprList);
        return commonList;
    }
    private static List<String> getOldExcludingNewNodeList(final List<String> oldOperationList,
                                                    final List<String> commonList) {
        List<String> oldExcludingNewList = new ArrayList<>(oldOperationList);
        oldExcludingNewList.removeAll(commonList);
        return oldExcludingNewList;
    }
    private static List<String> getNewExcludingOldNodeList(final List<String> newNodesList,
                                                    final List<String> commonList) {
        List<String> newExcludingOldList = new ArrayList<>(newNodesList);
        newExcludingOldList.removeAll(commonList);
        return newExcludingOldList;
    }
}
