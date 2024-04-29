package calculator;

public enum OperateType {
    ADD,SUBTRACT,MULTIPLY,DIVIDE,MOD;
    public static OperateType convert(char op){
        if(op=='+') return ADD;
        else if(op=='-') return SUBTRACT;
        else if(op=='*') return MULTIPLY;
        else if(op=='/') return DIVIDE;
        else if(op=='%') return MOD;
        return null;
    }
}
