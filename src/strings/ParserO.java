package strings;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParserO {

    private static final Pattern UNICODE_PATTERN = Pattern.compile("\\\\u([0-9A-Fa-f]{4})");

    private static final String RAM_THRESOLD_CROSS = "RAM_THRESOLD_CROSS";
    private static final String CPU_THRESOLD_CROSS = "CPU_THRESOLD_CROSS";
    private static final String MEMORY_THRESOLD_CROSS = "MEMORY_THRESOLD_CROSS";

    public static void main(String[] args) throws IOException {
        /*String requestString="你好";
        String ISO = new String(requestString.getBytes("gb2312"), "ISO8859-1");
        String plaintxt = new String(ISO.getBytes("ISO8859-1"), "gb2312");
        byte[] bytes = plaintxt.getBytes("UTF-8");
        System.out.println(new String(bytes));
        //Charact
        String[] arr1 = new String[] {"dh", "ya", "ka"};
        System.out.println("arr1:"+arr1);
        StringBuilder data = new StringBuilder();
        data.append("MEMORY_THRESOLD_CROSS(Actual-8.1GigaBytes, Threshold-38GigaBytes) ,");
        if (!data.toString().equals("")) {
            String actualString = data.toString();
            String cpuRamMemText = actualString.substring(0, actualString.indexOf(" ,"));
            data = new StringBuilder(cpuRamMemText);
        }
        System.out.println(data);*/
        /*StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("}");
        if("{}".equals(sb.toString())) {
            sb = new StringBuilder();
        }
        System.out.println(sb);*/

        final String cpuStr = "MEMORY_THRESOLD_CROSS(Actual-0.5GigaBytes, Threshold-38GigaBytes)";
        final String siseStatus = "{\"OPERATION_MON_DATA_MANAGER_EN\":\"Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory / disk space. \n" +
                "  Restart of Operation / PC / disk clean up may solve this problem\",\n" +
                "  \"OPERATION_MON_DATA_MANAGER_DE\":\"Fehler : Speichern und Abfragen von OnlineDaten HINT : Das System läuft im Not-Modus wegen zu geringem Speicherplatz. \n" +
                "  Ein Neustart des Operations / des PC oder eine Speicherbereinigung kann dieses Problem beheben.\",\n" +
                "  \"RESOURCES_EN\":\"Error : Shortage of hardware resources detected. HINT : Increasing hard disk drive space on installation directory may solve this issue.\",\n" +
                "  \"RESOURCES_DE\":\"Fehler : Mangel an HardwareRessourcen erkannt. HINT : Das Vergrößern des verfügbaren Speicherplatzes kann dieses Problem beheben.\"}";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cpuStr);
        stringBuilder.append(",");
        stringBuilder.append("SISE_STATUS_ALLANG_DETAIL(");
        // 2-Combination
        // Ram-CPU, RAM-Memory, RAM-ERL, RAM-erlsrv, RAM-postgres
        // Cpu-Memory, Cpu-erl, Cpu-erlsrv, Cpu-postgres
        // Memory-erl, Memory-erlsrv, Memory-postgres
        // erl-erlsrv, erl-postgres
        // erlsrv-postgres

        // 1-Combination
        // Ram
        // Cpu
        // Memory
        // erl
        // erlsrv
        // postgres

        // 3- Combination
        // Ram-Cpu-Memory, Ram-Cpu-erl, Ram-Cpu-erlsrv, Ram-Cpu-postgres
        // Cpu-Memory-erl, Cpu-Memory-erlsrv, Cpu-Memory-postgres
        // Memory-erl-erlsrv, memory-erl-postgres
        // erl-erlsrv-postgres

        // 4- Combination
        // Ram-Cpu-Memory-Erl, Cpu-Memory-Erl-Erlsrv, Memory-Erl-ErlSrv-postgres

        // 5-Combination
        // Ram-Cpu-Memory-Erl-Erlsrv, Cpu-Memory-Erl-Erlsrv-postgres

        // 6-Combination
        //Ram-Cpu-Memory-Erl-Erlsrv-postgres

        // RAM_THRESOLD_CROSS(Actual-80%,Threshold-60%) ,
        //CPU_THRESOLD_CROSS(Actual-90%,Threshold-70%) ," +
        //                "MEMORY_THRESOLD_CROSS(Actual-0.2GigaBytes,Threshold-38GigaBytes) ,erl_DOWN ,erlsrv_DOWN ,postgres_DOWN"
        /*String str =  "RAM_THRESOLD_CROSS(Actual-80%,Threshold-60%) ,CPU_THRESOLD_CROSS(Actual-90%,Threshold-70%) ," +
                "MEMORY_THRESOLD_CROSS(Actual-0.2GigaBytes,Threshold-38GigaBytes) ,"+
                "SISE_STATUS_ALLANG_DETAIL({OPERATION_MON_DATA_MANAGER_EN:Error : Saving and retrieving  online data." +
                " HINT : System is running in emergency mode due to low memory / disk space. Restart of Operation / PC / " +
                "disk clean up may solve this problem,OPERATION_MON_DATA_MANAGER_DE:Fehler : Speichern und Abfragen von " +
                "OnlineDaten HINT : Das System läuft im Not-Modus wegen zu geringem Speicherplatz. Ein Neustart des Operations / " +
                "des PC oder eine Speicherbereinigung kann dieses Problem beheben.,RESOURCES_EN:Error : Shortage of hardware " +
                "resources detected. HINT : Increasing hard disk drive space on installation directory may solve this issue.," +
                "RESOURCES_DE:Fehler : Mangel an HardwareRessourcen erkannt. " +
                "HINT : Das Vergrößern des verfügbaren Speicherplatzes kann dieses Problem beheben.})";*/

        /*String str = "MEMORY_THRESOLD_CROSS(Actual-5.6GigaBytes, Threshold-38GigaBytes) ," +
                "SISE_STATUS_ALLANG_DETAIL({OPERATION_MON_DATA_MANAGER_EN:Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory /" +
                "disk space. Restart of Operation / PC / disk clean up may solve this problem," +
                "OPERATION_MON_DATA_MANAGER_DE:Fehler : Speichern und Abfragen von OnlineDaten HINT : Das System läuft im Not-Modus wegen zu geringem Speicherplatz. " +
                "Ein Neustart des Operations / des PC oder eine Speicherbereinigung kann dieses Problem beheben.," +
                "OPERATION_MON_DATA_MANAGER_ZH:错误 : 正在保存和检索在线数据。 HINT : 由于内存较低，系统以紧急模式运行。重启 Operation/PC 或清理内存可能会解决此问题。," +
                "RESOURCES_EN:Error : Shortage of hardware resources detected. HINT : Increasing hard disk drive space on installation directory may solve this issue.," +
                "RESOURCES_DE:Fehler : Mangel an HardwareRessourcen erkannt. HINT : Das Vergrößern des verfügbaren Speicherplatzes kann dieses Problem beheben.," +
                "RESOURCES_ZH:错误 : 检测到缺少硬件资源。 HINT : 增大安装目录的硬盘驱动器空间可能会解决此问题。})  ";*/
        //RAM_THRESOLD_CROSS(Actual-45%,Threshold-35%),CPU_THRESOLD_CROSS(Actual-85%,Threshold-65%),MEMORY_THRESOLD_CROSS(Actual-13.0GigaBytes,Threshold-38GigaBytes),

        //RAM_THRESOLD_CROSS(Actual-41%,Threshold-40%) |,CPU_THRESOLD_CROSS(Actual-86%,Threshold-60%)|,
        String str = "ONE_OR_MORE_OPERATIONS";
        if (str.equals("ONE_OR_MORE_OPERATIONS")) {
            String[] arr = new String[] {str};
            System.out.println(arr[0]);
        }
        String substring2 = str.substring(0, str.lastIndexOf(","));
        System.out.println(substring2);
        String[] subString1 = new String[] {};
        if(!str.contains("SISE_STATUS_ALLANG_DETAIL")) {
            subString1 = str.split("\\|,");
        }
        int sise_status_allang_detail = str.indexOf("SISE_STATUS_ALLANG_DETAIL");
        //String substring2 = str.substring(0, sise_status_allang_detail);
        //System.out.println(substring2);
        List<String> stringList = List.of(subString1);
        Map<String, String> sysMap = new LinkedHashMap<>();
        stringList.forEach(str10-> extracted(sysMap, str10));
        sysMap.forEach((key, value)-> System.out.println(key+":"+value));

        int length = str.length();
        String substring = str.substring(sise_status_allang_detail, length);
        System.out.println(substring);
        int i = substring.indexOf("(");
        int i1 = substring.indexOf(")");
        String substring1 = substring.substring(i+1, i1);
        System.out.println(substring1);
        substring1 = substring1.replace(",","\r\n");
        Properties properties = new Properties();
        System.out.println(substring1);
        byte[] bytes = substring1.getBytes("UTF-8");
        InputStream in = new ByteArrayInputStream(bytes);
        properties.load(new InputStreamReader(in));
        SiseStatusDetails siseStatusDetails = new SiseStatusDetails();

        Map<String, List<String>> map = new LinkedHashMap<>();
        if(sysMap.size() > 0) {
            for (Map.Entry<String, String> healthEntry : sysMap.entrySet()) {
                map.put(healthEntry.getKey(), List.of(healthEntry.getValue()));
            }
        }

        List<String> translationValues = new ArrayList<>();
        int count = 1;
        final TreeMap<String, String> collect = properties.entrySet().stream().collect(
                Collectors.toMap(e -> String.valueOf(e.getKey()), e -> String.valueOf(e.getValue()),
                        (prev, next) -> next, TreeMap::new));
        if (collect.size() > 0) {
            for (Map.Entry<String, String> entry : collect.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    String compName = key.substring(0, key.lastIndexOf("_"));
                    String formattedValue = compName + "(" + value + ")";
                    if (key.endsWith("_EN")) {
                        translationValues.add(0, formattedValue);
                    }  else {
                        translationValues.add(formattedValue);
                    }
                    if (count == 3) {
                        count = 0;
                        map.put(compName, translationValues);
                        translationValues = new ArrayList<>();
                    }
                    count = count + 1;
                }
            }
        }

        siseStatusDetails.setTranslationText(map);
        System.out.println(siseStatusDetails.toString());

    }

    private static void extracted(Map<String, String> sysMap, String msg) {
        if (msg.contains(RAM_THRESOLD_CROSS)) {
            sysMap.put(RAM_THRESOLD_CROSS, msg);
        } else if (msg.contains("CPU_THRESOLD_CROSS")) {
            sysMap.put("CPU_THRESOLD_CROSS", msg);
        } else if (msg.contains("MEMORY_THRESOLD_CROSS")) {
            sysMap.put("MEMORY_THRESOLD_CROSS", msg);
        } else if (msg.equals("erl_DOWN")) {
            sysMap.put("ERL", msg);
        } else if (msg.equals("erlsrv_DOWN")) {
            sysMap.put("ERLSRV", msg);
        } else {
            sysMap.put("POSTGRES", msg);
        }
    }

    private static String checkAndGetString(String msg) {
        String ramThresoldCross = null;
        String cpuThresoldCross = null;
        String memoryThresoldCross= null;
        String erl = null;
        String erlSrv = null;
        String postgres = null;
        if (msg.contains("RAM_THRESOLD_CROSS")) {
            ramThresoldCross = msg;
            return ramThresoldCross;
        } else if (msg.contains("CPU_THRESOLD_CROSS")) {
            cpuThresoldCross = msg;
            return cpuThresoldCross;
        } else if (msg.contains("MEMORY_THRSOLD_CROSS")) {
            memoryThresoldCross = msg;
            return memoryThresoldCross;
        } else if (msg.contains("ERL")) {
            erl = msg;
            return erl;
        } else if (msg.contains("ERLSRV")) {
            erlSrv = msg;
            return erlSrv;
        } else {
            postgres = msg;
            return postgres;
        }
    }

    public static String unescapeUnicode(String unescaped) {
        return UNICODE_PATTERN.matcher(unescaped).replaceAll(r->String.valueOf(
                (char) Integer.parseInt(r.group(1), 16)));
    }
}
