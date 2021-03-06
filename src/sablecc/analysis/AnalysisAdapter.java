/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.analysis;

import java.util.*;
import sablecc.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAProgramProgram(AProgramProgram node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionDefinitionFunctionDefinition(AFunctionDefinitionFunctionDefinition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAHeaderHeader(AHeaderHeader node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFDefLocalDefinition(AFDefLocalDefinition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFDeclLocalDefinition(AFDeclLocalDefinition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarDefLocalDefinition(AVarDefLocalDefinition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlockBlock(ABlockBlock node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFparDefinitionFparDefinition(AFparDefinitionFparDefinition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANextFparDefinitionNextFparDefinition(ANextFparDefinitionNextFparDefinition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADataTypeRetType(ADataTypeRetType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANothingRetType(ANothingRetType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntegerDataType(AIntegerDataType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACharacterDataType(ACharacterDataType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATypeType(ATypeType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionDeclarationHeaderFunctionDeclaration(AFunctionDeclarationHeaderFunctionDeclaration node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFparTypeFparType(AFparTypeFparType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarDefinitionVarDefinition(AVarDefinitionVarDefinition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANextIdentifierNextIdentifier(ANextIdentifierNextIdentifier node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANoopStatement(ANoopStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignmentStatement(AAssignmentStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANoElseStatement(ANoElseStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWithElseStatement(AWithElseStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlockStatement(ABlockStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFCallStatement(AFCallStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileDoStatement(AWhileDoStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAReturnStatement(AReturnStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStatementWithElseStatement(AStatementWithElseStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFuncCallFuncCall(AFuncCallFuncCall node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdentifierLValue(AIdentifierLValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringLitLValue(AStringLitLValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayAssignLValue(AArrayAssignLValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayExpression(AArrayExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringExpression(AStringExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACharConstExpression(ACharConstExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFCallExpression(AFCallExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParenExpressionExpression(AParenExpressionExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASignedExpressionExpression(ASignedExpressionExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumOperExpression(ANumOperExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACondExpCondition(ACondExpCondition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlusSign(APlusSign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusSign(AMinusSign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArraySizeArraySize(AArraySizeArraySize node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEmptyBrackets(AEmptyBrackets node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayArray(AArrayArray node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlusExpNExp(APlusExpNExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusExpNExp(AMinusExpNExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATermMultNExp(ATermMultNExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATermDivNExp(ATermDivNExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATermModNExp(ATermModNExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExponentNExp(AExponentNExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANonParenFinal(ANonParenFinal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParenExpFinal(AParenExpFinal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdenFinal(AIdenFinal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrExpCompExp(AOrExpCompExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndExpCompExp(AAndExpCompExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotExpCompExp(ANotExpCompExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlainExpCompExp(APlainExpCompExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqualsCompVal(AEqualsCompVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotEqualsCompVal(ANotEqualsCompVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessThanCompVal(ALessThanCompVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterThanCompVal(AGreaterThanCompVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterOrEqualCompVal(AGreaterOrEqualCompVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessOrEqualCompVal(ALessOrEqualCompVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACompFinalCompVal(ACompFinalCompVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprCompFinal(AExprCompFinal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwFun(TKwFun node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwVar(TKwVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwChar(TKwChar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwInt(TKwInt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwDo(TKwDo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwWhile(TKwWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwIf(TKwIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwElse(TKwElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwThen(TKwThen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwRef(TKwRef node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwNothing(TKwNothing node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwReturn(TKwReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLbrace(TLbrace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRbrace(TRbrace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLparen(TLparen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRparen(TRparen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLbracket(TLbracket node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRbracket(TRbracket node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSemicolon(TSemicolon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTColon(TColon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAssign(TAssign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDivision(TDivision node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwMod(TKwMod node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwDiv(TKwDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwAnd(TKwAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwOr(TKwOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNotEqual(TNotEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEquals(TEquals node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLessThan(TLessThan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLessThanEqual(TLessThanEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGreaterThan(TGreaterThan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGreaterThanEqual(TGreaterThanEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwNot(TKwNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdentifier(TIdentifier node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIntConst(TIntConst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCharConst(TCharConst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStringLiteral(TStringLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTErroneousNumber(TErroneousNumber node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhitespace(TWhitespace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComm(TComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
