package jobs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainJob {

    public static Long getExecutionId(final Long startTime, final String triggerType) {
        Long executionId = 0L;
        // Long updatedStartTime = 60000 * (startTime / 60000);
        Long updatedStartTime = startTime;
        executionId = (updatedStartTime * 10) + 1;
        // executionId = (updatedStartTime * 10);
        return executionId;
    }

    public static void printSysInfo() {
        final String jobId = "1060,1063,1067,1068,1069,1002,1004,1061,1006,1003,1064,1001,1007,1008,1005,1031,1062,1072,1024,1079,1081,1082," +
                "1065,1066,1070,1076,1025,1078,1071,1073,1026,1074,1075,1030,1077,1027,1083,1028,1080,1029,1085,1013,1084,1032,1033,1086,1091," +
                "1034,1092,1096,1009,1087,1035,1036,1037,1088,1089,1090,1097,1098,1100,1038,1118,1093,1094,1095,1101,1104,1039,1099,1102,1103," +
                "1105,1111,1011,1106,1109,1110,1041,1042,1107,1108,1112,1043,1044,1045,1113,1115,1047,1114,1116,1048,1117,1119,1050,1052,1120," +
                "1122,1124,1125,1127,1019,1121,1123,1053,1126,1128,1140,1129,1134,1058,1136,1142,1130,1138,1135,1143,1145,1132,1146,1010,1012," +
                "1131,1015,1133,1137,1154,1144,1148,1158,1147,1139,1141,1149,1150,1152,1156,1161,1155,1160,1157,1159,1162,1168,1151,1163,1165," +
                "1167,1164,1166,1153,1169,1040,1057,1046,1049,1056,1014,1022,1016,1017,1018,1020,1021,1023,1051,1054,1055";
        String[] jobIds = jobId.split(",");
        List<String> histJobIds = Arrays.asList(jobIds);
        final String myJobId = "1148";
        for (int i = 0; i < histJobIds.size(); i++) {

            if (histJobIds.get(i).equals(myJobId)) {
                System.out.println("Index and Value " + i + " " + histJobIds.get(i));
            }
        }
        System.out.println("Length = " + jobId.length());
        StringBuffer finalResult = new StringBuffer();
        InputStreamReader inStr = null;
        BufferedReader bufferedReader = null;
        ProcessBuilder builder = null;
        InputStream inputStream = null;
        Process process = null;
        try {
            final int cpuClockIndex = 1;
            final int cpuIndex = 2;
            final int cpuCoreIndex = 3;
            final int cpuLogicIndex = 4;

            final String[] command = {"CMD", "/C", "wmic cpu get Name,MaxClockSpeed,NumberOfCores,NumberOfLogicalProcessors /format:csv"};
            builder = new ProcessBuilder(command);
            process = builder.start();
            inputStream = process.getInputStream();
            inStr = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inStr);
            String currLine;
            int count = 0;
            while ((currLine = bufferedReader.readLine()) != null) {
                if (currLine.length() > 0 && count > 2) {
                    if (finalResult.length() > 0) {
                        finalResult.append(";");
                    }
                    final String[] unpData = currLine.split(",");
                    final String cpuInfo = unpData[cpuIndex] + ", ";
                    final String cpus = unpData[cpuClockIndex] + " Mhz, ";
                    final String cpuCore = unpData[cpuCoreIndex] + " Cores(s),";
                    final String cpuNp = unpData[cpuLogicIndex] + " Logical Processors(s)";
                    finalResult.append(cpuInfo);
                    finalResult.append(cpus);
                    finalResult.append(cpuCore);
                    finalResult.append(cpuNp);
                }
                count++;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        System.out.println(finalResult);
    }

    public static void main(String[] args) throws InterruptedException {

        Map<String, Object> value = getValue(List.of("x1","x2"));
        String exeStatus = (String) value.get("JOB_EXE_STATUS");
        boolean b = checkboolValue(exeStatus);
        System.out.println(b);
        String str = null;
        try {
            if (str.equals(Config.VALID.toString())) {
                System.out.println(Config.VALID);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        printSysInfo();
        final String regex = "^(?>[^\"\\'?;*])+$";
        String val = "abc\\";
        if (val.matches(regex)) {
            System.out.println("Invalid value");
        }
        List<String> allStat = new ArrayList<>();
        allStat.add("true");
        allStat.add("true");
        allStat.add(null);
        allStat.add(null);
        int occurrences = Collections.frequency(allStat, "true");
        if (occurrences >= 1) {
            System.out.println("Proceed");
        }

       /* long minExeId = 16887150000000l;
        long exeId = 16900110000000l;
        if(exeId > minExeId) {
            System.out.println("Greater ");
        }
        List<String> op1 = new ArrayList<>();
        op1.add("C1");
        List<String> op2 = new ArrayList<>();
        op2.add("C1");

        op1.retainAll(op2);
        System.out.println(op1);
        System.out.println(op2);

        List<String> op3 = new ArrayList<>();
        op3.add("C2");
        op3.add("C4");
        op3.add("C5");
        List<String> op4 = new ArrayList<>();
        op4.add("C2");

        op4.removeAll(op3);

        System.out.println("Op3: "+op3);
        System.out.println("Op4: "+op4);*/

        long sp3CurrentTimeStamp = getSp3CurrentTimeStamp();
        long twoZeroTimeStamp = getTwoZeroTimeStamp();
        if (sp3CurrentTimeStamp == twoZeroTimeStamp) {
            System.out.println("Equals");
        } else {
            System.out.println("SP3: " + sp3CurrentTimeStamp);
            System.out.println("2.0: " + twoZeroTimeStamp);
        }
      /*  String str = null;
        //executeProcess(null, str);
        String value = getValue(str);
        System.out.println(value);*/
    }

    private static boolean checkboolValue(String exeStatus) {
        return null == exeStatus || exeStatus.equals("16") || exeStatus.equals("26");
    }

    private static Map<String, Object> getValue(List<String> operIds) {
        Map<String, Boolean> response = new HashMap<>();
        StringBuilder commaSeparatedOperIds = new StringBuilder();
        commaSeparatedOperIds.append("{");
        for (int index = 0; index < operIds.size() - 1; index++) {
            // commaSeparatedOperIds.append("'");
            commaSeparatedOperIds.append(operIds.get(index));
            commaSeparatedOperIds.append(",");
            // commaSeparatedOperIds.append("',");
        }

        if (operIds.size() > 0) {
            // commaSeparatedOperIds.append("'");
            commaSeparatedOperIds.append(operIds.get(operIds.size() - 1));
            // commaSeparatedOperIds.append("'");
        }
        // else {
        // commaSeparatedOperIds.append("''");
        // }
        commaSeparatedOperIds.append("}");
        System.out.println("values " +commaSeparatedOperIds);
        return null;
    }

    private static long getTwoZeroTimeStamp() {
        Long currentTimeStamp = 16902694770000l;
        currentTimeStamp = (currentTimeStamp * 10);
        return currentTimeStamp;
    }

    private static long getSp3CurrentTimeStamp() {
        //1688657018877
        Long currentTimeStamp = 1688657018877l;
        currentTimeStamp = 60000 * (currentTimeStamp / 60000);
        currentTimeStamp = currentTimeStamp * 10;
        return currentTimeStamp;
    }

    private static boolean executeProcess(final Process process, String str) throws InterruptedException {
        boolean exitStatus = true;
        String value1 = null;
        if (str == null) {

        }
        try {
            int i = 0;
            exitStatus = getInfo1(180, TimeUnit.SECONDS);
            if (!exitStatus) {
                for (; i <= 2; i++) {
                    exitStatus = executeProcess(process, str);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception at executeProcess " + e);
        }
        return exitStatus;
    }

    private static boolean getInfo1(int i, TimeUnit timeUnit) {
        return false;
    }
}
