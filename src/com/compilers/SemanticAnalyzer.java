package com.compilers;

import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;

import java.util.*;

/**
 * Created by Windows 8 on 09-Apr-17.
 */
public class SemanticAnalyzer extends DepthFirstAdapter {
    int indentation = 0;

    int arrayDimensions = 0;

    int assignStackLimit = 0;


    List<symbolTableEntry> fParams = new LinkedList<>();

    Stack<symbolTableEntry> assignStack = new Stack<>(); //keep track of stack size on entry to know your stack limits

    Stack<symbolTableEntry> returnStack = new Stack<>(); //keep track of stack size on entry to know your stack limits


    List<String> errorLog = new LinkedList<>();

    SymbolTable symbolTable = new SymbolTable();

    public void outAProgramProgram(AProgramProgram node) {
        for (String e : errorLog) {
            System.out.println("ERROR: " + e);
        }
    }

    /*
    *
    * Function Defintition
    *
     */


    public void inAFunctionDefinitionFunctionDefinition(AFunctionDefinitionFunctionDefinition node) {
        symbolTable.enter();
    }

    public void outAFunctionDefinitionFunctionDefinition(AFunctionDefinitionFunctionDefinition node) {

        symbolTableEntry s = symbolTable.getFunctionEntry();
        System.out.println("new function returned: "+s);
        String sRetType = s.getRetType();
        while(!returnStack.isEmpty()){
            symbolTableEntry e = returnStack.pop();
            System.out.println("s == "+ s.getRetType());
            System.out.println("e == "+ e.getRetType()+" "+e.getId());
            if(!e.getRetType().equals(sRetType)){
                errorLog.add("Invalid return type on "+s.getId());
            }
        }

        symbolTable.exit();

    }

    /*
    *
    * Header
    *
     */
    public void caseAHeaderHeader(AHeaderHeader node) {
        inAHeaderHeader(node);
        String id = node.getIdentifier().toString();
        String parentClass = node.parent().getClass().toString();
        EntryType et = EntryType.entryType;
        String retType = node.getRetType().toString();
        symbolTableEntry s = symbolTable.lookupWithScope(id);
        // System.out.println(s);
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
                    System.out.println(result);
                    System.out.println(fParams);
                    System.out.println(result.size());
                    System.out.println(fParams.size());
//                    System.out.println(s.getfParams().equals(fParams));
//                    System.out.println(s.getfParams() +" equals " + fParams +" type "+ s.getRetType()+"equals "+ retType);
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

    //removed localdef func def

    //removed localdef func decl

    // removed localdef var def


    //removed block
//    public void caseABlockBlock(ABlockBlock node){
//        //System.out.println("block-> "+ node);
//    }

    //new  st
    public void caseAFparDefinitionFparDefinition(AFparDefinitionFparDefinition node) {
        inAFparDefinitionFparDefinition(node);
        String parName = node.getIdentifier().toString();
        String parType = node.getFparType().toString();
        symbolTableEntry temp = new symbolTableEntry(parName, EntryType.FUNC_PARAM);
        temp.setfParType(parType);
        fParams.add(temp);
        List<PNextIdentifier> copy = new ArrayList<PNextIdentifier>(node.getNextIdentifier());
        for (PNextIdentifier e : copy) {
            symbolTableEntry nextTemp = new symbolTableEntry(e.toString(), EntryType.FUNC_PARAM);
            nextTemp.setfParType(parType);
            fParams.add(nextTemp);
        }
        outAFparDefinitionFparDefinition(node);
    }


    // removed return data type
    // removed nothing return type

    //removed int & char type

    // removed type


    //removed fpartype

    public void caseAVarDefinitionVarDefinition(AVarDefinitionVarDefinition node) {


        System.out.println(node);
        inAVarDefinitionVarDefinition(node);
//        System.out.println("in case var def");
        String parName = node.getIdentifier().toString();
        String parType = node.getType().toString();
        symbolTableEntry temp = new symbolTableEntry(parName, EntryType.VAR);
        temp.setfParType(parType);
        symbolTableEntry s = symbolTable.lookup(parName, EntryType.VAR); // need lookoup for vars
//        System.out.println("returned "+ s);
        if (s == null) {
            symbolTable.insert(temp);
        } else {
            errorLog.add("Redefinition of variable " + parName + " on line " + node.getIdentifier().getLine() + " " + node.getIdentifier().getPos());

        }
        List<PNextIdentifier> copy = new ArrayList<PNextIdentifier>(node.getNextIdentifier());
        for (PNextIdentifier e : copy) {
            parName = e.toString();

            s = symbolTable.lookup(e.toString(), EntryType.VAR); // need lookoup for vars
//            System.out.println("returned "+ s);
            if (s == null) {
                symbolTableEntry nextTemp = new symbolTableEntry(parName, EntryType.VAR);
                nextTemp.setfParType(parType);
                symbolTable.insert(nextTemp);
            } else {
                errorLog.add("Redefinition of variable " + parName + " on line " + node.getIdentifier().getLine() + " " + node.getIdentifier().getPos());

            }
        }
        outAVarDefinitionVarDefinition(node);
    }

    //removed next identifier

    //removed noop statement

    //check type on st
    public void caseAAssignmentStatement(AAssignmentStatement node) {
        System.out.println(node);
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
            if (expr.getRetType().equals(lval.getRetType())) {
                lval.setInitialized(true);
                symbolTable.insert(lval);
            } else {
                errorLog.add("Assignment type mismatch expecting " + lval.getRetType() + " found " + expr.getRetType());
            }
        } else {
            System.out.println("LOL ");
        }

        //check if lvalue type matches expression type

        outAAssignmentStatement(node);
    }

    public void outANoElseStatement(ANoElseStatement node) {

    }

    public void outAWithElseStatement(AWithElseStatement node) {

    }

//    public void outABlockStatement(ABlockStatement node) {
//        printIndentation();
//        //  System.out.println("[BlockStatement]: "+node.toString());
//        addIndentationLevel();
//    }

    public void outAFCallStatement(AFCallStatement node) {

    }

    public void outAWhileDoStatement(AWhileDoStatement node) {

    }

    public void outAReturnStatement(AReturnStatement node) {
        if(assignStack.isEmpty()){
            symbolTableEntry temp = new symbolTableEntry(node.toString(), EntryType.NOTHING);
            temp.setRetType("nothing");
            returnStack.push(temp);
        }else{
            returnStack.push(assignStack.pop());//IDEA KIMWNA
        }
    }

    public void outAStatementWithElseStatement(AStatementWithElseStatement node) {

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
            errorLog.add("undeclared function call " + id);
        } else {
            List<symbolTableEntry> params = s.getfParams();
            int iter = 0;
            int currSize = assignStack.size();
            while (!assignStack.isEmpty() && iter >= (currSize - assignStackLimit)) {
                symbolTableEntry temp = assignStack.pop();
                if (params.size() <= iter) {
                    errorLog.add("unmatched function parameters in " + id + " call");
                    break;
                }
                if (!params.get(iter).getRetType().equals(temp.getRetType())) {
                    errorLog.add("unmatched function parameters in " + id + " call");
                    break;
                }
                iter++;

            }
            symbolTableEntry temp = new symbolTableEntry(id, EntryType.STRING_LIT);
            temp.setRetType(s.getRetType());
            assignStack.push(temp);
        }
        outAFuncCallFuncCall(node);
    }

    public void outAIdentifierLValue(AIdentifierLValue node) {
        String id = node.getIdentifier().toString();
        symbolTableEntry s = symbolTable.lookup(id, EntryType.IDENTIFIER); // new lookup needed
        if (s == null) {
            errorLog.add("lvalue " + id + " not initialized ");
            symbolTableEntry temp = new symbolTableEntry(id, null);
            assignStack.push(temp);
        } else {
            symbolTableEntry temp = new symbolTableEntry(id, EntryType.IDENTIFIER);
            temp.setfParType(s.getfParType());
            assignStack.push(temp);
        }
    }

    public void outAStringLitLValue(AStringLitLValue node) {
        String id = node.getStringLiteral().toString();
        System.out.println(id);
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
            toAdd.setInitialized(true);
            symbolTable.insert(toAdd);
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

    public void outAStringExpression(AStringExpression node) {
        String id = node.getStringLiteral().toString();
        symbolTableEntry temp = new symbolTableEntry(id, EntryType.STRING_LIT);
        temp.setRetType("char");
        assignStack.push(temp);
    }

    public void outACharConstExpression(ACharConstExpression node) {
        String id = node.getCharConst().toString();
        symbolTableEntry temp = new symbolTableEntry(id, EntryType.STRING_LIT);
        temp.setRetType("char");
        assignStack.push(temp);
    }
//
//    public void outAFCallExpression(AFCallExpression node) {
//
//    }

    // public void outAParenExpressionExpression(AParenExpressionExpression node) {
    //   printIndentation();
    //   System.out.println("[ParenExpressionExpression]: "+node.toString());
    // addIndentationLevel();
    //}

    public void outASignedExpressionExpression(ASignedExpressionExpression node) {
//        printIndentation();
        //    System.out.println("[SignedExpressionExpression]: "+node.toString());
//        addIndentationLevel();
    }

    public void outANumOperExpression(ANumOperExpression node) {

//        symbolTableEntry temp = new symbolTableEntry(, EntryType.STRING_LIT);
//        temp.setRetType("int");
//        assignStack.push(temp);
    }

    public void outACondExpCondition(ACondExpCondition node) {
        //printIndentation();
        //   System.out.println("[CondExpCondition]: "+node.toString());
        //addIndentationLevel();
    }

    public void outAPlusSign(APlusSign node) {
//        printIndentation();
//        //   System.out.println("[PlusSign]: "+node.toString());
//        addIndentationLevel();
    }

    public void outAMinusSign(AMinusSign node) {
//        printIndentation();
//        //   System.out.println("[MinusSign]: "+node.toString());
//        addIndentationLevel();
    }

    public void outAArraySizeArraySize(AArraySizeArraySize node) {

    }

    public void outAEmptyBrackets(AEmptyBrackets node) {
//        printIndentation();
//        //   System.out.println("[EmptyBrackets]: "+node.toString());
//        addIndentationLevel();
    }

    public void caseAArrayArray(AArrayArray node) {
        inAArrayArray(node);
        if (node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getExpression());
            for (PExpression e : copy) {
                e.apply(this);
            }
        }
        String id = node.getIdentifier().toString();
        symbolTableEntry s = symbolTable.lookup(id, EntryType.VAR);
        if (s == null) {
            errorLog.add("array " + id + " has not been declared ");
        } else {
            symbolTableEntry temp = new symbolTableEntry(id, EntryType.ARRAY);
            temp.setRetType(s.getRetType());
            assignStack.push(temp);
        }
        outAArrayArray(node);
    }

//    public void caseAPlusExpNExp(APlusExpNExp node) {
//        inAPlusExpNExp(node);
//        if(node.getNExp1() != null)
//        {
//            node.getNExp1().apply(this);
//        }
//        if(node.getNExp2() != null)
//        {
//            node.getNExp2().apply(this);
//        }
//
//
//        outAPlusExpNExp(node);
//    }

    public void outAMinusExpNExp(AMinusExpNExp node) {

    }

    public void outATermMultNExp(ATermMultNExp node) {

    }

    public void outATermDivNExp(ATermDivNExp node) {

    }

    public void outATermModNExp(ATermModNExp node) {

    }

    public void outAExponentNExp(AExponentNExp node) {

    }

    public void outANonParenFinal(ANonParenFinal node) {

    }

    public void outAParenExpFinal(AParenExpFinal node) {

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
        } else if (s.getfParType().contains("char")) {
            errorLog.add("variable " + id + " is of wrong type");
        } else if (!s.isInitialized()) {
            errorLog.add("variable " + id + " has not been initialized");
        }
        outAIdenFinal(node);
    }

    public void caseAOrExpCompExp(AOrExpCompExp node) {
        inAOrExpCompExp(node);
        if (node.getCompExp1() != null) {
            node.getCompExp1().apply(this);
        }
        if (node.getCompExp2() != null) {
            node.getCompExp2().apply(this);
        }
        if (assignStack.isEmpty()) {
            System.out.println("fuck this im out OR");
            return;
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();

        outAOrExpCompExp(node);
    }

    public void caseAAndExpCompExp(AAndExpCompExp node) {
        inAAndExpCompExp(node);
        if (node.getCompExp1() != null) {
            node.getCompExp1().apply(this);
        }
        if (node.getCompExp2() != null) {
            node.getCompExp2().apply(this);
        }
        if (assignStack.isEmpty()) {
            System.out.println("fuck this im out AND");
            return;
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();

        outAAndExpCompExp(node);
    }

    public void caseANotExpCompExp(ANotExpCompExp node) {
        inANotExpCompExp(node);
        if (node.getCompExp() != null) {
            node.getCompExp().apply(this);
        }
        if (assignStack.isEmpty()) {
            System.out.println("fuck this im out NOT");
            return;
        }
        symbolTableEntry temp = assignStack.pop();
        if (!temp.getType().equals(EntryType.BOOLEAN)) {
            errorLog.add("not opperant on non-boolean expression " + node.toString());
        }
        outANotExpCompExp(node);
    }

    public void caseAPlainExpCompExp(APlainExpCompExp node) {
//        printIndentation();
//        //    System.out.println("[PlainExpCompExp]: "+node.toString());
//        addIndentationLevel();
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
            System.out.println("fuck this im out Equals");
            return;
        }
        symbolTableEntry temp1 = assignStack.pop();
        symbolTableEntry temp2 = assignStack.pop();
        if (!temp1.getType().equals(temp2.getType())) {
            errorLog.add("mismatch types in comparison " + node.toString());
        }
        //this is sakis fault!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        assignStack.push(temp1);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
        if (!temp1.getType().equals(temp2.getType())) {
            errorLog.add("mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
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
        if (!temp1.getType().equals(temp2.getType())) {
            errorLog.add("mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
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
        if (!temp1.getType().equals(temp2.getType())) {
            errorLog.add("mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
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
        if (!temp1.getType().equals(temp2.getType())) {
            errorLog.add("mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
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
        if (!temp1.getType().equals(temp2.getType())) {
            errorLog.add("mismatch types in comparison " + node.toString());
        }
        assignStack.push(temp1);
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
