public class MachineData {
    private String type;
    private String name;
    private Tuple tuple;
    private String[] pass_cases;
    private String[] fail_cases;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTuple(Tuple tuple) {
        this.tuple = tuple;
    }

    public void setPass_cases(String[] pass_cases) {
        this.pass_cases = pass_cases;
    }

    public void setFail_cases(String[] fail_cases) {
        this.fail_cases = fail_cases;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Tuple getTuple() {
        return tuple;
    }
    public String[] getPass_cases() {
        return pass_cases;
    }

    public String[] getFail_cases() {
        return fail_cases;
    }
}
