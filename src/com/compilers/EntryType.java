package com.compilers;

/**
 * Created by Windows 8 on 01-Jun-17.
 */
public enum EntryType {
    LIBRARY_FUNCTION,
    FUNC_CALL,
    NOTHING,
    BOOLEAN,
    FUNC_DECL,
    FUNC_DEF,
    FUNC_NAME,
    IDENTIFIER,
    STRING_LIT,
    ARRAY,
    VAR,
    REF,
    FUNC_PARAM,
    entryType;

    public EntryType getEntryType (String sType){
        switch (sType){
            case "class sablecc.node.AFDeclLocalDefinition":
                return FUNC_DECL;
            case "class sablecc.node.AFunctionDefinitionFunctionDefinition":
            case "class sablecc.node.AFDefLocalDefinition":
                return FUNC_DEF;
            default:
                return null;
        }
    }


}
