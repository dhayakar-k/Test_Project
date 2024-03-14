package strings;



import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SiemensSinec {

    public static Set<Employee> getDbEmployees() {

        Set<Employee> dbEmployees = new HashSet<>();
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Arun");
        dbEmployees.add(emp1);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("Dhaya");
        dbEmployees.add(emp2);

        Employee emp3 = new Employee();
        emp3.setId(3);
        emp3.setName("Arjun");
        dbEmployees.add(emp3);

        Employee emp4 = new Employee();
        emp4.setId(4);
        emp4.setName("Rohith");
        dbEmployees.add(emp4);

        return dbEmployees;
    }


   public static void testCollectionUtilsSubtract() {
       List<Employee> vilocifyNames = new ArrayList<>();

       Employee emp1 = new Employee();
       emp1.setId(1);
       emp1.setName("Arun");
       vilocifyNames.add(emp1);

       Employee emp2 = new Employee();
       emp2.setId(2);
       emp2.setName("Dhaya");
       vilocifyNames.add(emp2);

       Employee emp3 = new Employee();
       emp3.setId(3);
       emp3.setName("Arjun");
       vilocifyNames.add(emp3);

       Employee emp4 = new Employee();
       emp4.setId(4);
       emp4.setName("Rohith");
       vilocifyNames.add(emp4);

       Employee emp5 = new Employee();
       emp5.setId(5);
       emp5.setName("Naresh");
       vilocifyNames.add(emp5);

       Employee emp6 = new Employee();
       emp6.setId(6);
       emp6.setName("Huvanna");
       vilocifyNames.add(emp6);

       /*vilocifyNames = vilocifyNames.stream().filter(employee -> employee.getName()!= null).collect(Collectors.toList());
       vilocifyNames.forEach(System.out::println);*/
      /* String str = String.valueOf(vilocifyNames.stream().filter(employee -> employee.getName()!= null));
       Set<Integer> ids = vilocifyNames.stream().map(Employee::getId).collect(Collectors.toSet());
       System.out.println(ids);
       final List<String> ids1 =  ids.stream().map(Objects::toString).collect(Collectors.toList());
       System.out.println(ids);*/
      // System.out.println(str);

       Set<Employee> vilocifyEmployees = new HashSet<>();
       vilocifyEmployees.add(emp1);
       vilocifyEmployees.add(emp2);
       vilocifyEmployees.add(emp3);
       vilocifyEmployees.add(emp4);
       vilocifyEmployees.add(emp5);
       vilocifyEmployees.add(emp6);
       /*dbNames.add(emp5);
       dbNames.add(emp6);*/
       Set<Employee> dbEmployees = getDbEmployees();
       //Set<Employee> newEmployeeList = vilocifyEmployees.stream().filter(e-> !dbEmployees.contains(e)).collect(Collectors.toSet());
       Set<Employee> newEmployeeList = new HashSet<>(CollectionUtils.subtract(vilocifyEmployees, dbEmployees));
       System.out.println("===New Employees to be added to DB===");
       newEmployeeList.forEach(System.out::println);

       Set<Employee> duplicateEntryList = newEmployeeList.stream().filter(dbEmployees::contains).collect(Collectors.toSet());
       System.out.println("=== Duplicate Employees List ===");
       duplicateEntryList.forEach(emp-> {
           System.out.println(emp.getId()+" "+emp.getName());
       });

       Collection<Employee> dbEmpList = getMissingEmployeesFromDB();
       Collection<Employee> vilocifyEmpList = getVilocifyEmpList();
       Set<Employee> employeesToBeUpdated = new HashSet<>(CollectionUtils.subtract(dbEmpList, vilocifyEmpList));
       System.out.println("===Employees to be updated ===");
       employeesToBeUpdated.forEach(System.out::println);


    }

    static Set<Employee> getMissingEmployeesFromDB() {
        Set<Employee> dbList = new HashSet<>();

        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Arun");
        dbList.add(emp1);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("Dhaya");
        dbList.add(emp2);

        Employee emp3 = new Employee();
        emp3.setId(3);
        emp3.setName("Arjun");
        dbList.add(emp3);

        Employee emp4 = new Employee();
        emp4.setId(4);
        emp4.setName("Arya");
        dbList.add(emp4);

        Employee emp5 = new Employee();
        emp5.setId(5);
        emp5.setName("Vikhyat");
        dbList.add(emp5);

        Employee emp6 = new Employee();
        emp6.setId(6);
        emp6.setName("Ravi");
        dbList.add(emp6);

        return dbList;
    }
    static Set<Employee> getVilocifyEmpList() {
        Set<Employee> dbList = new HashSet<>();

        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Arun");
        dbList.add(emp1);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("Dhaya");
        dbList.add(emp2);

        Employee emp3 = new Employee();
        emp3.setId(3);
        emp3.setName("Arjun");
        dbList.add(emp3);

        /*Employee emp4 = new Employee();
        emp4.setId(4);
        emp4.setName("Arya");
        dbList.add(emp4);

        Employee emp5 = new Employee();
        emp5.setId(5);
        emp5.setName("Vikhyat");
        dbList.add(emp5);

        Employee emp6 = new Employee();
        emp6.setId(6);
        emp6.setName("Ravi");
        dbList.add(emp6);*/

        return dbList;
    }



    public static void executeTimerTask() {
        try {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    for(int i=1; i<=2000; i++) {
                        System.out.println("Calling XYZ "+i+"st time");
                    }
                }
            };

            timer.schedule(timerTask,2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   static void testApacheListUtilsSubtract() {
       List<String> viloCities = new ArrayList<>(List.of("BLR", "HYD", "CHENNAI", "PUNE", "NOIDA", "AHMD"));
       List<String> dbCities = new ArrayList<>(List.of("CHENNAI", "PUNE", "NOIDA", "AHMD"));
       List<String> newCities = ListUtils.subtract(viloCities, dbCities);
       newCities.forEach(System.out::println);

       List<String> viloCities1 = new ArrayList<>(List.of("CHENNAI", "PUNE", "NOIDA", "DELHI"));
       List<String> dbCities1 = new ArrayList<>(List.of("BLR", "HYD", "CHENNAI", "PUNE", "NOIDA", "DELHI"));
       List<String> citiesToBeUpdated = ListUtils.subtract(dbCities1, viloCities1);
       citiesToBeUpdated.forEach(System.out::println);
    }

    static void testUsingJava8Streams() {
        List<String> viloCities = new ArrayList<>(List.of("BLR", "HYD", "CHENNAI", "PUNE", "NOIDA", "DELHI"));
        List<String> dbCities = new ArrayList<>(List.of("CHENNAI", "PUNE", "NOIDA", "DELHI"));
        List<String> newCities = viloCities.stream().filter(e -> !dbCities.contains(e)).collect(Collectors.toList());
        newCities.forEach(System.out::println);


        List<String> dbCities1 = new ArrayList<>(List.of("BLR", "HYD", "CHENNAI", "PUNE", "NOIDA", "DELHI"));
        List<String> viloCities1 = new ArrayList<>(List.of("CHENNAI", "PUNE", "NOIDA", "DELHI"));
        List<String> citiesToBeUpdatedInDB = dbCities1.stream().filter(e-> !viloCities1.contains(e)).collect(Collectors.toList());
        citiesToBeUpdatedInDB.forEach(System.out::println);

    }
    static Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b",20);
        return map;
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Set<String> dbIds = new HashSet<>(Arrays.asList("Dhaya", "Viru"));
        System.out.println(dbIds);

        /* String str = "V2.0";
         String version = str.substring(1);
         System.out.println(version);*/
        //String s = String.valueOf(null);
         testCollectionUtilsSubtract();
         //testApacheListUtilsSubtract();
         //testUsingJava8Streams();
        // executeTimerTask();

       /*String str = "742804~^SNMCMNMEWNK152R367890~~~~~`~+923943HQWHQJWEWJQKWEJEWQWEWEWQQWQWQWWWHJRJKRKJJ9333333933333333";
        String neem = "gkpg[x\\HkMeonA1<E@^ExEyrLBqTN~";
        String ashwa = "123";
        final String VUL_MGR_PWD_PATTERN = "^[a-zA-Z_0-9@\\!#\\$\\^%&*()+=\\-[]\\\\\\';,\\.\\/\\{\\}\\|\\\":<>\\? ]]+$";
        Pattern pattern = Pattern.compile(VUL_MGR_PWD_PATTERN);
        Matcher matcher = pattern.matcher(ashwa);
        if(matcher.matches()) {
            System.out.println("PWd looks fine");
        } else {
            System.out.println("Pwd has invalid characters");
        }
        String str5 = "https://saturn.tfs.siemens.net/tfs/DCP/SINEC_NMS/_git/SINECNMS_OSS_SOURCECODE";
        String str6 = "https://saturn.tfs.siemens.net/tfs/DCP/SINEC_NMS/_git/SINECNMS_OSS_SOURCECODE";
        List<Employee> employeeList = new ArrayList<>();
        String employeeString = String.valueOf(employeeList);
        getEmpList();
        String empString = covertListToString(employeeList);
        System.out.println(empString);*/
        /*char ch ='G';
        System.out.println(ch);

        String str = String.valueOf(ch);
        System.out.println(str);

        Character character = ch;
        System.out.println(character);

        String geekString = "GeeksForGeeks";
        //char[] charArray = geekString.toCharArray();
        String[] stArray = geekString.split("");
        char[] chars = new char[stArray.length];
        int j = 0;
        for (String chara : stArray) {
            chars[j++] = chara.charAt(0);
            System.out.print(chara+" ");
            //System.out.println(" J value " + j);
        }
        System.out.println();
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }*/

        /*Set<String> stringSet = new HashSet<>(List.of(geekString));
        String[] arrayOfStrings = stringSet.toArray(new String[0]);
        System.out.println(Arrays.toString(arrayOfStrings));

        CharacterIterator chrItr = new StringCharacterIterator(geekString);
        while (chrItr.current() != CharacterIterator.DONE) {
            System.out.print(chrItr.current());
            System.out.print(" ");
            chrItr.next();
        }

        //convert string to integer array
        String string = "[ 10, 20, 30, 40]";
        String[] strArray = string.replaceAll("\\[","").
                replaceAll("]", "").split(",");
        int arrLength = strArray.length;
        int[] intArray = new int[arrLength];
        for (int i=0; i < arrLength; i++) {
            intArray[i] = Integer.parseInt(strArray[i].trim());
        }
        System.out.println(Arrays.toString(intArray));*/

       /* char[] charArray = {'a','b','c','d'};
        printAllSubStrings(charArray);



        Map<String, Integer> map = new LinkedHashMap<>();
        String str8 = "Java is great Python is also great";
        String[] words = str8.split("\\W");

        for(String word: words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }
        for(Map.Entry<String, Integer> m: map.entrySet()) {
            if (m.getValue() == 1) {
                System.out.print(m.getKey()+" ");
            }
        }

        String str = "https://172.16.123.69:8443/sinecnmsWebappControl";
        final String[] ipPortArray = str.substring(0, str.indexOf("/sinecnmsWebappControl")).
                replace("https://","").split(":");
        final String nodeIp = ipPortArray[0];
        System.out.println("nodeIp "+nodeIp);
        final String port = ipPortArray[1];
        System.out.println("port "+port);


        List<String> stringList = getArrayList();
        if( stringList.size() > 0 && stringList.get(0) != null) {
            System.out.println(stringList);
        }*/

        // for maven running
       /* List<String> command = Arrays.asList("cmd", "/c","mvn clean install -Dmaven.test.skip=true");
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);
        pb.directory(new File("D:\\SinecNms_Git_Code_Base\\src"));
        Process process = pb.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        closeProcess(process);*/
    }

    private static String covertListToString(List<Employee> employeeList) {
      return String.valueOf(employeeList);
    }

    private static List<Employee> getEmpList() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Dhaya");
        employeeList.add(employee);

        Employee employee1 = new Employee();
        employee1.setId(2);
        employee1.setName("Arun");
        employeeList.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId(3);
        employee2.setName("Arjun");
        employeeList.add(employee2);

        Employee employee3 = new Employee();
        employee3.setId(4);
        employee3.setName("Rohith GS");
        employeeList.add(employee3);

        Employee employee4 = new Employee();
        employee4.setId(5);
        employee4.setName("Arya");
        employeeList.add(employee4);

        Employee employee5 = new Employee();
        employee5.setId(6);
        employee5.setName("Vikhyat");
        employeeList.add(employee5);

        Employee employee6 = new Employee();
        employee6.setId(7);
        employee6.setName("Indu");
        employeeList.add(employee6);

        Employee employee7 = new Employee();
        employee7.setId(8);
        employee7.setName("Ramesh");
        employeeList.add(employee7);

        Employee employee8 = new Employee();
        employee8.setId(9);
        employee8.setName("Sharath");
        employeeList.add(employee8);

        Employee employee9 = new Employee();
        employee9.setId(10);
        employee9.setName("Sabari");
        employeeList.add(employee9);
        return employeeList;
    }

    private static void printAllSubStrings(char[] charArray) {
        int size = charArray.length;
        for(int len = 1; len <= size ; len++) {
            for(int i=0; i < size-len; i++) {
                int j= i+len-1;
                for (int k=i; k <=j; k++) {
                    System.out.print(charArray[k]);
                }
                System.out.println();
            }
        }
    }

    private static List<String> getArrayList() {
        return new ArrayList<>();
    }

    private static void closeProcess(Process process) {
        if (process != null) {
            if (null != process.getOutputStream()) {
                try {
                    process.getOutputStream().close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (null != process.getErrorStream()) {
                try {
                    process.getErrorStream().close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (null != process.getInputStream()) {
                try {
                    process.getInputStream().close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
