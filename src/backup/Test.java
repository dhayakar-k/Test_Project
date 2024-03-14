package backup;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test {

    static List<String> getCommonList(final List<String> oldList,
                                      final List<String> newList) {
        oldList.retainAll(newList);
        return oldList;
    }

    public static void main(String[] args) {
        String str = "[*?\\\'\";]";
        Pattern special = Pattern.compile(str);
        if (special.matcher("umcsuperadmin-03/20/2023 11:37:31").find()) {
            System.out.println("matching");
        }
        List<String> oldNodeList = List.of("C1","C2","C3");
        final List<String> oldList = new java.util.ArrayList<>(List.of("C1", "C2", "C3","C4"));
        final List<String> globalNodeList = new java.util.ArrayList<>(List.of("C1", "C2", "C3","C4"));
        final List<String> newList = List.of("C2","C3");
        final List<String> commonList = getCommonList(oldList, newList);
        System.out.println(commonList);

        final List<String> unScheduleJobInNodes = getOldExcludingNewNodeList(oldNodeList, commonList);
        System.out.println(unScheduleJobInNodes);

        final List<String> createJobsInNodes = getNewExcludingNewNodeList(globalNodeList, commonList);
        System.out.println(createJobsInNodes);

    }

    private static List<String> getNewExcludingNewNodeList(final List<String> newNodeList, final List<String> commonList) {
        List<String> newExcludingOldNodeList = new ArrayList<>(newNodeList);
        newExcludingOldNodeList.removeAll(commonList);
        return newExcludingOldNodeList;
    }

    private static List<String> getOldExcludingNewNodeList(final List<String> oldList, final List<String> newList) {
        List<String> oldExcludingNewNodeList = new ArrayList<>(oldList);
        oldExcludingNewNodeList.removeAll(newList);
        return oldExcludingNewNodeList;
    }
}
