package acl;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ACLPermissions {


    public static final List<String> SERVICE_EXE_FILES = List.of(new String[]{"..\\Apache\\bin\\httpd.exe", "..\\erl11.0\\erts-11.0\\bin\\erlsrv.exe", "..\\PostgreSQL\\bin\\pg_ctl.exe", "bin\\sinec_nms_control_lcm.exe",
            "bin\\sinec_nms_oc_lcm.exe", "SinecnmsIO\\Policy_Enforcement.exe",
            "..\\..\\usermanagement\\bin\\ipcseccom.exe", "..\\..\\usermanagement\\bin\\umcservice.exe", "..\\..\\usermanagement\\bin\\upservice.exe"});

    public static void main(String[] args) throws IOException {

        String USERNAME_SPEC_CHAR_VALIDATION_REG = "^[^\"\\\\'?;*]*$";
        String uName = "John Deo'\"?";
        if(!uName.matches(USERNAME_SPEC_CHAR_VALIDATION_REG)) {
            System.out.println("Matching");
        }

        final Map<String, Object> nodeDetails = new HashMap<>();
        nodeDetails.put("node_id", "C:0-O:7");
        nodeDetails.put("job_exe_status", null);
        verifyIfJobExeStatusIsQual(nodeDetails);


        final String signHashAlgorithm ="End entity certificate used for secured Web/Internal/UMC communication";
        System.out.println("Length "+signHashAlgorithm.length());


        int compareValue = new BigInteger("16856889445151")
                .compareTo(new BigInteger("99999999999999"));
        if (compareValue > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


        final String IP_V4_PATTERN = "^[0-9]+$";
        String ipAddress = "api.vilocify.com";
        Pattern pattern1 = Pattern.compile(IP_V4_PATTERN);
        Matcher matcher1 = pattern1.matcher(ipAddress);
        if(matcher1.matches()) {
            System.out.println("IPV4 pattern matched");
        }

        final String str20 = "";
        System.out.println(str20.length());
        if(str20 != null && !str20.isEmpty()) {
            System.out.println("Blank string");
        }

        final String sysConfigPwd = "dhaya123456756787";
        final String regEx = "^[^\"\\\\']*$"; //^(?=\s*$)
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(sysConfigPwd);
        if(matcher.matches()) {
            System.out.println("Empty String matches");
        } else {
            System.out.println("Not matching");
        }



       /* final String nmsVersion = "V02.00.00.00";
        System.out.println(nmsVersion.length());
        final String sinecNmsVersion = "V02.00.00.00_18.00.00.52";
        final String version = sinecNmsVersion.substring(0, sinecNmsVersion.indexOf("_"));
        System.out.println(version);

        final String sslCert = "SSLCertificates_172.16.123.69 (8)";
        System.out.println(sslCert.length());

        List<String> ids = new ArrayList<>();
        ids.add("C:0-O:1'");
        ids.add("C:0-O:2");
        ids.add("C:0-O:3");
        ids.add("C:0-O:4");
        ids.add("C:0-O:5");
        ids.add("C:0-O:6");
        System.out.println(ids.size());
        String str15 = "";
        if(ids.get(0).isBlank()) {
            System.out.println("Is Blank");
        }

        final String moduleUMC = "ipsimatic-logon";
        System.out.println(moduleUMC.length());

        final String sysInfo = "SysInfo_1685360596575.csv";
        System.out.println(sysInfo.length());

        Integer intu = 10;
        System.out.println(intu.intValue());
        final String strr ="Com.siemens62784382930hdakdufhadkpawewnxmncmndjskjwejiwkwoieoirklphaghxvzmncmvwhhqr" +
                "tyuweioiuehndcxbnjdhwjhxnjhsdjjklkskslsksjjfjfuhiwkmsjhkjfkkiwukdkkfijwkoofhnmksjnsaqewrteyuriotplmnbvcxzsdfagfhdjkl0.com";
        System.out.println(strr.length());
        final Pattern pattern = Pattern.compile("^([a-zA-Z0-9-:,])+$");
        String name = "C:0-O:1',C:0-O:2\\";
        final Matcher matcher = pattern.matcher(name);
        if(matcher.matches()) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
        }

        String sortOrder = "desc";
        final int length1 = sortOrder.length();
        System.out.println(length1);*/

        String jobTypes = "controllogcollection,discovery,operationlogcollection,policyexecutor,purge,report,sync,systembackup,systemintegritycheck";
        final int length =  jobTypes.length();
        System.out.println(length);

        String executionStatus = "12,2,7,4,21,5,18,3";
        final int jobExeStatusLength =  executionStatus.length();
        System.out.println(jobExeStatusLength);

        String oprNames = "INKEOMAN1134PR,INKEOMAN1137PR,INKEOMAN1138PR,INKEOMAN1144PR,INKEOMAN1146PR,INKEOMAN1151PR,INKEOMAN1152PR,INKEOMAN1153PR," +
                "INKEOMAN1154PR,INKEOMAN1155PR,INKEOMAN1156PR,INKEOMAN1157PR,INKEOMAN1158PR,INKEOMAN1159PR,INKEOMAN1160PR,INKEOMAN1161PR,INKEOMAN1162PR," +
                "INKEOMAN1163PR,INKEOMAN1164PR,INKEOMAN1165PR,INKEOMAN1166PR,INKEOMAN1167PR,INKEOMAN1169PR,INKEOMAN1170PR,INKEOMAN1171PR,INKEOMAN1172PR," +
                "INKEOMAN1173PR,INKEOMAN1174PR,INKEOMAN1175PR,INKEOMAN1176PR,INKEOMAN1177PR,INKEOMAN1178PR,INKEOMAN1179PR,INKEOMAN1180PR,INKEOMAN1181PR," +
                "INKEOMAN1182PR,INKEOMAN1183PR,INKEOMAN1184PR,INKEOMAN1185PR,INKEOMAN1186PR,INKEOMAN1187PR,INKEOMAN1188PR,INKEOMAN1189PR,INKEOMAN1190PR," +
                "INKEOMAN1191PR,INKEOMAN1192PR,INKEOMAN1193PR,INKEOMAN1194PR,INKEOMAN1265PR,INKEOMAN1271PR,INKEOMAN1272PR,INKEOMAN1273PR,INKEOMAN1274PR," +
                "INKEOMAN1275PR,INKEOMAN1276PR,INKEOMAN1277PR,INKEOMAN1278PR,INKEOMAN1279PR,INKEOMAN1280PR,INKEOMAN1281PR,INKEOMAN1282PR,INKEOMAN1283PR," +
                "INKEOMAN1284PR,INKEOMAN1285PR,INKEOMAN1286PR,INKEOMAN1287PR,INKEOMAN1288PR,INKEOMAN1289PR,INKEOMAN1290PR,INKEOMAN1291PR,INKEOMAN1293PR," +
                "INKEOMAN1294PR,INKEOMAN1295PR,INKEOMAN1334PR,INKEOMAN1345PR";
        final int oprNamesLength =  oprNames.length();
        System.out.println(oprNamesLength);

        final String str = "huvanna-1 (3)";
        final String[] s = str.split(" ");
        System.out.println(s[0]);
        /*String dhaya = "Dhayaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(dhaya.length());
        String us = "Dhay1738430472-4-38%6489e0e$6283083204832-4032gdsahjksl;d";
        String pwd = "Dhayaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaakarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrttttttttttttttttttttttttttttttttttttttttttttttttttttttt";
        System.out.println(pwd.length());
        Pojo pojo = new Pojo();
        char[] arr2 = {};
        pojo.setName(arr2);
        pojo.setAge(10);
        System.out.println(pojo);
        char[] arr1 = pojo.getName();
        System.out.println(arr1.length);
        String str = "^[\"\\']";
        String name = "Huvanna\"";
        if(str.matches(name)) {
            System.out.println("invalid chars");
        }

        String str100 = "java.lang.NullPointerException: null at com.siemens.sinecnms.common.vulnMgr.VulMgrSettingsHandler.validateFileSize(VulMgrSettingsHandler.java:168) at com.siemens.sinecnms.common.vulnMgr.VulMgrSettingsHandler.setVulMgrServerSettings(VulMgrSettingsHandler.java:114)\n";
        System.out.println(str.length());
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        long size = bytes.length/1024;
        System.out.println(size);

        String policy = "sync.1116";
        String jobId = policy.substring(policy.lastIndexOf(".") + 1);
        System.out.println("Job Id "+jobId);

        String osType = Locale.getDefault().getCountry();
        //String osType = new Locale("es","ES").getCountry();
        Locale spanishLocale = new Locale("es", "ES");
        String folderPath = "D:\\All-My-Tasks-Documents";
        String cmd ;
        if( (osType.equals(Locale.FRANCE.getCountry()) || osType.equals(Locale.ITALY.getCountry())
                || osType.equals(Locale.GERMANY.getCountry()) || osType.equals(spanishLocale.getCountry()))
        || osType.equals(Locale.US.getCountry())) {
            //System.out.println("OSType is "+osType);
            cmd = "takeown /R /d S /F ";
        } else {
            cmd = "takeown /R /d Y /F ";
        }
        cmd = cmd + folderPath;


        System.out.println(spanishLocale.getCountry());
        String osLang10 = Locale.getDefault().toString();
        if (osLang10.equalsIgnoreCase(Locale.FRANCE.toString()) || osLang10.equalsIgnoreCase(Locale.ITALY.toString())
                || osLang10.equalsIgnoreCase(Locale.US.toString()) || osLang10.equalsIgnoreCase(Locale.GERMANY.toString())
            || osLang10.equalsIgnoreCase(spanishLocale.getCountry())) {
            System.out.println("OS Lang is :" + osLang10);
        }




        String st = Locale.getDefault(Locale.Category.FORMAT).toString();
        System.out.println(st);

        String osLang = Locale.getDefault().getCountry();
        String italian = Locale.getDefault().getDisplayCountry(Locale.ITALY);
        String french = Locale.getDefault().getDisplayCountry(Locale.FRANCE);
        String germany = Locale.getDefault().getDisplayCountry(Locale.GERMANY);

        System.out.println("English "+osLang);
        System.out.println("Italian "+italian);
        System.out.println("French "+french);
        System.out.println("Germany "+germany);*/

        String enOSLang = Locale.getDefault().getDisplayLanguage();
        if (enOSLang.equalsIgnoreCase(Locale.FRANCE.getCountry()) || enOSLang.equalsIgnoreCase(Locale.ITALY.toString())
                || enOSLang.equalsIgnoreCase(Locale.ENGLISH.toString())) {
            System.out.println("OS Lang is :" + enOSLang);
        }


        String authStr = null;
        String osLang1 = Locale.getDefault().getCountry();
        System.out.println(osLang1);
        if (osLang1.equals(Locale.US.getCountry())) {
            System.out.println("OS Lang is :" + osLang1);
            authStr = "Authenticated Users";
        } else if (osLang1.equals(Locale.ITALIAN.getCountry())) {
            authStr = "Utenti autenticati";
        } else if (osLang1.equals(Locale.FRANCE.getCountry())) {
            authStr = "Utilisateurs authentifiés";
        } else if (osLang1.equals(Locale.GERMANY.getCountry())) {
            authStr = "Authentifizierte Benutzer";
        } else if (osLang1.equals(Locale.CHINESE.getCountry())) {
            authStr = "認證用戶";
        }
        System.out.println(authStr);

        /*String st43r = "huvanna";
        Path userMgMtFolder = getUserMgMtFolder();
        System.out.println(userMgMtFolder);
        resetAclPerm(userMgMtFolder);*/

        Path paths = Paths.get("D:\\Sinecnms_OSS_SourceCode");
        UserPrincipal authenticatedUsers = paths.getFileSystem().
                getUserPrincipalLookupService().lookupPrincipalByName(authStr);
        AclFileAttributeView aclView = Files.getFileAttributeView(paths, AclFileAttributeView.class);
        List<AclEntry> aclEntries = aclView.getAcl();
        if (aclView == null) {
            System.out.println("ACL view permissions are not supported");
            return;
        }
        //setAclPermissionsForUser(aclView);
        try {
            List<AclEntry> authAclEntries = new ArrayList<>();
            for (AclEntry entry : aclEntries) {
                if(entry.principal().equals(authenticatedUsers)) {
                    authAclEntries.add(entry);
                }
            }
            aclEntries.removeAll(authAclEntries);
            System.out.println(aclEntries);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        aclView.setAcl(aclEntries);
    }

    private static void verifyIfJobExeStatusIsQual(Map<String, Object> nodeDetails) {
        try {
            final String jobExeStatus = (String) nodeDetails.get("job_exe_status");
            if (String.valueOf("Waiting").equals(jobExeStatus) || String.valueOf("Running").equals(jobExeStatus)) {
                System.out.println("Job's exe status is " + jobExeStatus);
            }
        } catch (Exception e) {
            System.out.println("exception "+e);
        }
    }

    private static void resetAclPerm(final Path path) {
        try {
            /*UserPrincipal principal = FileSystems.getDefault().getUserPrincipalLookupService()
                    .lookupPrincipalByName("test");
            Set<AclEntryPermission> permissions = EnumSet.of(AclEntryPermission.READ_DATA, AclEntryPermission.WRITE_DATA);
            AclEntry aclEntry = AclEntry.newBuilder().setPrincipal(principal)
                    .setType(AclEntryType.ALLOW).setPermissions(permissions).build();
            List<AclEntry> aclEntries = aclView.getAcl();
            aclEntries.add(aclEntry);
            aclView.setAcl(aclEntries);
            System.out.println("ACL entry added successfully for the test user ");*/
            Path parentPath = Paths.get("D:\\SinecNms_Git_Code_Base\\src");
            AclFileAttributeView view = Files.getFileAttributeView(parentPath, AclFileAttributeView.class);
            List<AclEntry> aclEntries = view.getAcl();
            traverseThroughFolder(path, aclEntries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void traverseThroughFolder(Path path, List<AclEntry> aclEntries) {

        File root = new File(path.toString());
        File[] fileList= root.listFiles();
        if(fileList == null) {
            return;
        }
        try {
               for (File currentFile: fileList) {
                   if(currentFile.isDirectory()) {
                       traverseThroughFolder(currentFile.toPath(), aclEntries);
                   } else {
                       updatePerm(currentFile.toPath(), aclEntries);
                   }
               }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updatePerm(Path path, List<AclEntry> aclEntries) {
        try{
             AclFileAttributeView fileAttributeView = Files.getFileAttributeView(path, AclFileAttributeView.class);

             List<AclEntry> updatedAcl = enableInherit(aclEntries);
             if(!updatedAcl.isEmpty()) {
                 fileAttributeView.setAcl(updatedAcl);
             }
            System.out.println("updatedACL is "+fileAttributeView.getAcl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<AclEntry> enableInherit(List<AclEntry> entries) {
            List<AclEntry> newAclEntries = new ArrayList<>();
            for (AclEntry entry: entries) {
                  AclEntry aclEntry = AclEntry.newBuilder(entry)
                          .setFlags(AclEntryFlag.FILE_INHERIT, AclEntryFlag.DIRECTORY_INHERIT).build();
                  newAclEntries.add(aclEntry);
            }
            return newAclEntries;
    }

    public static Path getUserMgMtFolder() {
        Path path = null;
        try {
            path = Path.of("D:\\SinecNms_Git_Code_Base\\src\\SinecnmsCommon\\pom.xml");
            if (path.getParent() != null) {
                path = path.getParent().getParent();
                if (path != null) {
                    path = Path.of(path + File.separator + "SINECNMS_MON");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception at getUsrMgmtFolderPath: "+e);
        }
        return path;
    }
    static class  Pojo {
        private  int age;
        private char[] name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public char[] getName() {
            return name;
        }

        public void setName(char[] name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Pojo{" +
                    "age=" + age +
                    ", name=" + Arrays.toString(name) +
                    '}';
        }
    }

}
