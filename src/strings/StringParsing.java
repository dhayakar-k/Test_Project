package strings;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringParsing {
    public static void main(String[] args) {
        Map<String, Boolean> processMonitor = new HashMap<>();
        processMonitor.put("erl", false);
        processMonitor.put("erlsrv", false);
        processMonitor.put("postgres", false);
        StringBuilder sb = new StringBuilder();
        checkInfo(processMonitor, sb);
        System.out.println(sb);
        StringBuilder msg = new StringBuilder();
        msg.append("\"RAM_THRESOLD_CROSS_EN\" : \"" + "Actual-").append((int) 70).append("GigaBytes,Threshold-").
                append(30).append("GigaBytes").append("\"").append(",");
        msg.append("\"RAM_THRESOLD_CROSS_DE\" : \"" + "Tatsächlich-").append((int) 70).append("GigaBytes,Schwelle-").
                append(30).append("GigaBytes").append("\"").append(",");
        msg.append("\"RAM_THRESOLD_CROSS_ZH\" : \"" + "实际的-").append((int) 70).append("GigaBytes,临界点-").
                append(30).append("GigaBytes").append("\"");
        System.out.println(msg);
        String str = "MEMORY_THRESOLD_CROSS((Actual-0.2GigaBytes, Threshold-38GigaBytes) ,(Tatsächlich-0.2GigaBytes, Schwelle-38GigaBytes) ,(实际的-0.2GigaBytes,临界点-38GigaBytes)),-" +
                "OPERATION_MON_DATA_MANAGER((Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory / disk space. " +
                "Restart of Operation / PC / disk clean up may solve this problem) ,(Fehler: Online-Daten werden gespeichert und abgerufen. HINWEIS: Das System läuft im Notfallmodus, da der Arbeitsspeicher/Festplattenspeicher knapp ist.\n" +
                "Ein Neustart des Betriebs/PC/Festplattenbereinigung kann dieses Problem lösen) ,(错误：保存和检索在线数据。提示：由于内存/磁盘空间不足，系统正在紧急模式下运行。" +
                "重新启动操作/PC/磁盘清理可能会解决此问题)),-" +
                "RESOURCES((Error : Shortage of hardware resources detected. HINT : Increasing hard disk drive space on installation directory may solve this issue.)," +
                "(Fehler: Mangel an Hardwareressourcen erkannt. TIPP: Durch Erhöhen des Festplattenspeichers im Installationsverzeichnis kann dieses Problem möglicherweise behoben werden.),\n" +
                "(错误： 检测到硬件资源短缺。 提示：增加安装目录上的硬盘驱动器空间可能会解决此问题。))";
        String[] arr = str.split(",-",3);
        /*System.out.println(arr[0]);
        String[] memThrArray = arr[0].split("\\s,",3);
        for (int i = 0; i < memThrArray.length; i++) {
            final String thrTex = memThrArray[i];
            if (i == 0) {
                String text1 = memThrArray[i].substring(thrTex.lastIndexOf("("));
                System.out.println("MEMORY_THRESOLD_CROSS"+text1);
            } else {
                System.out.println("MEMORY_THRESOLD_CROSS" + thrTex);
            }

        }*/
        System.out.println(arr[1]);
        String[] opMonDataArray = arr[1].split("\\s,",3);
        for (int i = 0; i < opMonDataArray.length; i++) {
            final String text = opMonDataArray[i];
            if (i == 0) {
                String text1 = opMonDataArray[i].substring(text.lastIndexOf("("));
                System.out.println("OPERATION_MON_DATA_MANAGER"+text1);
            } else {
                System.out.println("OPERATION_MON_DATA_MANAGER" + text);
            }

        }
        // System.out.println(arr[1]);
        // System.out.println(arr[2]);
       /* String str1 = memThrArray[0];
        //MEMORY_THRESOLD_CROSS((Actual-0.2GigaBytes,Threshold-38GigaBytes)
        String substring = str1.substring(str1.lastIndexOf("("));
        System.out.println("MEMORY_THRESOLD_CROSS"+substring);
        System.out.println("MEMORY_THRESOLD_CROSS"+memThrArray[1]);
        System.out.println("MEMORY_THRESOLD_CROSS"+memThrArray[2]);*/
    }

    private static void checkInfo(Map<String, Boolean> processMonitor, StringBuilder sb) {
        Map<String, Boolean> copy = new TreeMap<>(processMonitor);
        for (Map.Entry<String, Boolean> entry : copy.entrySet()) {
            if (!entry.getValue()) {
                appendMonitorProcessTxt(sb, entry.getKey().toUpperCase());
            }
        }
    }

    private static void appendMonitorProcessTxt(final StringBuilder msg, final String key) {
        //msg.append("\"CPU_THRESOLD_CROSS_ZH\" : \"" + "实际的-").append((int) usedSpacePercent).append("%,临界点-").
        //                append(cpuWarningThreshold).append("%").append("\"");
        msg.append("\""+key).append("_EN").append("\":").append("\""+key).append("_DOWN").append("\"").append(",");
        msg.append("\""+key).append("_DE").append("\":").append("\""+key).append("_RUNTER").append("\"").append(",");
        msg.append("\""+key).append("_ZH").append("\":").append("\""+key).append("_向下").append("\"");
        if (!key.equals("postgres".toUpperCase())) {
            msg.append(",");
        }
    }
}
