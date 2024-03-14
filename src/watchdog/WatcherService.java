package watchdog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WatcherService {

    private static final Logger logger = LoggerFactory.getLogger(WatcherService.class);
    private static final String DIRECTORY = "D:\\Siemens\\SINECNMS_MON\\Sinema_Server_Monitor\\portNotification";
    private static final String DIRECTORY1 = "D:\\Siemens1\\SINECNMS\\SINECNMS";
    private static final String FILE_NAME = "httpsControlPort.txt";
    private static Set<String> controlPorts = new LinkedHashSet<>();

    public static void main(String[] args) {
        try( WatchService watchService = FileSystems.getDefault().newWatchService()) {
            Path dir = Paths.get(DIRECTORY);
            dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            WatchKey key;
            while (true) {
                try {
                    Path paths = Paths.get(DIRECTORY1).getParent().getParent();
                    String str = Paths.get(DIRECTORY).toString().concat(File.separator).concat("Dhaya.txt").concat(File.separator);
                    key = watchService.poll(25, TimeUnit.MILLISECONDS);
                    Path path = Paths.get(DIRECTORY+"\\"+FILE_NAME).getParent();
                   // System.out.println(path);
                } catch (InterruptedException e) {
                    System.out.println("Exception occurred while reading the watch service: "+e);
                    return;
                }
                if (key == null) {
                    Thread.yield();
                    continue;
                }
                key.pollEvents().forEach(watchEvent -> {
                    WatchEvent.Kind<?> kind = watchEvent.kind();
                    Object fileName = watchEvent.context();
                    if ((kind.equals(ENTRY_MODIFY)) && (fileName.toString().equals(FILE_NAME))) {
                        try{
                            //int j = 10/0;
                            controlPorts = new LinkedHashSet<>(Files.readAllLines(Paths.get( FILE_NAME)));
                        } catch (IOException  e) {
                            logger.info("Exception on reading the changed file ",e);
                        }
                    }
                    /*System.out.println("New control port has been added");
                    String[] allPorts = controlPorts.toArray(new String[0]);
                    String newPort = allPorts[controlPorts.size()-1];
                    System.out.println("Newly added control port is: "+newPort);*/
                });
                boolean valid = key.reset();
                if (!valid) {
                    System.out.println("Key has been un registered");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while creating the watch service instance "+e);
        }
    }
}
