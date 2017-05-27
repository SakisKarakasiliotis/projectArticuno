package com.compilers;
import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Windows 8 on 09-Apr-17.
 */
public class SemanticAnalyzer extends DepthFirstAdapter{
    int indentation = 0;

    private void addIndentationLevel() {
        indentation++;
    }

    private void removeIndentationLevel() {
        indentation--;
    }

    private void printIndentation() {
        System.out.print(String.join("", Collections.nCopies(indentation, " ")));
    }

    SymbolTable symbolTable = new SymbolTable();

    public void outAProgramProgram(AProgramProgram node){
        printIndentation();
        System.out.println("[ProgramProgram]: "+node.toString());
        addIndentationLevel();
    }

    /*
    *
    * Function Defintition
    *
     */
    public void inAFunctionDefinitionFunctionDefinition(AFunctionDefinitionFunctionDefinition node){
        System.out.println("[FunctionDefinition]: "+node.toString());
        symbolTable.enter();
    }
    public void outAFunctionDefinitionFunctionDefinition(AFunctionDefinitionFunctionDefinition node){
        symbolTable.exit();
    }
    /*
    *
    * Header
    *
     */
    public void inAHeaderHeader(AHeaderHeader node){
        System.out.println("[Header]: "+node.toString());
        if(!symbolTable.lookup(node.getIdentifier().getText())){
            int insert = symbolTable.insert(node.getIdentifier().getText(), "function Name");
        }


    }
    public void outAHeaderHeader(AHeaderHeader node){
        System.out.println("THIS SHOULD WORK "+node.getNextFparDefinition());

    }

    public void outAFDefLocalDefinition(AFDefLocalDefinition node){
        printIndentation();
        System.out.println("[FDefLocalDefinition]: "+node.toString());
        addIndentationLevel();
    }

    public void outAFDeclLocalDefinition(AFDeclLocalDefinition node){
        printIndentation();
        System.out.println("[FDeclLocalDefinition]: "+node.toString());
        addIndentationLevel();
    }

    public void outAVarDefLocalDefinition(AVarDefLocalDefinition node){
        printIndentation();
        System.out.println("[VarDefLocalDefinition]: "+node.toString());
        addIndentationLevel();
    }
    //new scope
    public void outABlockBlock(ABlockBlock node){
        printIndentation();
        System.out.println("[BlockBlock]: "+node.toString());
        addIndentationLevel();
    }
    //new  st
    public void outAFparDefinitionFparDefinition(AFparDefinitionFparDefinition node){
        printIndentation();
        System.out.println("[FparDefinitionFparDefinition]: "+node.toString());
        addIndentationLevel();


    }

    public void outANextFparDefinitionNextFparDefinition(ANextFparDefinitionNextFparDefinition node){
        printIndentation();
        System.out.println("[NextFparDefinitionNextFparDefinition]: "+node.toString());
        addIndentationLevel();
    }

    public void outADataTypeRetType(ADataTypeRetType node){
        printIndentation();
        System.out.println("[DataTypeRetType]: "+node.toString());
        addIndentationLevel();
    }

    public void outANothingRetType(ANothingRetType node){
        printIndentation();
        System.out.println("[NothingRetType]: "+node.toString());
        addIndentationLevel();
    }

    public void outAIntegerDataType(AIntegerDataType node){
        printIndentation();
        System.out.println("[IntegerDataType]: "+node.toString());
        addIndentationLevel();
    }

    public void outACharacterDataType(ACharacterDataType node){
        printIndentation();
        System.out.println("[CharacterDataType]: "+node.toString());
        addIndentationLevel();
    }

    public void outATypeType(ATypeType node){
        printIndentation();
        System.out.println("[TypeType]: "+node.toString());
        addIndentationLevel();
    }

    public void outAFunctionDeclarationFunctionDeclaration(AFunctionDeclarationFunctionDeclaration node){
        printIndentation();
        System.out.println("[FunctionDeclarationFunctionDeclaration]: "+node.toString());
        addIndentationLevel();
    }

    public void outAFparTypeFparType(AFparTypeFparType node){
        printIndentation();
        System.out.println("[FparTypeFparType]: "+node.toString());
        addIndentationLevel();
    }

    public void outAVarDefinitionVarDefinition(AVarDefinitionVarDefinition node){
        printIndentation();
        System.out.println("[VarDefinitionVarDefinition]: "+node.toString());
        addIndentationLevel();
    }

    public void outANextIdentifierNextIdentifier(ANextIdentifierNextIdentifier node){
        printIndentation();
        System.out.println("[NextIdentifierNextIdentifier]: "+node.toString());
        addIndentationLevel();
    }

    public void outANoopStatement(ANoopStatement node){
        printIndentation();
        System.out.println("[NoopStatement]: "+node.toString());
        addIndentationLevel();
    }
    //check type on st
    public void outAAssignmentStatement(AAssignmentStatement node){
        printIndentation();
        System.out.println("[AssignmentStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outANoElseStatement(ANoElseStatement node){
        printIndentation();
        System.out.println("[NoElseStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outAWithElseStatement(AWithElseStatement node){
        printIndentation();
        System.out.println("[WithElseStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outABlockStatement(ABlockStatement node){
        printIndentation();
        System.out.println("[BlockStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outAFCallStatement(AFCallStatement node){
        printIndentation();
        System.out.println("[FCallStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outAWhileDoStatement(AWhileDoStatement node){
        printIndentation();
        System.out.println("[WhileDoStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outAReturnStatement(AReturnStatement node){
        printIndentation();
        System.out.println("[ReturnStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outAStatementWithElseStatement(AStatementWithElseStatement node){
        printIndentation();
        System.out.println("[StatementWithElseStatement]: "+node.toString());
        addIndentationLevel();
    }

    public void outAFuncCallFuncCall(AFuncCallFuncCall node){
        printIndentation();
        System.out.println("[FuncCallFuncCall]: "+node.toString());
        addIndentationLevel();
    }

    public void outAIdentifierLValue(AIdentifierLValue node){
        printIndentation();
        System.out.println("[IdentifierLValue]: "+node.toString());
        addIndentationLevel();
    }

    public void outAStringLitLValue(AStringLitLValue node){
        printIndentation();
        System.out.println("[StringLitLValue]: "+node.toString());
        addIndentationLevel();
    }

    public void outAArrayAssignLValue(AArrayAssignLValue node){
        printIndentation();
        System.out.println("[ArrayAssignLValue]: "+node.toString());
        addIndentationLevel();
    }

    public void outAArrayExpression(AArrayExpression node){
        printIndentation();
        System.out.println("[ArrayExpression]: "+node.toString());
        addIndentationLevel();
    }

    public void outAStringExpression(AStringExpression node){
        printIndentation();
        System.out.println("[StringExpression]: "+node.toString());
        addIndentationLevel();
    }

    public void outACharConstExpression(ACharConstExpression node){
        printIndentation();
        System.out.println("[CharConstExpression]: "+node.toString());
        addIndentationLevel();
    }

    public void outAFCallExpression(AFCallExpression node){
        printIndentation();
        System.out.println("[FCallExpression]: "+node.toString());
        addIndentationLevel();
    }

    public void outAParenExpressionExpression(AParenExpressionExpression node){
        printIndentation();
        System.out.println("[ParenExpressionExpression]: "+node.toString());
        addIndentationLevel();
    }

    public void outASignedExpressionExpression(ASignedExpressionExpression node){
        printIndentation();
        System.out.println("[SignedExpressionExpression]: "+node.toString());
        addIndentationLevel();
    }

    public void outANumOperExpression(ANumOperExpression node){
        printIndentation();
        System.out.println("[NumOperExpression]: "+node.toString());
        addIndentationLevel();
    }

    public void outACondExpCondition(ACondExpCondition node){
        printIndentation();
        System.out.println("[CondExpCondition]: "+node.toString());
        addIndentationLevel();
    }

    public void outAPlusSign(APlusSign node){
        printIndentation();
        System.out.println("[PlusSign]: "+node.toString());
        addIndentationLevel();
    }

    public void outAMinusSign(AMinusSign node){
        printIndentation();
        System.out.println("[MinusSign]: "+node.toString());
        addIndentationLevel();
    }

    public void outAArraySizeArraySize(AArraySizeArraySize node){
        printIndentation();
        System.out.println("[ArraySizeArraySize]: "+node.toString());
        addIndentationLevel();
    }

    public void outAEmptyBrackets(AEmptyBrackets node){
        printIndentation();
        System.out.println("[EmptyBrackets]: "+node.toString());
        addIndentationLevel();
    }

    public void outAArrayArray(AArrayArray node){
        printIndentation();
        System.out.println("[ArrayArray]: "+node.toString());
        addIndentationLevel();
    }

    public void outAPlusExpNExp(APlusExpNExp node){
        printIndentation();
        System.out.println("[PlusExpNExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outAMinusExpNExp(AMinusExpNExp node){
        printIndentation();
        System.out.println("[MinusExpNExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outATermMultNExp(ATermMultNExp node){
        printIndentation();
        System.out.println("[TermMultNExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outATermDivNExp(ATermDivNExp node){
        printIndentation();
        System.out.println("[TermDivNExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outATermModNExp(ATermModNExp node){
        printIndentation();
        System.out.println("[TermModNExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outAExponentNExp(AExponentNExp node){
        printIndentation();
        System.out.println("[ExponentNExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outANonParenFinal(ANonParenFinal node){
        printIndentation();
        System.out.println("[NonParenFinal]: "+node.toString());
        addIndentationLevel();
    }

    public void outAParenExpFinal(AParenExpFinal node){
        printIndentation();
        System.out.println("[ParenExpFinal]: "+node.toString());
        addIndentationLevel();
    }

    public void outAIdenFinal(AIdenFinal node){
        printIndentation();
        System.out.println("[IdenFinal]: "+node.toString());
        addIndentationLevel();
    }

    public void outAOrExpCompExp(AOrExpCompExp node){
        printIndentation();
        System.out.println("[OrExpCompExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outAAndExpCompExp(AAndExpCompExp node){
        printIndentation();
        System.out.println("[AndExpCompExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outANotExpCompExp(ANotExpCompExp node){
        printIndentation();
        System.out.println("[NotExpCompExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outAPlainExpCompExp(APlainExpCompExp node){
        printIndentation();
        System.out.println("[PlainExpCompExp]: "+node.toString());
        addIndentationLevel();
    }

    public void outAEqualsCompVal(AEqualsCompVal node){
        printIndentation();
        System.out.println("[EqualsCompVal]: "+node.toString());
        addIndentationLevel();
    }

    public void outANotEqualsCompVal(ANotEqualsCompVal node){
        printIndentation();
        System.out.println("[NotEqualsCompVal]: "+node.toString());
        addIndentationLevel();
    }

    public void outALessThanCompVal(ALessThanCompVal node){
        printIndentation();
        System.out.println("[LessThanCompVal]: "+node.toString());
        addIndentationLevel();
    }

    public void outAGreaterThanCompVal(AGreaterThanCompVal node){
        printIndentation();
        System.out.println("[GreaterThanCompVal]: "+node.toString());
        addIndentationLevel();
    }

    public void outAGreaterOrEqualCompVal(AGreaterOrEqualCompVal node){
        printIndentation();
        System.out.println("[GreaterOrEqualCompVal]: "+node.toString());
        addIndentationLevel();
    }

    public void outALessOrEqualCompVal(ALessOrEqualCompVal node){
        printIndentation();
        System.out.println("[LessOrEqualCompVal]: "+node.toString());
        addIndentationLevel();
    }

    public void outACompFinalCompVal(ACompFinalCompVal node){
        printIndentation();
        System.out.println("[CompFinalCompVal]: "+node.toString());
        addIndentationLevel();
    }

    public void outAExprCompFinal(AExprCompFinal node){
        printIndentation();
        System.out.println("[ExprCompFinal]: "+node.toString());
        addIndentationLevel();
    }



}
