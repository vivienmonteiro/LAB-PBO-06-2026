import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger{
    private List<String> logs;

    public LibraryLogger(){
        logs = new ArrayList<>();
    }
    public String LogActivity (String activity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

        String time = LocalDateTime.now().format(formatter);
        String log = "["+ time +"]" + activity;

        logs.add(log);
        return log;
    }

    public String getLogs(){
        if(logs.isEmpty()){
            return "Belum ada log aktivitas";
        }

        StringBuilder sb = new StringBuilder();

        for (String log : logs){
            sb.append(log).append("\n");
        }
        return sb.toString();
    }
    public void clearLogs(){
        logs.clear();
    }
}