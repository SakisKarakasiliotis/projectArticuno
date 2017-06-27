package com.compilers;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Windows 8 on 09-Apr-17.
 */

//todo: bsort + arrays
public class SemanticAnalyzer extends DepthFirstAdapter {
    /**********************************************************************/
    /********************VARIABLES**************************/
    /**********************************************************************/
    int arrayDimensions = 0;

    int assignStackLimit = 0;

    Map<String, Integer> varLocations = new HashMap<>();

    Map<String, String> stringLiteral = new HashMap<>();

    IntermidiateCode InterCode = new IntermidiateCode();

    List<symbolTableEntry> fParams = new LinkedList<>();

    Stack<symbolTableEntry> assignStack = new Stack<>();

    Stack<symbolTableEntry> returnStack = new Stack<>();

    List<String> errorLog = new LinkedList<>();

    SymbolTable symbolTable = new SymbolTable();
    /**********************************************************************/
    /**********************************************************************/
    /**********************************************************************/


    public void outAProgramProgram(AProgramProgram node) {
        for (String e : errorLog) {
            System.out.println("ERROR: " + e);
        }
        if (errorLog.isEmpty()) {
            InterCode.print(true);

        }
    }

    public void inAFunctionDefinitionFunctionDefinition(AFunctionDefinitionFunctionDefinition node) {
        symbolTable.enter();
    }

    public void outAFunctionDefinitionFunctionDefinition(AFunctionDefinitionFunctionDefinition node) {
        symbolTableEntry s = symbolTable.getFunctionEntry();
        String sRetType = s.getRetType();
        while (!returnStack.isEmpty()) {
            symbolTableEntry e = returnStack.pop();
            if (!sRetType.contains(e.getRetType())) {
                errorLog.add("Invalid return type on " + s.getId());
            }
        }
        try {
            PrintWriter writer = new PrintWriter("assembly.s", "UTF-8");
            finalCode fCode = new finalCode(varLocations,stringLiteral,symbolTable);
            List<Quads> quads = InterCode.getNextStack().peek();
            for (Quads q: quads) {
                fCode.genFinalCode(q,writer);
            }
            writer.close();
        } catch (IOException e) {
            System.err.printf("FILE I/O error: %s\n", e.getMessage());
        }

        InterCode.merge();
        symbolTable.exit();
    }

    public void caseAHeaderHeader(AHeaderHeader node) {
        inAHeaderHeader(node);
        String id = node.getIdentifier().toString();
        String parentClass = node.parent().getClass().toString();
        EntryType et = EntryType.entryType;
        String retType = node.getRetType().toString();
        symbolTableEntry s = symbolTable.lookupWithScope(id);
        if (et.getEntryType(parentClass) == EntryType.FUNC_DEF) {
            InterCode.newList();
            InterCode.genQuad(Quads.Operand.UNIT, node.getIdentifier().getText(), "-", -1);
        }
        if (s == null) {

            if (node.getFparDefinition() != null) {
                node.getFparDefinition().apply(this);
            }
            {
                List<PNextFparDefinition> copy = new ArrayList<PNextFparDefinition>(node.getNextFparDefinition());
                for (PNextFparDefinition e : copy) {
                    e.apply(this);
                }
            }
            symbolTableEntry temp = new symbolTableEntry(id, EntryType.FUNC_NAME, et.getEntryType(parentClass));
            temp.setfParams(fParams);
            temp.setRetType(retType);
            int insert = symbolTable.insertToParent(temp);
        } else {
            if (Objects.equals(s.getParent(), EntryType.FUNC_DECL) && Objects.equals(et.getEntryType(parentClass), EntryType.FUNC_DEF)) {
                //ok but have to check params
                if (node.getFparDefinition() != null) {
                    node.getFparDefinition().apply(this);
                }
                {
                    List<PNextFparDefinition> copy = new ArrayList<PNextFparDefinition>(node.getNextFparDefinition());
                    for (PNextFparDefinition e : copy) {
                        e.apply(this);
                    }
                }
                List<symbolTableEntry> result = s.getfParams();
                if (!result.equals(fParams) || !s.getRetType().equals(retType)) {

                    errorLog.add("definition of " + id + " doesn't match declaration on line " + node.getIdentifier().getLine() + " " + node.getIdentifier().getPos());
                } else {
                    symbolTableEntry temp = new symbolTableEntry(id, EntryType.FUNC_NAME, et.getEntryType(parentClass));
                    temp.setfParams(fParams);
                    temp.setRetType(retType);
                    int insert = symbolTable.insertToParent(temp);
                }

            } else if (Objects.equals(s.getParent(), EntryType.FUNC_DEF) && Objects.equals(et.getEntryType(parentClass), EntryType.FUNC_DECL)) {
                errorLog.add("definition of " + id + " must not proceed declaration on line " + node.getIdentifier().getLine() + " " + node.getIdentifier().getPos());
            } else {
                errorLog.add("Redeclaration of " + id + " on line " + node.getIdentifier().getLine() + " " + node.getIdentifier().getPos());
            }
        }
        outAHeaderHeader(node);
    }

    public void outAHeaderHeader(AHeaderHeader node) {
        fParams.clear();
    }

    public void caseAFparDefinitionFparDefinition(AFparDefinitionFparDefinition node) {
        inAFparDefinitionFparDefinition(node);
        String parName = node.getIdentifier().toString();
        String parType = node.getFparType().toString().replace(" ", "");
        symbolTableEntry temp = new symbolTableEntry(parName, EntryType.FUNC_PARAM);
        temp.setfParType(parType);
        temp.setRetType(parType);
        temp.setInitialized(true);
        if (node.getKwRef() != null) {
            temp.setReference(true);
        }
        fParams.add(temp);
        varLocations.put(parName.trim(), -666);
        List<PNextIdentifier> copy = new ArrayList<PNextIdentifier>(node.getNextIdentifier());
        for (PNextIdentifier e : copy) {
            symbolTableEntry nextTemp = new symbolTableEntry(e.toString(), EntryType.FUNC_PARAM);
            nextTemp.setfParType(parType);
            nextTemp.setRetType(parType);
            nextTemp.setInitialized(true);
            if (node.getKwRef() != null) {
                nextTemp.setReference(true);
            }
            fParams.add(nextTemp);
            varLocations.put(e.toString().trim(), -666);
        }
        outAFparDefinitionFparDefinition(node);
    }

    public void caseAVarDefinitionVarDefinition(AVarDefinitionVarDefinition node) {
        inAVarDefinitionVarDefinition(node);
        String parName = node.getIdentifier().toString();
        String parType = node.getType().toString();
        symbolTableEntry temp = new symbolTableEntry(parName, EntryType.VAR);
        temp.setfParType(parType);
        temp.setRetType(parType);
        symbolTableEntry s = symbolTable.lookup(parName, EntryType.VAR);
        if (s == null) {
            symbolTable.insert(temp);
        } else {
            errorLog.add("Redefinition of variable " + parName + " on line " + node.getIdentifier().getLine() + " " + node.getIdentifier().getPos());
        }
        List<PNextIdentifier> copy = new ArrayList<PNextIdentifier>(node.getNextIdentifier());
        for (PNextIdentifier e : copy) {
            parName = e.toString();
            s = symbolTable.lookup(e.toString(), EntryType.VAR);
            if (s == null) {
                symbolTableEntry nextTemp = new symbolTableEntry(parName, EntryType.VAR);
                nextTemp.setfParType(parType);
                nextTemp.setRetType(parType);
                symbolTable.insert(nextTemp);
            } else {
                errorLog.add("Redefinition of variable " + parName + " on line " + node.getIdentifier().getLine() + " " + node.getIdentifier().getPos());
            }
        }
        outAVarDefinitionVarDefinition(node);
    }

    public void caseAAssignmentStatement(AAssignmentStatement node) {
        inAAssignmentStatement(node);
        if (node.getLValue() != null) {
            node.getLValue().apply(this);
        }
        if (node.getExpression() != null) {
            node.getExpression().apply(this);
        }
        symbolTableEntry lval, expr;
        if (!assignStack.isEmpty()) {
            expr = assignStack.pop();
        } else {
            expr = null;
        }
        if (!assignStack.isEmpty()) {
            lval = assignStack.pop();
        } else {
            lval = null;
        }
        if (lval != null && expr != null && lval.getType() != null) {
            if (lval.getRetType().contains(expr.getRetType()) || expr.getRetType().contains(lval.getRetType())) {
                symbolTableEntry s = symbolTable.lookup(lval.getId(), EntryType.entryType);
                s.setInitialized(true);
                int place = InterCode.newTemp();
                InterCode.genQuad(Quads.Operand.ASSIGN, "$" + (place - 1), "-", place);
                varLocations.put(lval.getId(), place);
            } else {
                errorLog.add("Assignment type mismatch expecting " + lval.getRetType() + " found " + expr.getRetType());
            }
        } else {
            System.out.println("500 Internal server error " + lval + "  " + expr);
        }
        outAAssignmentStatement(node);
    }

    public void caseANoElseStatement(ANoElseStatement node) {
        inANoElseStatement(node);
        if (node.getCondition() != null) {
            node.getCondition().apply(this);
        }
        InterCode.backpatch(true, InterCode.nextQuad());
        if (node.getThenStmt() != null) {
            node.getThenStmt().apply(this);
        }
        InterCode.backpatch(false, InterCode.nextQuad());
        outANoElseStatement(node);
    }

    public void caseAWithElseStatement(AWithElseStatement node) {
        inAWithElseStatement(node);
        if (node.getCondition() != null) {
            node.getCondition().apply(this);
        }
        InterCode.backpatch(true, InterCode.nextQuad());
        if (node.getThenStmt() != null) {
            node.getThenStmt().apply(this);
        }
        InterCode.genTrueList();
        InterCode.addTrue(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", -1);
        InterCode.backpatch(false, InterCode.nextQuad());
        if (node.getElseStmt() != null) {
            node.getElseStmt().apply(this);
        }
        InterCode.backpatch(true, InterCode.nextQuad());
        outAWithElseStatement(node);
    }

    public void caseAWhileDoStatement(AWhileDoStatement node) {
        inAWhileDoStatement(node);
        int whileStart = InterCode.nextQuad();
        if (node.getCondition() != null) {
            node.getCondition().apply(this);
        }
        InterCode.backpatch(true, InterCode.nextQuad());
        if (node.getStatement() != null) {
            node.getStatement().apply(this);
        }
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", whileStart);
        InterCode.backpatch(false, InterCode.nextQuad());
        outAWhileDoStatement(node);
    }

    public void outAReturnStatement(AReturnStatement node) {
        if (node.getExpression() == null) {
            symbolTableEntry temp = new symbolTableEntry("return statement", EntryType.NOTHING);
            temp.setRetType("nothing");
            returnStack.push(temp);
            InterCode.genQuad(Quads.Operand.RET, "-", "-", -1);
        } else {
            if (assignStack.isEmpty()) {
                symbolTableEntry temp = new symbolTableEntry("return statement", EntryType.NOTHING);
                temp.setRetType("nothing");
                returnStack.push(temp);
                InterCode.genQuad(Quads.Operand.RET, "-", "-", -1);
            } else {
                returnStack.push(assignStack.pop());//IDEA KIMWNA
                InterCode.genQuad(Quads.Operand.ASSIGN, "$" + returnStack.peek().getPlace(), "-", -2);
                InterCode.genQuad(Quads.Operand.RET, "-", "-", -1);
            }
        }
    }

    public void caseAFuncCallFuncCall(AFuncCallFuncCall node) {
        inAFuncCallFuncCall(node);
        String id = node.getIdentifier().toString();
        assignStackLimit = assignStack.size();
        if (node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getExpression());
            for (PExpression e : copy) {
                e.apply(this);
            }
        }
        symbolTableEntry s = symbolTable.lookup(id, EntryType.FUNC_NAME);
        if (s == null) {
//            symbolTable.print();
            errorLog.add("undeclared function call " + id);
        } else {
            List<symbolTableEntry> params = s.getfParams();
            Collections.reverse(params);
            Stack<Quads> parameterReverser = new Stack<>();
            int iter = 0;
            int currSize = assignStack.size();
            while (!assignStack.isEmpty() && iter < (currSize - assignStackLimit)) {
                symbolTableEntry temp = assignStack.pop();
                if (params.size() <= iter) {
                    errorLog.add("1 unmatched function parameters in " + id + " call");
                    iter++;
                    break;
                }
                if (!params.get(iter).getRetType().equals(temp.getRetType())) {
                    errorLog.add("2 unmatched function parameters in " + node + " call -> param= " + params.get(iter).getId() + " as " + params.get(iter).getRetType() + " ## temp as " + temp.getId() + " as " + temp.getRetType());
                    iter++;
                    break;
                }
                Integer search = varLocations.get(temp.getId());
                int place;
                String parameterType = "VAR";
                if (params.get(iter).isReference()) {
                    parameterType = "REF";
                }
                if (search == null) {
                    place = temp.getPlace();
                    if (place < 0) {

                        System.out.println("500 :: Error we done goofed ...Sorry " + node.getClass());

                    } else {
                        if (temp.getType().equals(EntryType.STRING_LIT)) {
                            Quads parameter = new Quads(1, "PAR", "SLLabel" + temp.getPlace(), parameterType, "-");
                            parameterReverser.push(parameter);
                        } else {
                            Quads parameter = new Quads(1, "PAR", "$" + place, parameterType, "-");
                            parameterReverser.push(parameter);
                        }

                    }
                } else {
                    if (search == -666) {
                        Quads parameter = new Quads(1, "PAR", temp.getId(), parameterType, "-");
                        parameterReverser.push(parameter);
                    } else {
                        Quads parameter = new Quads(1, "PAR", "$" + search, parameterType, "-");
                        parameterReverser.push(parameter);
                    }
                }
                iter++;
            }
            while (!parameterReverser.isEmpty()) {
                Quads parameter = parameterReverser.pop();
                InterCode.genQuad(Quads.Operand.PAR, parameter.getArg1(), parameter.getArg2(), -1);
            }
            if (iter < params.size()) {
                errorLog.add("To few arguments in " + id + " call");
            }
            symbolTableEntry temp = new symbolTableEntry(id, EntryType.FUNC_CALL);
            temp.setRetType(s.getRetType());
            assignStack.push(temp);
            InterCode.genQuad(Quads.Operand.CALL, id, "-", -1);
            Collections.reverse(params); // check if it can be done in a decent way
        }
        outAFuncCallFuncCall(node);
    }

    public void outAIdentifierLValue(AIdentifierLValue node) {
        String id = node.getIdentifier().toString();
        symbolTableEntry s = symbolTable.lookup(id, EntryType.IDENTIFIER); // new lookup needed
        if (s == null) {
            errorLog.add("$ lvalue " + id + " undeclared "); //used to be uninitialized
            symbolTableEntry temp = new symbolTableEntry(id, null);
            temp.setRetType("undefined");
            assignStack.push(temp);
        } else {
            symbolTableEntry temp = new symbolTableEntry(id, EntryType.IDENTIFIER);
            temp.setfParType(s.getfParType());
            temp.setRetType(s.getRetType());
            assignStack.push(temp);
        }
    }

    public void outAStringLitLValue(AStringLitLValue node) {
        String id = node.getStringLiteral().toString();
        symbolTableEntry temp = new symbolTableEntry(id, EntryType.STRING_LIT);
        assignStack.push(temp);
    }

    public void inAArrayAssignLValue(AArrayAssignLValue node) {
        arrayDimensions++;
    }

    public void outAArrayAssignLValue(AArrayAssignLValue node) {
        arrayDimensions--;
        if (arrayDimensions == 0) {
            List<symbolTableEntry> dimensions = new LinkedList<>();
            symbolTableEntry temp = assignStack.pop();
            while (temp.getType() != EntryType.IDENTIFIER) {
                if (!temp.getRetType().equals("int")) {
                    errorLog.add("array dimension must be of type int ");
                    break;
                }
                dimensions.add(temp);
                temp = assignStack.pop();
            }
            symbolTableEntry toAdd = new symbolTableEntry(temp.getId(), EntryType.ARRAY);
            toAdd.setfParams(dimensions);
            toAdd.setRetType(temp.getRetType());
            toAdd.setInitialized(true);
            assignStack.push(toAdd);
        }
    }

//    public void caseAArrayAssignLValue(AArrayAssignLValue node) {
//        inAArrayAssignLValue(node);
//
//        outAArrayAssignLValue(node);
//    }

//    public void outAArrayExpression(AArrayExpression node) {
//        symbolTableEntry temp = new symbolTableEntry(id, EntryType.STRING_LIT);
//        assignStack.push(temp);
//    }

    public void outAStringExpression(AStringExpression node) { //TODO
        String id = node.getStringLiteral().toString();
        symbolTableEntry temp = new symbolTableEntry(id, EntryType.STRING_LIT);
        temp.setRetType("char[]");
        int place = stringLiteral.size();
        stringLiteral.put(id, "SLLabel" + place);
        temp.setPlace(place);
        assignStack.push(temp);
    }

    public void outACharConstExpression(ACharConstExpression node) {
        String id = node.getCharConst().toString();
        symbolTableEntry temp = new symbolTableEntry(id, EntryType.STRING_LIT);
        temp.setRetType("char");
        int place = InterCode.newTemp();
        InterCode.genQuad(Quads.Operand.ASSIGN, node.getCharConst().getText(), "-", place);
        temp.setPlace(place);
        assignStack.push(temp);
    }


//    public void outAArraySizeArraySize(AArraySizeArraySize node) {
//
//    }
//
//    public void outAEmptyBrackets(AEmptyBrackets node) {
////        printIndentation();
////        //   System.out.println("[EmptyBrackets]: "+node.toString());
////        addIndentationLevel();
//    }

    public void caseAArrayArray(AArrayArray node) {
        inAArrayArray(node);
        if (node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getExpression());
            for (PExpression e : copy) {
                e.apply(this);
                assignStack.pop();
            }
        }
        String id = node.getIdentifier().getText();// last change!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        symbolTableEntry s = symbolTable.lookup(id, EntryType.VAR);
        int place = InterCode.newTemp();
        if (s == null) {
            errorLog.add("array " + id + " has not been declared ");
        } else {
            symbolTableEntry temp = new symbolTableEntry(id, EntryType.ARRAY);
            // we made changes here ============================================================================
            if (s.getRetType().contains("int")) {
                temp.setRetType("int");
            } else if (s.getRetType().contains("char")) {
                temp.setRetType("char");
            }
            // temp.setRetType(s.getRetType());
            //==================================================================================================

            temp.setPlace(place);
            assignStack.push(temp);
        }
        InterCode.genQuad(Quads.Operand.ARRAY, node.getIdentifier().getText(), "$" + (place - 1), place);
        outAArrayArray(node);
    }

    public void caseAPlusExpNExp(APlusExpNExp node) {
        inAPlusExpNExp(node);
        if (node.getNExp1() != null) {
            node.getNExp1().apply(this);
        }
        if (node.getNExp2() != null) {
            node.getNExp2().apply(this);
        }

        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (temp1.getRetType().contains("char") || temp2.getRetType().contains("char")) {
            errorLog.add("expression mismatch -> " + temp1 + " and " + temp2);
        }
        int place = InterCode.newTemp();
        symbolTableEntry temp = new symbolTableEntry("+", EntryType.NOTHING);
        temp.setRetType("int");
        temp.setPlace(place);
        assignStack.push(temp);
        InterCode.genQuad(Quads.Operand.PLUS, "$" + (place - 2), "$" + (place - 1), place);
        outAPlusExpNExp(node);
    }

    public void outAMinusExpNExp(AMinusExpNExp node) {
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (temp1.getRetType().contains("char") || temp2.getRetType().contains("char")) {
            errorLog.add("expression mismatch -> " + temp1 + " and " + temp2);
        }
        int place = InterCode.newTemp();
        symbolTableEntry temp = new symbolTableEntry("-", EntryType.NOTHING);
        temp.setRetType("int");
        temp.setPlace(place);
        assignStack.push(temp);
        InterCode.genQuad(Quads.Operand.MINUS, "$" + (place - 2), "$" + (place - 1), place);
    }

    public void outATermMultNExp(ATermMultNExp node) {
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (temp1.getRetType().contains("char") || temp2.getRetType().contains("char")) {
            errorLog.add("expression mismatch -> " + temp1 + " and " + temp2);
        }
        int place = InterCode.newTemp();
        symbolTableEntry temp = new symbolTableEntry("*", EntryType.NOTHING);
        temp.setRetType("int");
        temp.setPlace(place);
        assignStack.push(temp);
        InterCode.genQuad(Quads.Operand.TIMES, "$" + (place - 2), "$" + (place - 1), place);
    }

    public void outATermDivNExp(ATermDivNExp node) {
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (temp1.getRetType().contains("char") || temp2.getRetType().contains("char")) {
            errorLog.add("expression mismatch -> " + temp1 + " and " + temp2);
        }
        int place = InterCode.newTemp();
        symbolTableEntry temp = new symbolTableEntry("/", EntryType.NOTHING);
        temp.setRetType("int");
        temp.setPlace(place);
        assignStack.push(temp);
        InterCode.genQuad(Quads.Operand.DIV, "$" + (place - 2), "$" + (place - 1), place);
    }

    public void outATermModNExp(ATermModNExp node) {
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (temp1.getRetType().contains("char") || temp2.getRetType().contains("char")) {
            errorLog.add("expression mismatch -> " + temp1 + " and " + temp2);
        }
        int place = InterCode.newTemp();
        symbolTableEntry temp = new symbolTableEntry("%", EntryType.NOTHING);
        temp.setRetType("int");
        temp.setPlace(place);
        assignStack.push(temp);
        InterCode.genQuad(Quads.Operand.MOD, "$" + (place - 2), "$" + (place - 1), place);

    }

    public void outANonParenFinal(ANonParenFinal node) {
        int place = InterCode.newTemp();
        symbolTableEntry temp = new symbolTableEntry("final", EntryType.NOTHING);
        temp.setRetType("int");
        temp.setPlace(place);
        assignStack.push(temp);
        InterCode.genQuad(Quads.Operand.ASSIGN, node.getIntConst().getText(), "-", place);
    }

    public void caseAIdenFinal(AIdenFinal node) {
        inAIdenFinal(node);
        if (node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        String id = node.getIdentifier().toString();
        symbolTableEntry s = symbolTable.lookup(id, EntryType.VAR);
        if (s == null) {
            errorLog.add("undeclared variable " + id);
        } else if (!s.isInitialized()) {
            errorLog.add("variable " + id + " has not been initialized on line " + node.getIdentifier().getLine());
        }
        symbolTableEntry temp = new symbolTableEntry(id, EntryType.NOTHING);
        if (s != null) {
            temp.setRetType(s.getfParType());
        } else {
            temp.setRetType("uninitialized");
        }
        Integer place = varLocations.get(node.getIdentifier().getText());
        int place2 = -1;
        if (place != null && place != -666) {
            place2 = InterCode.newTemp();
            InterCode.genQuad(Quads.Operand.ASSIGN, "$" + place.toString(), "-", place2);
            varLocations.put(node.getIdentifier().getText(), place2);
        } else if (place != -666) {
            System.out.println("Error: 500 it appears we lost your variable " + node);
        }
        temp.setPlace(place2);
        assignStack.push(temp);
        outAIdenFinal(node);
    }

    public void caseAOrExpCompExp(AOrExpCompExp node) {
        inAOrExpCompExp(node);
        if (node.getCompExp1() != null) {
            node.getCompExp1().apply(this);
        }
        InterCode.backpatch(false, InterCode.nextQuad());
        if (node.getCompExp2() != null) {
            node.getCompExp2().apply(this);
        }
        InterCode.trueMerge();
        if (assignStack.isEmpty()) {
            return;
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        assignStack.push(temp1);
        outAOrExpCompExp(node);
    }

    public void caseAAndExpCompExp(AAndExpCompExp node) {
        inAAndExpCompExp(node);
        if (node.getCompExp1() != null) {
            node.getCompExp1().apply(this);
        }
        InterCode.backpatch(true, InterCode.nextQuad());
        if (node.getCompExp2() != null) {
            node.getCompExp2().apply(this);
        }
        InterCode.falseMerge();
        if (assignStack.isEmpty()) {
            return;
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        assignStack.push(temp1);
        outAAndExpCompExp(node);
    }

    public void caseANotExpCompExp(ANotExpCompExp node) {
        inANotExpCompExp(node);
        if (node.getCompExp() != null) {
            node.getCompExp().apply(this);
        }
        if (assignStack.isEmpty()) {
            return;
        }
        symbolTableEntry temp = assignStack.pop();
        if (!temp.getType().equals(EntryType.BOOLEAN)) {
            errorLog.add("not opperant on non-boolean expression " + node.toString());
        }
        List<Integer> trueList = InterCode.getTrueStack().pop();
        List<Integer> falseList = InterCode.getFalseStack().pop();
        InterCode.getFalseStack().push(trueList);
        InterCode.getTrueStack().push(falseList);
        outANotExpCompExp(node);
    }

    public void caseAPlainExpCompExp(APlainExpCompExp node) {
        inAPlainExpCompExp(node);
        InterCode.genTrueList();
        InterCode.genFalseList();
        if (node.getCompVal() != null) {
            node.getCompVal().apply(this);
        }
        outAPlainExpCompExp(node);
    }

    public void caseAEqualsCompVal(AEqualsCompVal node) {
        inAEqualsCompVal(node);
        if (node.getCompVal1() != null) {
            node.getCompVal1().apply(this);
        }
        if (node.getCompVal2() != null) {
            node.getCompVal2().apply(this);
        }
        if (assignStack.isEmpty()) {

            return;
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (!temp1.getRetType().equals(temp2.getRetType())) {
            errorLog.add(node.getClass() + " mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
        int place = InterCode.getTemp();
        InterCode.addTrue(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.EQ, "$" + (place - 1), "$" + place, -1);
        InterCode.addFalse(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", -1);
        outAEqualsCompVal(node);
    }

    public void caseANotEqualsCompVal(ANotEqualsCompVal node) {
        inANotEqualsCompVal(node);
        if (node.getCompVal1() != null) {
            node.getCompVal1().apply(this);
        }
        if (node.getCompVal2() != null) {
            node.getCompVal2().apply(this);
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (!temp1.getRetType().equals(temp2.getRetType())) {
            errorLog.add(node.getClass() + " mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
        int place = InterCode.getTemp();
        InterCode.addTrue(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.NEQ, "$" + (place - 1), "$" + place, -1);
        InterCode.addFalse(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", -1);
        outANotEqualsCompVal(node);
    }

    public void caseALessThanCompVal(ALessThanCompVal node) {
        inALessThanCompVal(node);
        if (node.getCompVal1() != null) {
            node.getCompVal1().apply(this);
        }
        if (node.getCompVal2() != null) {
            node.getCompVal2().apply(this);
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (!temp1.getRetType().equals(temp2.getRetType())) {
            errorLog.add(node.getClass() + " mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
        int place = InterCode.getTemp();
        InterCode.addTrue(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.LT, "$" + (place - 1), "$" + place, -1);
        InterCode.addFalse(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", -1);
        outALessThanCompVal(node);
    }

    public void caseAGreaterThanCompVal(AGreaterThanCompVal node) {
        inAGreaterThanCompVal(node);
        if (node.getCompVal1() != null) {
            node.getCompVal1().apply(this);
        }
        if (node.getCompVal2() != null) {
            node.getCompVal2().apply(this);
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (!temp1.getRetType().contains(temp2.getRetType()) && !temp2.getRetType().contains(temp1.getRetType())) {
            errorLog.add(node.getClass() + " mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
        int place = InterCode.getTemp();
        InterCode.addTrue(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.GT, "$" + (place - 1), "$" + place, -1);
        InterCode.addFalse(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", -1);
        outAGreaterThanCompVal(node);
    }

    public void caseAGreaterOrEqualCompVal(AGreaterOrEqualCompVal node) {
        inAGreaterOrEqualCompVal(node);
        if (node.getCompVal1() != null) {
            node.getCompVal1().apply(this);
        }
        if (node.getCompVal2() != null) {
            node.getCompVal2().apply(this);
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (!temp1.getRetType().equals(temp2.getRetType())) {
            errorLog.add(node.getClass() + " mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
        int place = InterCode.getTemp();
        InterCode.addTrue(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.GET, "$" + (place - 1), "$" + place, -1);
        InterCode.addFalse(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", -1);
        outAGreaterOrEqualCompVal(node);
    }

    public void caseALessOrEqualCompVal(ALessOrEqualCompVal node) {
        inALessOrEqualCompVal(node);
        if (node.getCompVal1() != null) {
            node.getCompVal1().apply(this);
        }
        if (node.getCompVal2() != null) {
            node.getCompVal2().apply(this);
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (!temp1.getRetType().equals(temp2.getRetType())) {
            errorLog.add(node.getClass() + " mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
        int place = InterCode.getTemp();
        InterCode.addTrue(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.LET, "$" + (place - 1), "$" + place, -1);
        InterCode.addFalse(InterCode.nextQuad());
        InterCode.genQuad(Quads.Operand.JUMP, "-", "-", -1);
        outALessOrEqualCompVal(node);
    }

    public void caseACompFinalCompVal(ACompFinalCompVal node) {
        inACompFinalCompVal(node);
        if (node.getCompFinal() != null) {
            node.getCompFinal().apply(this);
        }
        outACompFinalCompVal(node);
    }

    public void caseAExprCompFinal(AExprCompFinal node) {
        inAExprCompFinal(node);
        if (node.getExpression() != null) {
            node.getExpression().apply(this);
        }
        outAExprCompFinal(node);
    }


}
