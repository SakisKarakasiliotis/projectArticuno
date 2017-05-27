package com.compilers;

import sablecc.lexer.Lexer;
import sablecc.lexer.LexerException;
import sablecc.node.Start;
import sablecc.parser.Parser;
import sablecc.parser.ParserException;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) {

        try {
            Start tree = null;
            FileReader infile = new FileReader(args[0]);
            Lexer l = new Lexer(new PushbackReader(new BufferedReader(infile),1024));
            Parser p = new Parser(l);
            tree = p.parse();
            tree.apply(new SemanticAnalyzer());
        } catch (LexerException e) {
            System.err.printf("Lexing error: %s\n", e.getMessage());
        } catch (IOException e) {
            System.err.printf("I/O error: %s\n", e.getMessage());
            e.printStackTrace();
        } catch (ParserException e) {
            System.err.printf("Parsing error: %s\n", e.getMessage());
        }
    }
}
