/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.parser;

import sablecc.node.*;
import sablecc.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTKwFun(@SuppressWarnings("unused") TKwFun node)
    {
        this.index = 0;
    }

    @Override
    public void caseTKwVar(@SuppressWarnings("unused") TKwVar node)
    {
        this.index = 1;
    }

    @Override
    public void caseTKwChar(@SuppressWarnings("unused") TKwChar node)
    {
        this.index = 2;
    }

    @Override
    public void caseTKwInt(@SuppressWarnings("unused") TKwInt node)
    {
        this.index = 3;
    }

    @Override
    public void caseTKwDo(@SuppressWarnings("unused") TKwDo node)
    {
        this.index = 4;
    }

    @Override
    public void caseTKwWhile(@SuppressWarnings("unused") TKwWhile node)
    {
        this.index = 5;
    }

    @Override
    public void caseTKwIf(@SuppressWarnings("unused") TKwIf node)
    {
        this.index = 6;
    }

    @Override
    public void caseTKwElse(@SuppressWarnings("unused") TKwElse node)
    {
        this.index = 7;
    }

    @Override
    public void caseTKwThen(@SuppressWarnings("unused") TKwThen node)
    {
        this.index = 8;
    }

    @Override
    public void caseTKwRef(@SuppressWarnings("unused") TKwRef node)
    {
        this.index = 9;
    }

    @Override
    public void caseTKwNothing(@SuppressWarnings("unused") TKwNothing node)
    {
        this.index = 10;
    }

    @Override
    public void caseTKwReturn(@SuppressWarnings("unused") TKwReturn node)
    {
        this.index = 11;
    }

    @Override
    public void caseTLbrace(@SuppressWarnings("unused") TLbrace node)
    {
        this.index = 12;
    }

    @Override
    public void caseTRbrace(@SuppressWarnings("unused") TRbrace node)
    {
        this.index = 13;
    }

    @Override
    public void caseTLparen(@SuppressWarnings("unused") TLparen node)
    {
        this.index = 14;
    }

    @Override
    public void caseTRparen(@SuppressWarnings("unused") TRparen node)
    {
        this.index = 15;
    }

    @Override
    public void caseTLbracket(@SuppressWarnings("unused") TLbracket node)
    {
        this.index = 16;
    }

    @Override
    public void caseTRbracket(@SuppressWarnings("unused") TRbracket node)
    {
        this.index = 17;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 18;
    }

    @Override
    public void caseTSemicolon(@SuppressWarnings("unused") TSemicolon node)
    {
        this.index = 19;
    }

    @Override
    public void caseTColon(@SuppressWarnings("unused") TColon node)
    {
        this.index = 20;
    }

    @Override
    public void caseTAssign(@SuppressWarnings("unused") TAssign node)
    {
        this.index = 21;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 22;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 23;
    }

    @Override
    public void caseTMult(@SuppressWarnings("unused") TMult node)
    {
        this.index = 24;
    }

    @Override
    public void caseTDivision(@SuppressWarnings("unused") TDivision node)
    {
        this.index = 25;
    }

    @Override
    public void caseTKwMod(@SuppressWarnings("unused") TKwMod node)
    {
        this.index = 26;
    }

    @Override
    public void caseTKwDiv(@SuppressWarnings("unused") TKwDiv node)
    {
        this.index = 27;
    }

    @Override
    public void caseTKwAnd(@SuppressWarnings("unused") TKwAnd node)
    {
        this.index = 28;
    }

    @Override
    public void caseTKwOr(@SuppressWarnings("unused") TKwOr node)
    {
        this.index = 29;
    }

    @Override
    public void caseTNotEqual(@SuppressWarnings("unused") TNotEqual node)
    {
        this.index = 30;
    }

    @Override
    public void caseTEquals(@SuppressWarnings("unused") TEquals node)
    {
        this.index = 31;
    }

    @Override
    public void caseTLessThan(@SuppressWarnings("unused") TLessThan node)
    {
        this.index = 32;
    }

    @Override
    public void caseTLessThanEqual(@SuppressWarnings("unused") TLessThanEqual node)
    {
        this.index = 33;
    }

    @Override
    public void caseTGreaterThan(@SuppressWarnings("unused") TGreaterThan node)
    {
        this.index = 34;
    }

    @Override
    public void caseTGreaterThanEqual(@SuppressWarnings("unused") TGreaterThanEqual node)
    {
        this.index = 35;
    }

    @Override
    public void caseTKwNot(@SuppressWarnings("unused") TKwNot node)
    {
        this.index = 36;
    }

    @Override
    public void caseTIdentifier(@SuppressWarnings("unused") TIdentifier node)
    {
        this.index = 37;
    }

    @Override
    public void caseTIntConst(@SuppressWarnings("unused") TIntConst node)
    {
        this.index = 38;
    }

    @Override
    public void caseTCharConst(@SuppressWarnings("unused") TCharConst node)
    {
        this.index = 39;
    }

    @Override
    public void caseTStringLiteral(@SuppressWarnings("unused") TStringLiteral node)
    {
        this.index = 40;
    }

    @Override
    public void caseTErroneousNumber(@SuppressWarnings("unused") TErroneousNumber node)
    {
        this.index = 41;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 42;
    }
}
