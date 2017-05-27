var toPrint = ['AProgramProgram','AFunctionDefinitionFunctionDefinition','AHeaderHeader','AFDefLocalDefinition','AFDeclLocalDefinition','AVarDefLocalDefinition','ABlockBlock','AFparDefinitionFparDefinition','ANextFparDefinitionNextFparDefinition','ADataTypeRetType','ANothingRetType','AIntegerDataType','ACharacterDataType','ATypeType','AFunctionDeclarationFunctionDeclaration','AFparTypeFparType','AVarDefinitionVarDefinition','ANextIdentifierNextIdentifier','ANoopStatement','AAssignmentStatement','ANoElseStatement','AWithElseStatement','ABlockStatement','AFCallStatement','AWhileDoStatement','AReturnStatement','AStatementWithElseStatement','AFuncCallFuncCall','AIdentifierLValue','AStringLitLValue','AArrayAssignLValue','AArrayExpression','AStringExpression','ACharConstExpression','AFCallExpression','AParenExpressionExpression','ASignedExpressionExpression','ANumOperExpression','ACondExpCondition','APlusSign','AMinusSign','AArraySizeArraySize','AEmptyBrackets','AArrayArray','APlusExpNExp','AMinusExpNExp','ATermMultNExp','ATermDivNExp','ATermModNExp','AExponentNExp','ANonParenFinal','AParenExpFinal','AIdenFinal','AOrExpCompExp','AAndExpCompExp','ANotExpCompExp','APlainExpCompExp','AEqualsCompVal','ANotEqualsCompVal','ALessThanCompVal','AGreaterThanCompVal','AGreaterOrEqualCompVal','ALessOrEqualCompVal','ACompFinalCompVal','AExprCompFinal'];



$('document').ready(function(){
	var printable= '';
	for(var i=0; i<toPrint.length; i++){
		printable += `
public void out`+toPrint[i]+`(`+toPrint[i]+` node){
    printIndentation();
    System.out.println("[`+toPrint[i].slice(1)+`]: "+node.toString());
    addIndentationLevel();
}
`;
	$('#code').html(printable);
	}

});


