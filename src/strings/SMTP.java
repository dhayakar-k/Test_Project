package strings;

import designpatterns.prototype.BundledShapeCache;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class SMTP
{

    public static void main(String[] args) throws IOException {
        final String repo = "report_2";
        final String regEx = "^[^\"'\\\\/:;*?<>|]*$";
        if (!repo.matches(regEx)) {
            System.out.println("Not Valid");
        }

        Map<String, String> value1 = null;
        final Map<String, String> s = getList();
        String condtion = s.get("name");
        String condtion1 = s.get("surName");
        if ((condtion != null && !condtion.isBlank()) || (condtion1 != null && !condtion1.isBlank())) {
            System.out.println(condtion+" "+condtion1);
        }


        System.out.println(value1);
        //OPERATION_MON_DATA_MANAGER(Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory /
        //disk space. Restart of Operation / PC / disk clean up may solve this problem)

       /* String name = "OPERATION_MON_DATA_MANAGER_EN:Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory / disk space." +
                "Restart of Operation / PC / disk clean up may solve this problem," +
                "OPERATION_MON_DATA_MANAGER_DE:Fehler : Speichern und Abfragen von OnlineDaten HINT : Das System läuft im Not-Modus wegen zu geringem Speicherplatz." +
                "Ein Neustart des Operations / des PC oder eine Speicherbereinigung kann dieses Problem beheben.," +
                "OPERATION_MON_DATA_MANAGER_ZH:错误 : 正在保存和检索在线数据。 HINT : 由于内存较低，系统以紧急模式运行。重启 Operation/PC 或清理内存可能会解决此问题。," +
                "RESOURCES_EN:Error : Shortage of hardware resources detected. HINT : Increasing hard disk drive space on installation directory may solve this issue.," +
                "RESOURCES_DE:Fehler : Mangel an HardwareRessourcen erkannt. HINT : Das Vergrößern des verfügbaren Speicherplatzes kann dieses Problem beheben.," +
                "RESOURCES_ZH:错误 : 检测到缺少硬件资源。 HINT : 增大安装目录的硬盘驱动器空间可能会解决此问题。";
        String[] split = name.split(",");
        Set<String> compoNames = new HashSet<>();
        List<String> opMonValues = List.of(split);
        opMonValues.forEach(opMon-> {
            String compName = opMon.substring(0, opMon.indexOf(":"));
            String originalCompName = compName.substring(0, compName.lastIndexOf("_"));
            compoNames.add(originalCompName);
        });
        System.out.println(compoNames);
        System.out.println(split[0]);*/
        String name = "OPERATION_MON_DATA_MANAGER_EN:Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory / disk space." +
                "Restart of Operation / PC / disk clean up may solve this problem," +
                "OPERATION_MON_DATA_MANAGER_DE:Fehler : Speichern und Abfragen von OnlineDaten HINT : Das System läuft im Not-Modus wegen zu geringem Speicherplatz." +
                "Ein Neustart des Operations / des PC oder eine Speicherbereinigung kann dieses Problem beheben.," +
                "OPERATION_MON_DATA_MANAGER_ZH:错误 : 正在保存和检索在线数据。 HINT : 由于内存较低，系统以紧急模式运行。重启 Operation/PC 或清理内存可能会解决此问题。,"
                /*"RESOURCES_EN:Error : Shortage of hardware resources detected. HINT : Increasing hard disk drive space on installation directory may solve this issue.," +
                "RESOURCES_DE:Fehler : Mangel an HardwareRessourcen erkannt. HINT : Das Vergrößern des verfügbaren Speicherplatzes kann dieses Problem beheben.," +
                "RESOURCES_ZH:错误 : 检测到缺少硬件资源。 HINT : 增大安装目录的硬盘驱动器空间可能会解决此问题,*/+
                "LICENSE_EN:Error : saving,LICENSE_DE:Error : saving,LICENSE_ZH:Error : saving.,CONF_EN:Error : saving,CONF_DE:Error : saving,CONF_ZH:Error : saving.";
        String str = "RESOURCES( Error : Shortage of hardware resources detected." +
                " HINT : Increasing hard disk drive space on installation directory may solve this issue.),OPERATION_MON_DATA_MANAGER( Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory / disk space." +
                " Restart of Operation / PC / disk clean up may solve this problem)";
        String siseAlarmFlags1 = getSiseAlarmFlags1(name);
        System.out.println(siseAlarmFlags1);
        Map<String, List<String>> systemStatusDetailMap = new HashMap<>();
        List<String> translationTexts = new ArrayList<>();
        int count = 1;
        String systemStatusDetail = "RAM_THRESOLD_CROSS(Actual-41%,Threshold-40%)|,CPU_THRESOLD_CROSS(Actual-86%,Threshold-60%)";/* +
                "SISE_STATUS_ALLANG_DETAIL(OPERATION_MON_DATA_MANAGER_EN:Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory / disk space." +
                " Restart of Operation / PC / disk clean up may solve this problem," +
                " OPERATION_MON_DATA_MANAGER_DE:Fehler : Speichern und Abfragen von OnlineDaten HINT : Das System läuft im Not-Modus wegen zu geringem Speicherplatz. Ein Neustart des " +
                " Operations / des PC oder eine Speicherbereinigung kann dieses Problem beheben.," +
                " OPERATION_MON_DATA_MANAGER_ZH:错误 : 正在保存和检索在线数据。 HINT : 由于内存较低，系统以紧急模式运行。重启 Operation/PC 或清理内存可能会解决此问题。," +
                " RESOURCES_EN:Error : Shortage of hardware resources detected. HINT : Increasing hard disk drive space on installation directory may solve this issue.," +
                " RESOURCES_DE:Fehler : Mangel an HardwareRessourcen erkannt. HINT : Das Vergrößern des verfügbaren Speicherplatzes kann dieses Problem beheben.," +
                " RESOURCES_ZH:错误 : 检测到缺少硬件资源。 HINT : 增大安装目录的硬盘驱动器空间可能会解决此问题。)";*/
        int sise_status_allang_detail = systemStatusDetail.indexOf("SISE_STATUS_ALLANG_DETAIL");
        final String cpuRamMemText = systemStatusDetail.substring(0, sise_status_allang_detail);
        //System.out.println(cpuRamMemText);
        final String siseText = systemStatusDetail.substring(sise_status_allang_detail);
        //System.out.println(siseText);
        final int i = siseText.indexOf("(");
        final int i1 = siseText.indexOf(")");
        String siseOnlyText = siseText.substring(i + 1, i1);
        siseOnlyText = siseOnlyText.replace(",", "\r\n");
        System.out.println(siseOnlyText);
        siseOnlyText = siseOnlyText.replace(",", "\r\n");
        final InputStream inputStream = new ByteArrayInputStream(siseOnlyText.getBytes(StandardCharsets.UTF_8));
        final Properties properties = new Properties();
        properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        final TreeMap<String, String> collect = properties.entrySet().stream()
                .collect(Collectors.toMap(e -> String.valueOf(e.getKey()), e -> String.valueOf(e.getValue()),
                        (prev, next) -> next, TreeMap::new));
        if (collect.size() > 0) {
            for (final Map.Entry<String, String> entry : collect.entrySet()) {
                final String key = entry.getKey();
                final String value = entry.getValue();
                if (NotNullAndNotEmpty(key, value)) {
                    String compName = key.substring(0, key.lastIndexOf("_"));
                    final String formattedValue = compName + "(" + value + ")";
                    if (key.endsWith("_EN")) {
                        translationTexts.add(0, formattedValue);
                    } else {
                        translationTexts.add(formattedValue);
                    }
                    if (count == 3) {
                        count = 0;
                        System.out.println("CompName and translationTexts  : "+compName+" " +translationTexts);
                        systemStatusDetailMap.put(compName, translationTexts);
                        translationTexts = new ArrayList<>();
                    }
                    count = count + 1;
                }
            }
        }
        systemStatusDetailMap.forEach((key,value)-> System.out.println(key+" "+value));
    }

    private static Map<String, String> getList() {
        Map<String, String> values = new HashMap<>();
        values.put("name", null);
        values.put("surName", "Kummari");
        return values;
    }

    private static boolean NotNullAndNotEmpty(final String key, final String value) {
        return (key != null && !key.isEmpty()) && (value != null && !value.isEmpty());
    }
    private static String getSiseAlarmFlags(final String siseRes) {
        StringBuilder siseAlarmFlags = new StringBuilder();
        int startIndex = 0;
        int balanceParen = 0;
        for (int init = 0; init < siseRes.length(); init++) {
            if (siseRes.charAt(init) == '(') {
                if (balanceParen == 0) {
                    if (!siseAlarmFlags.toString().equals("")) {
                        siseAlarmFlags.append(",");
                    }
                    String compName = siseRes.substring(startIndex, init);
                    String severity = getAlarmSeverity(compName);
                    if (!severity.equals("-1")) {
                        siseAlarmFlags.append("\"").append(compName).append("\":\"")
                                .append(severity).append("\"");
                    }
                }
                balanceParen++;
            } else if (siseRes.charAt(init) == ')') {
                startIndex = init + 2;
                balanceParen--;
            }
        }
        System.out.println(siseAlarmFlags.toString());
        return siseAlarmFlags.toString();
    }

    private static String getAlarmSeverity(String compName) {
        String severity = "-1";
        if(compName.equals("RESOURCES") || compName.contains("LICENSE") /*|| compName.equals("CONF")*/) {
            severity = "-1";
        } else {
            severity = "-3";
        }
        return severity;
    }

    private static String getSiseAlarmFlags1(final String siseRes) {
        System.out.println("SisResponse "+ siseRes);
        StringBuilder siseAlarmFlags = new StringBuilder();
        final Set<String> compNames = getCompNames(siseRes);
        if (compNames.size() > 0) {
            for (final String compName: compNames) {
                final String severity = getAlarmSeverity(compName);
                if (!severity.equals("-1")) {
                    if (!siseAlarmFlags.toString().equals("")) {
                        siseAlarmFlags.append(",");
                    }
                    siseAlarmFlags.append("\"").append(compName).append("\":\"")
                            .append(severity).append("\"");
                }
            }
        }
        return siseAlarmFlags.toString();
    }

    private static Set<String> getCompNames(String siseRes) {
        final Set<String> compoNames = new HashSet<>();
        try {
            /// Split the string using regex comma as siseRes contains comma separated component names including
            // english, german and chinese text like "RESOURCES_EN:shortage of hardware,RESOURCES_DE:shortage of hardware,
            //  RESOURCES_ZH:shortage of hardware resources"
            final String[] array = siseRes.split(",");
            if (array.length > 0) {
                List.of(array).forEach(compString-> {
                    if (compString != null && !compString.isBlank()) {
                        //Remove : get only compName RESOURCES_EN
                        String compName = compString.substring(0, compString.indexOf(":"));
                        //Remove _EN, _DE, _ZH get only compName RESOURCES
                        String originalCompName = compName.substring(0, compName.lastIndexOf("_"));
                        compoNames.add(originalCompName);
                    }
                });
            }

        } catch (Exception e) {
            //logger.error("Exception at getCompNames ", e);
        }
        return compoNames;
    }
}
