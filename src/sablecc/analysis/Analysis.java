/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.analysis;

import sablecc.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgram(AProgram node);
    void caseAFunctionDefinition(AFunctionDefinition node);
    void caseAHeader(AHeader node);
    void caseAFDefLocalDefinition(AFDefLocalDefinition node);
    void caseAFDeclLocalDefinition(AFDeclLocalDefinition node);
    void caseAVarDefLocalDefinition(AVarDefLocalDefinition node);
    void caseABlock(ABlock node);
    void caseAFparDefinition(AFparDefinition node);
    void caseANextFparDefinition(ANextFparDefinition node);
    void caseADataTypeRetType(ADataTypeRetType node);
    void caseANothingRetType(ANothingRetType node);
    void caseAIntegerDataType(AIntegerDataType node);
    void caseACharacterDataType(ACharacterDataType node);
    void caseAType(AType node);
    void caseAFunctionDeclaration(AFunctionDeclaration node);
    void caseAFparType(AFparType node);
    void caseAVarDefinition(AVarDefinition node);
    void caseANextIdentifier(ANextIdentifier node);
    void caseANoopStatement(ANoopStatement node);
    void caseAAssignmentStatement(AAssignmentStatement node);
    void caseANoElseStatement(ANoElseStatement node);
    void caseAWithElseStatement(AWithElseStatement node);
    void caseABlockStatement(ABlockStatement node);
    void caseAFCallStatement(AFCallStatement node);
    void caseAWhileDoStatement(AWhileDoStatement node);
    void caseAReturnStatement(AReturnStatement node);
    void caseAStatementWithElseStatement(AStatementWithElseStatement node);
    void caseAFuncCallFuncCall(AFuncCallFuncCall node);
    void caseAIdentifierLValue(AIdentifierLValue node);
    void caseAStringLitLValue(AStringLitLValue node);
    void caseAArrayAssignLValue(AArrayAssignLValue node);
    void caseAArrayExpression(AArrayExpression node);
    void caseAStringExpression(AStringExpression node);
    void caseACharConstExpression(ACharConstExpression node);
    void caseAFCallExpression(AFCallExpression node);
    void caseAParenExpressionExpression(AParenExpressionExpression node);
    void caseASignedExpressionExpression(ASignedExpressionExpression node);
    void caseANumOperExpression(ANumOperExpression node);
    void caseACondExpCondition(ACondExpCondition node);
    void caseAPlusSign(APlusSign node);
    void caseAMinusSign(AMinusSign node);
    void caseAArraySizeArraySize(AArraySizeArraySize node);
    void caseAEmptyBrackets(AEmptyBrackets node);
    void caseAArrayArray(AArrayArray node);
    void caseAPlusExpNExp(APlusExpNExp node);
    void caseAMinusExpNExp(AMinusExpNExp node);
    void caseATermMultNExp(ATermMultNExp node);
    void caseATermDivNExp(ATermDivNExp node);
    void caseATermModNExp(ATermModNExp node);
    void caseAExponentNExp(AExponentNExp node);
    void caseANonParenFinal(ANonParenFinal node);
    void caseAParenExpFinal(AParenExpFinal node);
    void caseAIdenFinal(AIdenFinal node);
    void caseAOrExpCompExp(AOrExpCompExp node);
    void caseAAndExpCompExp(AAndExpCompExp node);
    void caseANotExpCompExp(ANotExpCompExp node);
    void caseAPlainExpCompExp(APlainExpCompExp node);
    void caseAEqualsCompVal(AEqualsCompVal node);
    void caseANotEqualsCompVal(ANotEqualsCompVal node);
    void caseALessThanCompVal(ALessThanCompVal node);
    void caseAGreaterThanCompVal(AGreaterThanCompVal node);
    void caseAGreaterOrEqualCompVal(AGreaterOrEqualCompVal node);
    void caseALessOrEqualCompVal(ALessOrEqualCompVal node);
    void caseACompFinalCompVal(ACompFinalCompVal node);
    void caseAExprCompFinal(AExprCompFinal node);

    void caseTKwFun(TKwFun node);
    void caseTKwVar(TKwVar node);
    void caseTKwChar(TKwChar node);
    void caseTKwInt(TKwInt node);
    void caseTKwDo(TKwDo node);
    void caseTKwWhile(TKwWhile node);
    void caseTKwIf(TKwIf node);
    void caseTKwElse(TKwElse node);
    void caseTKwThen(TKwThen node);
    void caseTKwRef(TKwRef node);
    void caseTKwNothing(TKwNothing node);
    void caseTKwReturn(TKwReturn node);
    void caseTLbrace(TLbrace node);
    void caseTRbrace(TRbrace node);
    void caseTLparen(TLparen node);
    void caseTRparen(TRparen node);
    void caseTLbracket(TLbracket node);
    void caseTRbracket(TRbracket node);
    void caseTComma(TComma node);
    void caseTSemicolon(TSemicolon node);
    void caseTColon(TColon node);
    void caseTAssign(TAssign node);
    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTMult(TMult node);
    void caseTDivision(TDivision node);
    void caseTKwMod(TKwMod node);
    void caseTKwDiv(TKwDiv node);
    void caseTKwAnd(TKwAnd node);
    void caseTKwOr(TKwOr node);
    void caseTNotEqual(TNotEqual node);
    void caseTEquals(TEquals node);
    void caseTLessThan(TLessThan node);
    void caseTLessThanEqual(TLessThanEqual node);
    void caseTGreaterThan(TGreaterThan node);
    void caseTGreaterThanEqual(TGreaterThanEqual node);
    void caseTKwNot(TKwNot node);
    void caseTIdentifier(TIdentifier node);
    void caseTIntConst(TIntConst node);
    void caseTCharConst(TCharConst node);
    void caseTStringLiteral(TStringLiteral node);
    void caseTWhitespace(TWhitespace node);
    void caseTComment(TComment node);
    void caseTComments(TComments node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
