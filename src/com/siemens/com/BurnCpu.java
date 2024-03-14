package com.siemens.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BurnCpu {

    private static Map<String, Integer> getMapValues() {
        final Map<String, Integer> hashMap = new HashMap<>();
        getDBData().forEach(data-> {
            if(data!= null && !data.isEmpty()) {
                hashMap.put((String) data.get("node_id"), (Integer) data.get("status"));
            }
        });
        return hashMap;
    }

    private static List<Map<String, Object>> getDBData() {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", 5500);
        hashMap.put("node_id", "C:0");
        data.add(hashMap);
        Map<String, Object> hashMap1 = new HashMap<>();
        hashMap1.put("status", 5100);
        hashMap1.put("node_id", "C:0-O:2");
        data.add(hashMap1);
        return data;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String compName =  "SCALANCE X-300 EEC";
        String[] compArray = compName.trim().split(" ");
        if(compArray.length > 2) {
            System.out.println(compArray[0]+ compArray[1]+compArray[2]);
        }
        compName = compName.substring(0, compName.lastIndexOf(" "));
        System.out.println(compName);

           /* getMapValues().forEach((key, value)-> {
                System.out.println(key+" "+value);
            });*/


       /* List<String> list = List.of("a","b","c");
        StringBuilder sb = new StringBuilder();
        list.forEach(l-> {
            sb.append(l);
            if(!(list.size() == sb.length())) {
                sb.append(",");
            }
        });
        System.out.println(sb);*/

        /*File file = new File("D:\\Sample_Projects\\src\\zz.txt");
        if(file.exists()) {
            Scanner scanner = new Scanner(file);
            if(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split(",");
                System.out.println(""+array[0] );
                System.out.println(""+array[1]);
                System.out.println(""+array[2]);
            }
        }

      String str = "04.02.00";
      final String[] versionArray1 = str.split("\\.");
        if (versionArray1.length >= 3) {
            final String thirdOct = versionArray1[2];
            if(thirdOct.equals("00")) {
              //  checkNCreateMCDeviceCompNameToVersion(deviceType, fwVersion, compNameToVersion);
                System.out.println(thirdOct);
            }
        }
       *//* int count = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                while (true);
            }).start();
        }*//*

        String fwVersion = "V04.02.00";
        String fVersion = fwVersion.replace(" ", "");

        String compFwVersion = "V4.2.0";
        compFwVersion = compFwVersion.substring(1);
        String[] versionArray = compFwVersion.split("\\.");
        String major = null;
        String minor = null;
        String patch = null;
        List<String> compFwPermutationList = new ArrayList<>();
        if (versionArray.length == 3) {
            if (versionArray[0] != null && !versionArray[0].isEmpty()) {
                major = versionArray[0];
            }
            if (versionArray[1] != null && !versionArray[1].isEmpty()) {
                minor = versionArray[1];
            }
            if (versionArray[2] != null && !versionArray[2].isEmpty()) {
                patch = versionArray[2];
            }
            //v4.2.0
            final String version1 = "V" + major + minor + patch;
            compFwPermutationList.add(version1);

            //v 4.2.0
            final String version2 = "V " + major + minor + patch;
            compFwPermutationList.add(version2);

            //V04.02.00
            final String version3 = "V" + "0" + major + "0" + minor + "0" + patch;
            compFwPermutationList.add(version3);
        }*/

    }
}
