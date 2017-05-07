package com.compilers;
import sablecc.analysis.DepthFirstAdapter;
import sablecc.node.*;

import java.util.Collections;

/**
 * Created by Windows 8 on 09-Apr-17.
 */
public class PrintingVisitor extends DepthFirstAdapter{
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

    @Override
    public void inAProgram(AProgram node){
        printIndentation();
        System.out.println("[Program] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAProgram(AProgram node){
        removeIndentationLevel();
    }@Override
    public void inAFunctionDefinition(AFunctionDefinition node){
        printIndentation();
        System.out.println("[FunctionDefinition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFunctionDefinition(AFunctionDefinition node){
        removeIndentationLevel();
    }@Override
    public void inAHeader(AHeader node){
        printIndentation();
        System.out.println("[Header] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAHeader(AHeader node){
        removeIndentationLevel();
    }@Override
    public void inAFDefLocalDefinition(AFDefLocalDefinition node){
        printIndentation();
        System.out.println("[FDefLocalDefinition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFDefLocalDefinition(AFDefLocalDefinition node){
        removeIndentationLevel();
    }@Override
    public void inAFDeclLocalDefinition(AFDeclLocalDefinition node){
        printIndentation();
        System.out.println("[FDeclLocalDefinition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFDeclLocalDefinition(AFDeclLocalDefinition node){
        removeIndentationLevel();
    }@Override
    public void inAVarDefLocalDefinition(AVarDefLocalDefinition node){
        printIndentation();
        System.out.println("[VarDefLocalDefinition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAVarDefLocalDefinition(AVarDefLocalDefinition node){
        removeIndentationLevel();
    }@Override
    public void inABlock(ABlock node){
        printIndentation();
        System.out.println("[Block] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outABlock(ABlock node){
        removeIndentationLevel();
    }@Override
    public void inAFparDefinition(AFparDefinition node){
        printIndentation();
        System.out.println("[FparDefinition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFparDefinition(AFparDefinition node){
        removeIndentationLevel();
    }@Override
    public void inANextFparDefinition(ANextFparDefinition node){
        printIndentation();
        System.out.println("[NextFparDefinition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANextFparDefinition(ANextFparDefinition node){
        removeIndentationLevel();
    }@Override
    public void inADataTypeRetType(ADataTypeRetType node){
        printIndentation();
        System.out.println("[DataTypeRetType] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outADataTypeRetType(ADataTypeRetType node){
        removeIndentationLevel();
    }@Override
    public void inANothingRetType(ANothingRetType node){
        printIndentation();
        System.out.println("[NothingRetType] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANothingRetType(ANothingRetType node){
        removeIndentationLevel();
    }@Override
    public void inAIntegerDataType(AIntegerDataType node){
        printIndentation();
        System.out.println("[IntegerDataType] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAIntegerDataType(AIntegerDataType node){
        removeIndentationLevel();
    }@Override
    public void inACharacterDataType(ACharacterDataType node){
        printIndentation();
        System.out.println("[CharacterDataType] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outACharacterDataType(ACharacterDataType node){
        removeIndentationLevel();
    }@Override
    public void inAType(AType node){
        printIndentation();
        System.out.println("[Type] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAType(AType node){
        removeIndentationLevel();
    }@Override
    public void inAFunctionDeclaration(AFunctionDeclaration node){
        printIndentation();
        System.out.println("[FunctionDeclaration] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFunctionDeclaration(AFunctionDeclaration node){
        removeIndentationLevel();
    }@Override
    public void inAFparType(AFparType node){
        printIndentation();
        System.out.println("[FparType] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFparType(AFparType node){
        removeIndentationLevel();
    }@Override
    public void inAVarDefinition(AVarDefinition node){
        printIndentation();
        System.out.println("[VarDefinition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAVarDefinition(AVarDefinition node){
        removeIndentationLevel();
    }@Override
    public void inANextIdentifier(ANextIdentifier node){
        printIndentation();
        System.out.println("[NextIdentifier] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANextIdentifier(ANextIdentifier node){
        removeIndentationLevel();
    }@Override
    public void inANoopStatement(ANoopStatement node){
        printIndentation();
        System.out.println("[NoopStatement] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANoopStatement(ANoopStatement node){
        removeIndentationLevel();
    }@Override
    public void inAAssignmentStatement(AAssignmentStatement node){
        printIndentation();
        System.out.println("[AssignmentStatement] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAAssignmentStatement(AAssignmentStatement node){
        removeIndentationLevel();
    }@Override
    public void inAIfStatement(AIfStatement node){
        printIndentation();
        System.out.println("[IfStatement] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAIfStatement(AIfStatement node){
        removeIndentationLevel();
    }@Override
    public void inABlockStatement(ABlockStatement node){
        printIndentation();
        System.out.println("[BlockStatement] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outABlockStatement(ABlockStatement node){
        removeIndentationLevel();
    }@Override
    public void inAFCallStatement(AFCallStatement node){
        printIndentation();
        System.out.println("[FCallStatement] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFCallStatement(AFCallStatement node){
        removeIndentationLevel();
    }@Override
    public void inAWhileDoStatement(AWhileDoStatement node){
        printIndentation();
        System.out.println("[WhileDoStatement] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAWhileDoStatement(AWhileDoStatement node){
        removeIndentationLevel();
    }@Override
    public void inAReturnStatement(AReturnStatement node){
        printIndentation();
        System.out.println("[ReturnStatement] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAReturnStatement(AReturnStatement node){
        removeIndentationLevel();
    }@Override
    public void inANoElseIfStmt(ANoElseIfStmt node){
        printIndentation();
        System.out.println("[NoElseIfStmt] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANoElseIfStmt(ANoElseIfStmt node){
        removeIndentationLevel();
    }@Override
    public void inAWithElseIfStmt(AWithElseIfStmt node){
        printIndentation();
        System.out.println("[WithElseIfStmt] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAWithElseIfStmt(AWithElseIfStmt node){
        removeIndentationLevel();
    }@Override
    public void inANoopStmtWithElse(ANoopStmtWithElse node){
        printIndentation();
        System.out.println("[NoopStmtWithElse] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANoopStmtWithElse(ANoopStmtWithElse node){
        removeIndentationLevel();
    }@Override
    public void inAAssignmentStmtWithElse(AAssignmentStmtWithElse node){
        printIndentation();
        System.out.println("[AssignmentStmtWithElse] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAAssignmentStmtWithElse(AAssignmentStmtWithElse node){
        removeIndentationLevel();
    }@Override
    public void inAIfStmtWithElse(AIfStmtWithElse node){
        printIndentation();
        System.out.println("[IfStmtWithElse] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAIfStmtWithElse(AIfStmtWithElse node){
        removeIndentationLevel();
    }@Override
    public void inABlockStmtWithElse(ABlockStmtWithElse node){
        printIndentation();
        System.out.println("[BlockStmtWithElse] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outABlockStmtWithElse(ABlockStmtWithElse node){
        removeIndentationLevel();
    }@Override
    public void inAFCallStmtWithElse(AFCallStmtWithElse node){
        printIndentation();
        System.out.println("[FCallStmtWithElse] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFCallStmtWithElse(AFCallStmtWithElse node){
        removeIndentationLevel();
    }@Override
    public void inAWhileDoStmtWithElse(AWhileDoStmtWithElse node){
        printIndentation();
        System.out.println("[WhileDoStmtWithElse] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAWhileDoStmtWithElse(AWhileDoStmtWithElse node){
        removeIndentationLevel();
    }@Override
    public void inAReturnStmtWithElse(AReturnStmtWithElse node){
        printIndentation();
        System.out.println("[ReturnStmtWithElse] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAReturnStmtWithElse(AReturnStmtWithElse node){
        removeIndentationLevel();
    }@Override
    public void inAIfElseStmt(AIfElseStmt node){
        printIndentation();
        System.out.println("[IfElseStmt] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAIfElseStmt(AIfElseStmt node){
        removeIndentationLevel();
    }@Override
    public void inAFuncCall(AFuncCall node){
        printIndentation();
        System.out.println("[FuncCall] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFuncCall(AFuncCall node){
        removeIndentationLevel();
    }@Override
    public void inAIdentifierLValue(AIdentifierLValue node){
        printIndentation();
        System.out.println("[IdentifierLValue] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAIdentifierLValue(AIdentifierLValue node){
        removeIndentationLevel();
    }@Override
    public void inAStringLitLValue(AStringLitLValue node){
        printIndentation();
        System.out.println("[StringLitLValue] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAStringLitLValue(AStringLitLValue node){
        removeIndentationLevel();
    }@Override
    public void inAArrayAssignLValue(AArrayAssignLValue node){
        printIndentation();
        System.out.println("[ArrayAssignLValue] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAArrayAssignLValue(AArrayAssignLValue node){
        removeIndentationLevel();
    }@Override
    public void inAArrayExpression(AArrayExpression node){
        printIndentation();
        System.out.println("[ArrayExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAArrayExpression(AArrayExpression node){
        removeIndentationLevel();
    }@Override
    public void inAStringExpression(AStringExpression node){
        printIndentation();
        System.out.println("[StringExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAStringExpression(AStringExpression node){
        removeIndentationLevel();
    }@Override
    public void inACharConstExpression(ACharConstExpression node){
        printIndentation();
        System.out.println("[CharConstExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outACharConstExpression(ACharConstExpression node){
        removeIndentationLevel();
    }@Override
    public void inAFCallExpression(AFCallExpression node){
        printIndentation();
        System.out.println("[FCallExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFCallExpression(AFCallExpression node){
        removeIndentationLevel();
    }@Override
    public void inAParenExpressionExpression(AParenExpressionExpression node){
        printIndentation();
        System.out.println("[ParenExpressionExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAParenExpressionExpression(AParenExpressionExpression node){
        removeIndentationLevel();
    }@Override
    public void inASignedExpressionExpression(ASignedExpressionExpression node){
        printIndentation();
        System.out.println("[SignedExpressionExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outASignedExpressionExpression(ASignedExpressionExpression node){
        removeIndentationLevel();
    }@Override
    public void inANumOperExpression(ANumOperExpression node){
        printIndentation();
        System.out.println("[NumOperExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANumOperExpression(ANumOperExpression node){
        removeIndentationLevel();
    }@Override
    public void inAArrayExpressionB(AArrayExpressionB node){
        printIndentation();
        System.out.println("[ArrayExpressionB] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAArrayExpressionB(AArrayExpressionB node){
        removeIndentationLevel();
    }@Override
    public void inAStringExpressionB(AStringExpressionB node){
        printIndentation();
        System.out.println("[StringExpressionB] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAStringExpressionB(AStringExpressionB node){
        removeIndentationLevel();
    }@Override
    public void inACharConstExpressionB(ACharConstExpressionB node){
        printIndentation();
        System.out.println("[CharConstExpressionB] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outACharConstExpressionB(ACharConstExpressionB node){
        removeIndentationLevel();
    }@Override
    public void inAFCallExpressionB(AFCallExpressionB node){
        printIndentation();
        System.out.println("[FCallExpressionB] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAFCallExpressionB(AFCallExpressionB node){
        removeIndentationLevel();
    }@Override
    public void inASignedExpressionExpressionB(ASignedExpressionExpressionB node){
        printIndentation();
        System.out.println("[SignedExpressionExpressionB] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outASignedExpressionExpressionB(ASignedExpressionExpressionB node){
        removeIndentationLevel();
    }@Override
    public void inACondExpCondition(ACondExpCondition node){
        printIndentation();
        System.out.println("[CondExpCondition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outACondExpCondition(ACondExpCondition node){
        removeIndentationLevel();
    }@Override
    public void inAPlusSign(APlusSign node){
        printIndentation();
        System.out.println("[PlusSign] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAPlusSign(APlusSign node){
        removeIndentationLevel();
    }@Override
    public void inAMinusSign(AMinusSign node){
        printIndentation();
        System.out.println("[MinusSign] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAMinusSign(AMinusSign node){
        removeIndentationLevel();
    }@Override
    public void inANextExpression(ANextExpression node){
        printIndentation();
        System.out.println("[NextExpression] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANextExpression(ANextExpression node){
        removeIndentationLevel();
    }@Override
    public void inAMultipleExpressions(AMultipleExpressions node){
        printIndentation();
        System.out.println("[MultipleExpressions] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAMultipleExpressions(AMultipleExpressions node){
        removeIndentationLevel();
    }@Override
    public void inAArraySize(AArraySize node){
        printIndentation();
        System.out.println("[ArraySize] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAArraySize(AArraySize node){
        removeIndentationLevel();
    }@Override
    public void inAEmptyBrackets(AEmptyBrackets node){
        printIndentation();
        System.out.println("[EmptyBrackets] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAEmptyBrackets(AEmptyBrackets node){
        removeIndentationLevel();
    }@Override
    public void inAArray(AArray node){
        printIndentation();
        System.out.println("[Array] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAArray(AArray node){
        removeIndentationLevel();
    }@Override
    public void inAArrayPosition(AArrayPosition node){
        printIndentation();
        System.out.println("[ArrayPosition] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAArrayPosition(AArrayPosition node){
        removeIndentationLevel();
    }@Override
    public void inAOrLogicOperations(AOrLogicOperations node){
        printIndentation();
        System.out.println("[OrLogicOperations] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAOrLogicOperations(AOrLogicOperations node){
        removeIndentationLevel();
    }@Override
    public void inAAndLogicOperations(AAndLogicOperations node){
        printIndentation();
        System.out.println("[AndLogicOperations] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAAndLogicOperations(AAndLogicOperations node){
        removeIndentationLevel();
    }@Override
    public void inANotLogicOperations(ANotLogicOperations node){
        printIndentation();
        System.out.println("[NotLogicOperations] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANotLogicOperations(ANotLogicOperations node){
        removeIndentationLevel();
    }@Override
    public void inAEqualsComparisonSymbols(AEqualsComparisonSymbols node){
        printIndentation();
        System.out.println("[EqualsComparisonSymbols] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAEqualsComparisonSymbols(AEqualsComparisonSymbols node){
        removeIndentationLevel();
    }@Override
    public void inANotEqualsComparisonSymbols(ANotEqualsComparisonSymbols node){
        printIndentation();
        System.out.println("[NotEqualsComparisonSymbols] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANotEqualsComparisonSymbols(ANotEqualsComparisonSymbols node){
        removeIndentationLevel();
    }@Override
    public void inALessThanComparisonSymbols(ALessThanComparisonSymbols node){
        printIndentation();
        System.out.println("[LessThanComparisonSymbols] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outALessThanComparisonSymbols(ALessThanComparisonSymbols node){
        removeIndentationLevel();
    }@Override
    public void inAGreaterThanComparisonSymbols(AGreaterThanComparisonSymbols node){
        printIndentation();
        System.out.println("[GreaterThanComparisonSymbols] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAGreaterThanComparisonSymbols(AGreaterThanComparisonSymbols node){
        removeIndentationLevel();
    }@Override
    public void inAGreaterOrEqualComparisonSymbols(AGreaterOrEqualComparisonSymbols node){
        printIndentation();
        System.out.println("[GreaterOrEqualComparisonSymbols] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAGreaterOrEqualComparisonSymbols(AGreaterOrEqualComparisonSymbols node){
        removeIndentationLevel();
    }@Override
    public void inALessOrEqualComparisonSymbols(ALessOrEqualComparisonSymbols node){
        printIndentation();
        System.out.println("[LessOrEqualComparisonSymbols] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outALessOrEqualComparisonSymbols(ALessOrEqualComparisonSymbols node){
        removeIndentationLevel();
    }@Override
    public void inAPlusExpNExp(APlusExpNExp node){
        printIndentation();
        System.out.println("[PlusExpNExp] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAPlusExpNExp(APlusExpNExp node){
        removeIndentationLevel();
    }@Override
    public void inAMinusExpNExp(AMinusExpNExp node){
        printIndentation();
        System.out.println("[MinusExpNExp] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAMinusExpNExp(AMinusExpNExp node){
        removeIndentationLevel();
    }@Override
    public void inATermNExp(ATermNExp node){
        printIndentation();
        System.out.println("[TermNExp] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outATermNExp(ATermNExp node){
        removeIndentationLevel();
    }@Override
    public void inATermMultTerm(ATermMultTerm node){
        printIndentation();
        System.out.println("[TermMultTerm] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outATermMultTerm(ATermMultTerm node){
        removeIndentationLevel();
    }@Override
    public void inATermDivTerm(ATermDivTerm node){
        printIndentation();
        System.out.println("[TermDivTerm] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outATermDivTerm(ATermDivTerm node){
        removeIndentationLevel();
    }@Override
    public void inATermModTerm(ATermModTerm node){
        printIndentation();
        System.out.println("[TermModTerm] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outATermModTerm(ATermModTerm node){
        removeIndentationLevel();
    }@Override
    public void inAExponentTerm(AExponentTerm node){
        printIndentation();
        System.out.println("[ExponentTerm] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAExponentTerm(AExponentTerm node){
        removeIndentationLevel();
    }@Override
    public void inAUnsignedExponent(AUnsignedExponent node){
        printIndentation();
        System.out.println("[UnsignedExponent] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAUnsignedExponent(AUnsignedExponent node){
        removeIndentationLevel();
    }@Override
    public void inANonParenFinal(ANonParenFinal node){
        printIndentation();
        System.out.println("[NonParenFinal] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANonParenFinal(ANonParenFinal node){
        removeIndentationLevel();
    }@Override
    public void inAParenExpFinal(AParenExpFinal node){
        printIndentation();
        System.out.println("[ParenExpFinal] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAParenExpFinal(AParenExpFinal node){
        removeIndentationLevel();
    }@Override
    public void inAIdenFinal(AIdenFinal node){
        printIndentation();
        System.out.println("[IdenFinal] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAIdenFinal(AIdenFinal node){
        removeIndentationLevel();
    }@Override
    public void inAOrExpCompExp(AOrExpCompExp node){
        printIndentation();
        System.out.println("[OrExpCompExp] "+node.toString());
        addIndentationLevel();
    }



    @Override
    public void outAEqualsCompVal(AEqualsCompVal node){
        removeIndentationLevel();
    }@Override
    public void inANotEqualsCompVal(ANotEqualsCompVal node){
        printIndentation();
        System.out.println("[NotEqualsCompVal] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outANotEqualsCompVal(ANotEqualsCompVal node){
        removeIndentationLevel();
    }@Override
    public void inALessThanCompVal(ALessThanCompVal node){
        printIndentation();
        System.out.println("[LessThanCompVal] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outALessThanCompVal(ALessThanCompVal node){
        removeIndentationLevel();
    }@Override
    public void inAGreaterThanCompVal(AGreaterThanCompVal node){
        printIndentation();
        System.out.println("[GreaterThanCompVal] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAGreaterThanCompVal(AGreaterThanCompVal node){
        removeIndentationLevel();
    }@Override
    public void inAGreaterOrEqualCompVal(AGreaterOrEqualCompVal node){
        printIndentation();
        System.out.println("[GreaterOrEqualCompVal] "+node.toString());
        addIndentationLevel();
    }

    @Override
    public void outAGreaterOrEqualCompVal(AGreaterOrEqualCompVal node){
        removeIndentationLevel();
    }@Override
    public void inALessOrEqualCompVal(ALessOrEqualCompVal node){
        printIndentation();
        System.out.println("[LessOrEqualCompVal] "+node.toString());
        addIndentationLevel();
    }



    @Override
    public void outAExprCompFinal(AExprCompFinal node){
        removeIndentationLevel();
    }



}
