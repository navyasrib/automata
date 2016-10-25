import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DFA {
    public static void main(String[] args) throws FileNotFoundException {
        JsonToJavaParser jsonToJavaParser = new JsonToJavaParser();
        ArrayList<MachineData> dfaData = jsonToJavaParser.parse("/Users/basava/work_space/session2/automata/dfa/src/data.json");
        validateAllMachines(dfaData);
    }

    private static void validateAllMachines(ArrayList<MachineData> dfaData) {
        for (MachineData data : dfaData) {
            check(data);
        }
    }

    private static void check(MachineData dfaData) {
        Tuple tuple = dfaData.getTuple();
        Delta delta = new Delta(tuple.getDelta());
        DFATuple dfaTuple = new DFATuple(tuple.getStart_state(), tuple.getAlphabets(), tuple.getStates(), delta, tuple.getFinal_states());
        Boolean passCases = isValid(dfaTuple, dfaData.getPass_cases());
        Boolean failCases = isInValid(dfaTuple, dfaData.getFail_cases());
        if(passCases && failCases)
            System.out.println("Your DFA is working fine :)");
        else
            System.out.println("Your DFA has some bug, feel free to resolve it :)");

    }

    private static Boolean isInValid(DFATuple dfaTuple, String[] failCases) {
        int inValidCaseCount = 0;
        for (String input : failCases) {
            if(!dfaTuple.isAccept(input))
                inValidCaseCount += 1;
        }
        return inValidCaseCount == failCases.length;
    }

    private static Boolean isValid(DFATuple dfaTuple, String[] passCases) {
        int validCaseCount = 0;
        for (String input : passCases) {
            if(dfaTuple.isAccept(input))
                validCaseCount += 1;
        }
        return validCaseCount == passCases.length;
    }
}
