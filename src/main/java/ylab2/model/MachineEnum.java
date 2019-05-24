package ylab2.model;


public enum MachineEnum {
    OLDF20("28ad18ae3ebb4f91b1d52553019ca381", "老f20"),
    NEWF20("563e690aae7b41dfb6da1880f291e65b", "新f20"),
    OLDSAC("7d43a6f731aa415594fca7ed3de8b935", "老球差"),
    FIB("23ba4d2d9470434a905b4049ef457648","fib"),
    NONE("","无");
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    MachineEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public static String getCodeByName(String name){
        for(MachineEnum machine:MachineEnum.values()){
            if(name.equals(machine.name)){
                return machine.code;
            }
        }
        return null;
    }

}
