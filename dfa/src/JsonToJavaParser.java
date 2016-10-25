import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonToJavaParser {

    public ArrayList<MachineData> parse(String fileName) throws FileNotFoundException {
        String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        String jsonData = content.replace("\\", "").replace("start-state","start_state").replace("final-states","final_states").replace("pass-cases","pass_cases").replace("fail-cases","fail_cases");
        String dataToParse = jsonData.substring(1,jsonData.length()-1);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<MachineData> values = new ArrayList<>();
        try {
            values = objectMapper.readValue(dataToParse, new TypeReference<List<MachineData>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(values.get(0).getTuple().getClass());
        return values;
    }
}
