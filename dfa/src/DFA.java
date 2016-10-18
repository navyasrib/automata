public class DFA {
    public static void main(String[] args) {
        JsonToJavaParser jsonToJavaParser = new JsonToJavaParser();
        MachineData dfaData = jsonToJavaParser.parse("data.json");
        check(dfaData);
    }

    private static void check(MachineData dfaData) {
        Tuple tuple = dfaData.getTuple();
        Delta delta = new Delta(tuple.getDelta());
        DFATuple dfaTuple = new DFATuple(tuple.getStart_state(), tuple.getAlphabets(), tuple.getStates(), delta, tuple.getFinal_states());
        Boolean passCases = isValid(dfaTuple, dfaData.getPass_cases());
        Boolean failCases = !isValid(dfaTuple, dfaData.getFail_cases());
        if(passCases && failCases)
            System.out.println("Your DFA is working fine :)");
        else
            System.out.println("Your DFA has some bug, feel free to resolve it :)");

    }

    private static Boolean isValid(DFATuple dfaTuple, String[] cases) {
        Boolean isValid = false;
        for (String input : cases) {
            isValid = dfaTuple.isAccept(input);
        }
        return isValid;
    }
}
