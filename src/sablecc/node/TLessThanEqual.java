/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TLessThanEqual extends Token
{
    public TLessThanEqual()
    {
        super.setText("<=");
    }

    public TLessThanEqual(int line, int pos)
    {
        super.setText("<=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLessThanEqual(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLessThanEqual(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLessThanEqual text.");
    }
}
