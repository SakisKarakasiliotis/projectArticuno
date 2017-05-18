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
    public void outANoopStatement(ANoopStatement node){
        removeIndentationLevel();
    }@Override
    public void inAAssignmentStatement(AAssignmentStatement node){
        printIndentation();
        System.out.println("[AssignmentStatement] "+node.toString());
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
        }

 @Override
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
