package strings;

import org.apache.commons.text.StringEscapeUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class SISEHealthObserver {

    public static void main(String[] args) {

        String str = "\\u6b63\\u5728\\u4fdd\\u5b58\\u548c\\u68c0\\u7d22\\u5728\\u7ebf\\u6570\\u636e\\u3002";

        String escapeJava = StringEscapeUtils.escapeJava(str);
        final String string = "{" +
                "\"OPERATION_MON_DATA_MANAGER_EN\":\"Error : Saving and retrieving  online data. HINT : System is running in emergency mode due to low memory / disk space. Restart of Operation / PC / disk clean up may solve this problem\",\n" +
                "\"OPERATION_MON_DATA_MANAGER_DE\":\"Fehler : Speichern und Abfragen von OnlineDaten. HINT : Das System l\\u00e4uft im Not-Modus wegen zu geringem Speicherplatz. Ein Neustart des Operations / des PC oder eine Speicherbereinigung kann dieses Problem beheben.\"}";
        if (string.startsWith("{") && string.endsWith("}")) {
            String replace = string.replace("{", "").replace("}","");
            System.out.println("After removing { and } "+replace);
        }

        System.out.println(string);
        final StringBuilder msg = new StringBuilder();
        List<Map<String, Object>> siseCompStatusObjList = getData();

        if (siseCompStatusObjList.size() > 0){
            int count = 0;
            for (Map<String, Object> compStatusObj: siseCompStatusObjList) {
                List<String> statusList = (List<String>) compStatusObj.get("status");
                String status = statusList.get(0);
                String componentName = ((String) compStatusObj
                        .get("componentName")).trim();
                if ("OK".equals(status) || componentName.equals("Monitoring")
                        || componentName.equals("Backup")) {
                    continue;
                }
                if (count > 0) {
                    msg.append(",");
                }

                String compKey = componentName.toUpperCase()
                        .replaceAll(" ",
                                "_")
                        .replaceAll("\\(|\\)|\\.", "");
                /*msg.append(compKey);
                msg.append("(");
                msg.append(" " + status);*/
                List<String> descriptionList = (List<String>) compStatusObj
                        .get("description");
                /*msg.append(" : ").append(
                        descriptionList.get(0).trim().replace("-", ""));*/
                List<String> hintList = (List<String>) compStatusObj.get("hint");
                /*msg.append(" " + "hint".toUpperCase() + " : ").append(
                        hintList.get(0).trim().replace("–", ""));*/
                for (int i = 0; i < descriptionList.size(); i++) {
                    final String compStatus = statusList.get(i).trim();
                    final String desc = " : "+descriptionList.get(i).trim().replace("-", "");
                    final String hint = " " + "hint".toUpperCase() + " : "+
                            hintList.get(i).trim().replace("–", "");
                    appendTextToMsg(compStatus, desc, hint, i, msg, compKey);
                    //LOGGER.info("i = {}, sb = {}", i, sb);
                }
                //msg.append(")");
                count++;
            }
        }
    }

    private static void appendTextToMsg(final String status, final String desc, final String hint,
                                 final int count, final StringBuilder msg, final String compKey) {
        if (count == 0) {
            msg.append("\"").append(compKey).append("_EN").append("\":").append("\"").
                    append(status).append(desc).append(hint).append("\"").append(",");
        } else if (count == 1) {
            msg.append("\"").append(compKey).append("_DE").append("\":").append("\"").
                    append(status).append(desc).append(hint).append("\"").append(",");
        } else {
            msg.append("\"").append(compKey).append("_ZH").append("\":").append("\"").
                    append(status).append(desc).append(hint).append("\"");
        }
    }

    private static List<Map<String, Object>> getData() {
        List<Map<String, Object>> siseHealthList = new ArrayList<>();

        Map<String, Object> opMonData = new TreeMap<>();
        opMonData.put("componentName", "Operation Mon. Data Manager");
        List<String> descriptionList = new ArrayList<>();
        descriptionList.add("Saving and retrieving  online data.");
        descriptionList.add("Speichern und Abfragen von Online-Daten.");
        descriptionList.add("保存和检索在线数据");
        opMonData.put("description", descriptionList);

        List<String> hintList = new ArrayList<>();
        hintList.add("System is running in emergency mode due to low memory / disk space. Restart of Operation / PC / disk clean up may solve this problem");
        hintList.add("Das System l\\u00e4uft im Not-Modus wegen zu geringem Speicherplatz. Ein Neustart des Operations / des PC oder eine Speicherbereinigung kann dieses Problem beheben.");
        hintList.add("由于内存/磁盘空间不足，系统正在紧急模式下运行。重新启动操作/PC/磁盘清理可能会解决此问题");
        opMonData.put("hint", hintList);

        List<String> statusList = new ArrayList<>();
        statusList.add("Error");
        statusList.add("Fehler");
        statusList.add("错误");
        opMonData.put("status", statusList);

        siseHealthList.add(opMonData);

        Map<String, Object> resourceData = new TreeMap<>();
        resourceData.put("componentName", "Resources");
        List<String> descriptionList1 = new ArrayList<>();
        descriptionList1.add("Shortage of hardware resources detected.");
        descriptionList1.add("Mangel an Hardware-Ressourcen erkannt.");
        descriptionList1.add("检测到硬件资源短缺。");
        resourceData.put("description", descriptionList1);

        List<String> hintList1 = new ArrayList<>();
        hintList1.add("Increasing hard disk drive space on installation directory may solve this issue.");
        hintList1.add("Das Vergr\\u00f6\\u00dfern des verf\\u00fcgbaren Speicherplatzes kann dieses Problem beheben.");
        hintList1.add("增加安装目录上的硬盘驱动器空间可能会解决此问题。");
        resourceData.put("hint", hintList1);

        List<String> statusList1 = new ArrayList<>();
        statusList1.add("Error");
        statusList1.add("Fehler");
        statusList1.add("错误");
        resourceData.put("status", statusList1);

        siseHealthList.add(resourceData);
        return siseHealthList;

    }
}
