package strings;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Pattern;

public class BasicStrings {

    public static String[] getStringArray(Set<String> stringSet) {
        String[] strings = new String[stringSet.size()];
        int index = 0;
        for(String str: stringSet) {
            strings[index++] = str;
        }
        return strings;
    }
    public static final String IP_V6_PATTERN = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
    public static final String IP_V4_PATTERN = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";

    public static void main(String[] args) throws IOException {
        String ipAddress = "10.202.3.253";
        if(Pattern.compile(IP_V4_PATTERN).matcher(ipAddress).matches() &&
                Pattern.compile(IP_V6_PATTERN).matcher(ipAddress).matches()) {
            System.out.println("Matching ipv4 and ipv6 pattern");
        }
        LocalDateTime localDateTime = Instant.ofEpochMilli(1668576960154L).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);
        System.out.println(System.currentTimeMillis());
        String str15 = "";
        checkStrIsEmpty(str15);
        /*String str = "I am Dhayakar";
        System.out.println("Who are you: ? ");
        System.out.print(str);
        System.out.println();
        Set<String> hashSet = new HashSet<>(List.of(str));
        String[] finalArrayString = getStringArray(hashSet);
        System.out.println(Arrays.toString(finalArrayString));*/
        Pojo pojo = new Pojo();
        Long startTime = pojo.getStartTime();
        Long time = System.currentTimeMillis();
        String currentTime = String.valueOf(time);
        System.out.println("Current time in string format "+currentTime);
        final String certStr = "78dkd";
        int length10 = certStr.length();
        System.out.println(length10);
        List<String> boxes = new ArrayList<>();
        boxes.add("Pen");
        boxes.add("Pencil");
        boxes.add("Rubber");
        List<String> bag = new ArrayList<>();
        bag.add("NoteBook");
        bag.add("Pen");
        bag.add("Pencil");
        boxes.retainAll(bag);
        System.out.println(bag);
        bag.retainAll(boxes);

        String str10 = "1020, 1021, 1024";
        String[] strings = str10.split(",");
        for (String st: strings) {
            System.out.println(st);
        }
        Integer gJobId = (((1000)*-1)*100);
        System.out.println(gJobId);
        String str4 = "Intel(R) Xeon(R) Gold 6148 CPU @ 2.40GHz 2394 Mhz 2 Cores(s) 2 Logical Processor(s) Intel(R) Xeon(R) Gold 6148 CPU @ 2.40GHz 2394 Mhz 2 Cores(s) 2 Logical Processor(s)";
        System.out.println(str4.length());
        String str5 = "Intel(R) Xeon(R) Gold 6148 CPU @ 2.40GHz 2394 Mhz 2 Cores(s) 2 Logical Processor(s) Intel(R) Xeon(R) Gold 6148 CPU @ 2.40GHz 2394 Mhz 2 Cores(s) 2 Logical Processor(s)";
        System.out.println(str5.length());
        if(str4.equals(str5)) {
            System.out.println("Both German and English has same text");
        }
        String finalString = "Control name: Product name: Product version: Release version: License type:Remaining days of license:" +
                "Number of nodes: HSP version:Operating system name: Version: Operating system manufacturer: System type: Processor: " +
                "Available work memory (RAM): Product Configuration: SNMPV3 EngineID: ";
        int length = finalString.length();
        System.out.println(length);
        String ctrlName = "Control name";
        System.out.println("ctrlName length: "+ctrlName.length());
        String productName = "Product name";
        System.out.println("Product name: "+productName.length());
        String productVersion = "Product version";
        System.out.println("Product version: "+productVersion.length());
        String releaseVersion ="Release version";
        System.out.println("Release version: "+releaseVersion.length());
        String licenseType = "License type";
        System.out.println("License type: "+licenseType.length());
        String licenseRemainingDays = "Remaining days of license";
        System.out.println("Remaining days of license: "+licenseRemainingDays.length());
        String nodes ="Number of nodes";
        System.out.println("Nodes: "+nodes.length());
        String hspVersion ="HSP version";
        System.out.println("HSP version: "+hspVersion.length());
        String os ="Operating system name";
        System.out.println("Operating system name: "+os.length());
        String version ="Version";
        System.out.println("Version: "+version.length());
        String manufacturer ="Operating system manufacturer";
        System.out.println("Operating system manufacture: "+manufacturer.length());
        String systemType ="System type";
        System.out.println("System type: "+systemType.length());
        String processor ="Processor";
        System.out.println("Processor: "+processor.length());
        String ram ="Available work memory (RAM)";
        System.out.println("Available work memory (RAM): "+ram.length());
        String productConfiguration ="Product Configuration";
        System.out.println("Product Configuration: "+productConfiguration.length());
        String snmpv3EngId ="SNMPV3 EngineID";
        System.out.println("SNMPV3 EngineID: "+snmpv3EngId.length());

        String str = "Welcome To Siemens";
        StringTokenizer strTokenizer = new StringTokenizer(str);
        String[] arrayOfTokens = new String[strTokenizer.countTokens()];
        int i=0;
        while(strTokenizer.hasMoreTokens()) {
            arrayOfTokens[i++] = strTokenizer.nextToken();
        }
        System.out.print("[");
        for(String str1: arrayOfTokens) {
            System.out.println(str1+" ");
        }
        System.out.print("]");
        System.out.println();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        InputStream iS = new ByteArrayInputStream(bytes);
        BufferedReader bR = new BufferedReader(new InputStreamReader(iS));
        String str3 = bR.readLine();
        while (str3 != null) {
            System.out.println(str3);
            str3 = bR.readLine();
        }

    }

    private static void checkStrIsEmpty(String str) {
        if(str != null && !str.isEmpty()) {
            System.out.println(false);
        } else
            System.out.println(true);
    }
}
