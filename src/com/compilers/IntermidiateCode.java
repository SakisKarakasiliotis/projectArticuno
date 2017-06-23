package com.compilers;

import java.util.*;


public class IntermidiateCode {

    private List<Quads> quads;

    private Stack<List<Integer>> trueStack;

    private Stack<List<Integer>> falseStack;

    private Stack<List<Quads>> nextStack = new Stack<>();

    private int temp;

    public IntermidiateCode() {
        this.quads = new LinkedList<>();
        trueStack = new Stack<>();
        falseStack = new Stack<>();

        this.temp = 0;
    }

    public IntermidiateCode(List<Quads> quads) {
        this.quads = new LinkedList<>();
        trueStack = new Stack<>();
        falseStack = new Stack<>();
        this.quads = quads;
        this.temp = 0;
    }

    public List<Quads> getQuads() {
        return quads;
    }

    public void setQuads(List<Quads> quads) {
        this.quads = quads;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void genTrueList() {
        trueStack.push(new LinkedList<Integer>());
    }

    public void genFalseList() {
        falseStack.push(new LinkedList<Integer>());
    }

    public void addTrue(int label) {
        trueStack.get(trueStack.size() - 1).add(label);
    }

    public void addFalse(int label) {
        falseStack.get(falseStack.size() - 1).add(label);
    }

    public void backpatch(boolean instack, int goalId) {
        if (instack) {
            List<Integer> trueList = trueStack.pop();
            List<Quads> nextList = nextStack.get(nextStack.size() - 1);
            for (int label : trueList) {
                nextList.get(label).setRet(Integer.toString(goalId));
            }
        } else {
            List<Integer> falseList = falseStack.pop();
            List<Quads> nextList = nextStack.get(nextStack.size() - 1);
            for (int label : falseList) {
                nextList.get(label).setRet(Integer.toString(goalId));
            }
        }
    }

    @Override
    public String toString() {
        return "IntermidiateCode{" +
                "quads=" + quads +
                '}';
    }

    public Stack<List<Integer>> getTrueStack() {
        return trueStack;
    }

    public Stack<List<Integer>> getFalseStack() {
        return falseStack;
    }

    public Stack<List<Quads>> getNextStack() {
        return nextStack;
    }

    public void genQuad(Quads.Operand op, String arg1, String arg2, int ret) {
        int label = nextStack.get(nextStack.size() - 1).size();
        String retReg = "-";

        if (ret != -1) {
            retReg = "$" + ret;
        }
        if (arg1.equals("")) {
            arg1 = "-";
        }
        if (arg2.equals("")) {
            arg2 = "-";
        }
        String operand = Quads.Operand.operand.getOperand(op);
        Quads q = new Quads(label, operand, arg1, arg2, retReg);
        this.nextStack.get(nextStack.size() - 1).add(q);
    }

    public int nextQuad() {
        return nextStack.get(nextStack.size() - 1).size();
    }

    public int newTemp() {
        return ++temp;
    }

    public void newList() {
        nextStack.push(new LinkedList<Quads>());
    }

    public void merge() {
        List<Quads> toBeMerged = nextStack.pop();
        String name = toBeMerged.get(0).getArg1();
        genQuad(Quads.Operand.ENDU, name, "-", -1);
        int size = quads.size();
        for (Quads q : toBeMerged) {
            q.setLabel(q.getLabel() + size);
            quads.add(q);
        }
        String operand = Quads.Operand.operand.getOperand(Quads.Operand.ENDU);
        quads.add(new Quads(quads.size(), operand, name, "-", "-"));
    }

    public void falseMerge() {
        List<Integer> a = falseStack.pop();
        List<Integer> b = falseStack.pop();
        a.addAll(b);
        falseStack.push(a);
    }

    public void trueMerge() {
        List<Integer> a = trueStack.pop();
        List<Integer> b = trueStack.pop();
        a.addAll(b);
        trueStack.push(a);
    }
}
