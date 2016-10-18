import org.junit.Test;

import static org.junit.Assert.*;

public class JsonToJavaParserTest {
    @Test
    public void TestDataParser() throws Exception {
        JsonToJavaParser jsonToJavaParser = new JsonToJavaParser();
        jsonToJavaParser.parse("/Users/basava/work_space/session2/automata/dfa/src/data.json");
    }
}