# Compilers 2017

## Dionisis Karakasiliotis | Kimon Eustathios Skretas
## sdi1000188 | sdi1200165

### Introduction

We developed utilizing Intellij IDEA and by downloading SableCC to our systems. We didn't use a MAVEN build to install it.
The main method expects a file path as argument and then invokes the compiler.

We have corrected the notes you given us on the first submission so we are in a pretty good completion rate for the grammar part.

We have implemented full semantic analysis of the source code in a great extend where we are comfortable that it will detect 
most semantic faults.

We are able to create all the necessary quads in order to create intermediateCode. Alas we have some admissions:

-   Jump and some other methods list their argument not in the jump - - x way rather than jump x - -. This was due to the
 design of the genQuad method which forbids this.

-   We create a new scope (or NEXT) only with each new function scope and not with every statement. This is by design.

We are making a basic translation of our Quads into X86 but it is not fully developed (not all loads and stores utilized) 
and we are printing it in a file.

### Classes

In order to develop our Compiler we implemented the following classes:

-  SemanticAnalyzer

    This class extends DepthFirstAdapter in order for us to properly traverse the AST. All other class instances are initialized 
    here and by the end of parsing we have produced both intermediate and final code.
    
    Contains an instance of the symbolTable.
    
    A varLocations map which returns the place each variable is stored at on the intermediate code.
    
    A strinLiteral map which returns the place stringLiterals are stored at on the intermediate code.
 
    An errorLog list that contains all the semantic errors we uncover and prints them on exit.
    
    Various helping stacks such as assign and return stack which help us collect on various outs. For example assign stack 
    assists as in collecting all expressions on their innermost node (an expression of x+1+y ) and poping them on their 
    outermost parent (an assignment x <- x+1+y). Return stack is used similarly in order to collect various returns throughout the programm. 
    
    Most of the functions we override are simply either:
      - Checking if they are declared on the symbol table (caseIdentifier etc)
      - Adding their return type on the assign stack to be consumed by someone above them (any comparation is consumed by a condition)
      - Adding their name on the symbol table
    
    They most are of course generating quads and adding their identifiers on the varLocations map.
    
    
-  SymbolTable

    This class implements our SymbolTable and all its methods. 
    
    Enter() which creates the scope
   
    Exit() which exits the scope
    
    Various lookup() for different use cases
    
    Various Insert() for different use cases
    
    Some utilities such as print(), getVariableScope() and a loader which loads all the predefined functions (puts, gets etc) 
    to scope 0 in order for them to be availlable to all routines.
    
    The symbol table is a list of stacks of symbolTableEntries. Each list node is a new function scope.

-   SymbolTableEntry

    The primary entity that resides in our symbolTable list of stacks.
    
    Apart from id, type and return type each entry contains a list of SymbolTableEntries for use cases such as functions 
    where we need the function parameters to be inside the symbolTableEntry of the function definition (fprama field).
    
-   EntrType 

    An enumeration that primarily fills the type field of the SymbolTableEntry class.
    
    Contains a function that can return the proper enumeration given the getClass() method of a node. Used only for function def vs decl.
    
-   Quads

    The basic quad (label, op, arg1, arg2, ret).
    
    OP utilizes an Enumerator called Operand to ensure consistency

-   IntermediateCode

    Contains a basic list of all our Quads that gets filled as each scope finishes.
    
    Contains a stack of lists of Quads called next that acts as a separate list for each semantic scope.
    
    Contains a stack of lists of int labels that acts as separate TRUE list for each truthy condition.
    
    Contains a stack of lists of int labels that acts as separate FALSE list for each falsy condition.
    
    Those are the two lists that state where the next backpatch should occur.
    
    Outputs intermediate code either on a file on stdout via calling print(x) with x = true for file and x = false fpor stdout. 
    
- FinalCode

    Contains various routines for the proper creation of the final code of the program. 
    
    Holds no special structures apart from references to the symbolTable, varLocations and stringLiteral.
    
    Implements most of the helping subroutines such as load(), store() etc
    
    Prints on a file.
    
### Logic

At first stage the parser creates the abstract syntax tree.

We are then parsing it top down from our semantic analyzer while also generating our Quads.

Each function definition generates a new scope on the symbol table. 

Upon exiting a scope we generate the appropriate X86.




_you can also view our progress on [this](https://github.com/SakisKarakasiliotis/projectArticuno) github link_

#### Thank you
