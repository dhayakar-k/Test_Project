package watchdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class SecondExample {
    public static void main(String[] args) throws IOException {

        getLocalSysFQDN();
    }
    public static String getLocalFqdnDetails() throws SocketException, UnknownHostException {
        String ipv4Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
        String ipv6Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
        String localFqdn = "";
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface ni = networkInterfaces.nextElement();
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress inetAddress = addresses.nextElement();
                localFqdn = InetAddress.getLocalHost().getCanonicalHostName();
                boolean isMatched = Pattern.compile(ipv4Pattern).matcher(inetAddress.getHostAddress()).matches();
                // || Pattern.compile(ipv6Pattern).matcher(inetAddress.getHostAddress()).matches();
                if (isMatched) {
                    System.out.println(inetAddress.getHostAddress());
                }
                boolean isFqdnMatched = Pattern.compile(ipv4Pattern).matcher(localFqdn).matches();
                if (isFqdnMatched) {
                    System.out.println("FQDN IP is same as local IP: ");
                }
                System.out.println("FQDN IP: "+localFqdn);
            }
        }
        return localFqdn;
    }
    public static String getLocalSysFQDN() throws IOException {
        String localFqdn = getLocalFqdnDetails();
        /*if(localFqdn == null || localFqdn.isEmpty()) {*/
          final String command = "ipconfig";
          final Process process = Runtime.getRuntime().exec(command);
          try(BufferedReader bufferedReader = new BufferedReader(
               new InputStreamReader(process.getInputStream()))) {
              String line;
              while ((line= bufferedReader.readLine())!=null) {
                  if(line.contains("primary Dns") || line.contains("res DNS-Suffix")) {
                      String[] primDns = line.split(":");
                      if(primDns.length > 0) {
                          localFqdn = primDns[1].trim();
                          break;
                      }
                  }
              }
          }
        /*}*/
        System.out.println("getLocalSysFQDN: "+localFqdn);
        return localFqdn;
    }
}
