package strings;


import java.util.List;

public class KillJavaProcess {
    public static void main(String[] args) {

        List<String> commands = List.of("cmd", "/c", "TASKKILL /F /IM java.exe /T ");
        try{
            String strCommandLine = null;
            strCommandLine = "TASKKILL /F /IM java.exe /T ";
            Runtime.getRuntime().exec(strCommandLine);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleResources(final Process p) {
        if (p != null) {
            if (p.getOutputStream() != null) {
                try {
                    p.getOutputStream().close();
                } catch (Exception e) {

                }
            }
            if (p.getErrorStream() != null) {
                try {
                    p.getErrorStream().close();
                } catch (Exception e) {

                }
            }
            if (p.getInputStream() != null) {
                try {
                    p.getInputStream().close();
                } catch (Exception e) {

                }
            }
        }
    }
}
