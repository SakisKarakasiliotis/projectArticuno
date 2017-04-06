/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class AFCallStmtWithElse extends PStmtWithElse
{
    private PFuncCall _funcCall_;
    private TSemicolon _semicolon_;

    public AFCallStmtWithElse()
    {
        // Constructor
    }

    public AFCallStmtWithElse(
        @SuppressWarnings("hiding") PFuncCall _funcCall_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_)
    {
        // Constructor
        setFuncCall(_funcCall_);

        setSemicolon(_semicolon_);

    }

    @Override
    public Object clone()
    {
        return new AFCallStmtWithElse(
            cloneNode(this._funcCall_),
            cloneNode(this._semicolon_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFCallStmtWithElse(this);
    }

    public PFuncCall getFuncCall()
    {
        return this._funcCall_;
    }

    public void setFuncCall(PFuncCall node)
    {
        if(this._funcCall_ != null)
        {
            this._funcCall_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._funcCall_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._funcCall_)
            + toString(this._semicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._funcCall_ == child)
        {
            this._funcCall_ = null;
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._funcCall_ == oldChild)
        {
            setFuncCall((PFuncCall) newChild);
            return;
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}