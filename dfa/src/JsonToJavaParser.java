import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonToJavaParser {

    public MachineData parse(String fileName) {
        String json = "{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}";
        ObjectMapper objectMapper = new ObjectMapper();
        MachineData values = null;
        try {
            values = objectMapper.readValue(json, MachineData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }
}
