import java.io.*;

public class Controller {

    public Controller(){
        super();
    }

    public void lerJSON() throws Exception {

        File arq = new File("C:\\TEMP", "wiki.json");

        if (arq.exists() && arq.isFile()) {
            try (BufferedReader buffer = new BufferedReader(new FileReader(arq))) {
                String line;
                while((line = buffer.readLine()) != null) {
                   line = line.trim();
                    if(line.startsWith("\"timestamp\": ") && line.endsWith("00\",")){
                        line = line.replaceAll("\\D+","");
                        System.out.print("timestamp: "+line.substring(0, line.length() - 2));
                   }
                    if(line.startsWith("\"views\": ")){
                        line = line.replaceAll("\\D+","");
                        System.out.println(" - views: "+ line );
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
