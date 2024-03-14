package watchdog;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WatchDogService {
    public static void main(String[] args) {

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path directory = Paths.get("D:\\Watch_Dog_Service");
            WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            System.out.println("Watch service registered for the directory: "+directory.getFileName());
            while(true) {
                for (WatchEvent<?> event: watchKey.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();
                        Object fileName = event.context();
                        String kindName = kind.name();
                        System.out.println("Event Kind: "+kind+" Affected file: "+fileName+" kind name: "+kindName);
                        if((kind.equals(ENTRY_MODIFY) && (fileName.toString().equals("port_notification.txt")))) {
                            String filePath = "D:\\Watch_Dog_Service\\port_notification.txt";
                            List<String> fileContent = new ArrayList<>();
                            try {
                                 fileContent = Files.readAllLines(Paths.get(filePath));
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println(fileContent.get(fileContent.size()-1));
                            /*if(!fileContent.isEmpty()) {
                                String newPort = fileContent.get(0);
                                System.out.println("Changed Port: "+newPort);
                            }*/
                            System.out.println("file: "+fileName+ " has been modified");
                        }
                       boolean valid = watchKey.reset();
                       if (!valid) {
                           break;
                       }
                    }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
