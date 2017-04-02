package com.compilers;

import sablecc.lexer.Lexer;
import sablecc.lexer.LexerException;
import sablecc.node.Start;
import sablecc.parser.Parser;
import sablecc.parser.ParserException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

public class Main {

    public static void main(String[] args) {
        Start tree = null;

        PushbackReader reader = new PushbackReader(new InputStreamReader(System.in), 1024);
        try {
            Parser p = new Parser(new Lexer(reader));
            tree = p.parse();
            System.out.println(Evaluator.eval(tree));
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
