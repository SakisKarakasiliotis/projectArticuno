var toPrint = ['AProgram','AFunctionDefinition','AHeader','AFDefLocalDefinition','AFDeclLocalDefinition','AVarDefLocalDefinition','ABlock','AFparDefinition','ANextFparDefinition','ADataTypeRetType','ANothingRetType','AIntegerDataType','ACharacterDataType','AType','AFunctionDeclaration','AFparType','AVarDefinition','ANextIdentifier','ANoopStatement','AAssignmentStatement','AIfStatement','ABlockStatement','AFCallStatement','AWhileDoStatement','AReturnStatement','ANoElseIfStmt','AWithElseIfStmt','ANoopStmtWithElse','AAssignmentStmtWithElse','AIfStmtWithElse','ABlockStmtWithElse','AFCallStmtWithElse','AWhileDoStmtWithElse','AReturnStmtWithElse','AIfElseStmt','AFuncCall','AIdentifierLValue','AStringLitLValue','AArrayAssignLValue','AArrayExpression','AStringExpression','ACharConstExpression','AFCallExpression','AParenExpressionExpression','ASignedExpressionExpression','ANumOperExpression','AArrayExpressionB','AStringExpressionB','ACharConstExpressionB','AFCallExpressionB','ASignedExpressionExpressionB','ACondExpCondition','APlusSign','AMinusSign','ANextExpression','AMultipleExpressions','AArraySize','AEmptyBrackets','AArray','AArrayPosition','AOrLogicOperations','AAndLogicOperations','ANotLogicOperations','AEqualsComparisonSymbols','ANotEqualsComparisonSymbols','ALessThanComparisonSymbols','AGreaterThanComparisonSymbols','AGreaterOrEqualComparisonSymbols','ALessOrEqualComparisonSymbols','APlusExpNExp','AMinusExpNExp','ATermNExp','ATermMultTerm','ATermDivTerm','ATermModTerm','AExponentTerm','AUnsignedExponent','ANonParenFinal','AParenExpFinal','AIdenFinal','AOrExpCompExp','ANoOrExpCompExp','AAndExprCompTerm','ANoAndExpCompTerm','ANotExpCompFun','ANoNotExpCompFun','AEqualsCompVal','ANotEqualsCompVal','ALessThanCompVal','AGreaterThanCompVal','AGreaterOrEqualCompVal','ALessOrEqualCompVal','ANoCompExpCompVal','AExprCompFinal'];
$('document').ready(function(){
	var printable= '';
	for(var i=0; i<toPrint.length; i++){
		printable += `@Override
public void in`+toPrint[i]+`(`+toPrint[i]+` node){
    printIndentation();
    System.out.println("[`+toPrint[i].slice(1)+`]: "+node.toString());
    addIndentationLevel();
}

@Override
public void out`+toPrint[i]+`(`+toPrint[i]+` node){
    removeIndentationLevel();
}`;
	$('#code').html(printable);
	}

});