package com.compilers;


/**
 * Created by Windows 8 on 21-Jun-17.
 */
public class Quads {

    private int label;

    private String op;

    private String arg1;

    private String arg2;

    private String ret;

    public Quads(int label, String op, String arg1, String arg2, String ret) {
        this.label = label;
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.ret = ret;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }


    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }


    @Override
    public String toString() {
        return "Quads{" +
                "label=" + label +
                ", op='" + op + '\'' +
                ", arg1='" + arg1 + '\'' +
                ", arg2='" + arg2 + '\'' +
                ", ret='" + ret + '\'' +
                '}';
    }

    public enum Operand {
        UNIT,
        ENDU,
        PLUS,
        MINUS,
        TIMES,
        DIV,
        MOD,
        ASSIGN,
        ARRAY,
        RELOP,
        LT,
        GT,
        LET,
        GET,
        EQ,
        NEQ,
        IFB,
        JUMP,
        LABEL,
        JUMPL,
        CALL,
        PAR,
        RET,
        DEFAULT,
        operand;

        public String getOperand(Operand x) {
            switch (x) {
                case UNIT:
                    return "unit";
                case ENDU:
                    return "endu";
                case PLUS:
                    return "+";
                case MINUS:
                    return "-";
                case TIMES:
                    return "*";
                case DIV:
                    return "/";
                case MOD:
                    return "%";
                case ASSIGN:
                    return ":=";
                case ARRAY:
                    return "array";
                case RELOP:
                    return "relop";
                case LT:
                    return "<";
                case GT:
                    return ">";
                case LET:
                    return "<=";
                case GET:
                    return ">=";
                case EQ:
                    return "=";
                case NEQ:
                    return "!=";
                case IFB:
                    return "ifb";
                case JUMP:
                    return "jump";
                case LABEL:
                    return "label";
                case JUMPL:
                    return "jumpl";
                case CALL:
                    return "call";
                case PAR:
                    return "par";
                case RET:
                    return "ret";
                case DEFAULT:
                    return "default";
                default:
                    return null;
            }
        }
    }

}
