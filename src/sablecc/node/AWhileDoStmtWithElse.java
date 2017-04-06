/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class AWhileDoStmtWithElse extends PStmtWithElse
{
    private TKwWhile _kwWhile_;
    private PCondition _condition_;
    private TKwDo _kwDo_;
    private PStmtWithElse _stmtWithElse_;

    public AWhileDoStmtWithElse()
    {
        // Constructor
    }

    public AWhileDoStmtWithElse(
        @SuppressWarnings("hiding") TKwWhile _kwWhile_,
        @SuppressWarnings("hiding") PCondition _condition_,
        @SuppressWarnings("hiding") TKwDo _kwDo_,
        @SuppressWarnings("hiding") PStmtWithElse _stmtWithElse_)
    {
        // Constructor
        setKwWhile(_kwWhile_);

        setCondition(_condition_);

        setKwDo(_kwDo_);

        setStmtWithElse(_stmtWithElse_);

    }

    @Override
    public Object clone()
    {
        return new AWhileDoStmtWithElse(
            cloneNode(this._kwWhile_),
            cloneNode(this._condition_),
            cloneNode(this._kwDo_),
            cloneNode(this._stmtWithElse_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWhileDoStmtWithElse(this);
    }

    public TKwWhile getKwWhile()
    {
        return this._kwWhile_;
    }

    public void setKwWhile(TKwWhile node)
    {
        if(this._kwWhile_ != null)
        {
            this._kwWhile_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwWhile_ = node;
    }

    public PCondition getCondition()
    {
        return this._condition_;
    }

    public void setCondition(PCondition node)
    {
        if(this._condition_ != null)
        {
            this._condition_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._condition_ = node;
    }

    public TKwDo getKwDo()
    {
        return this._kwDo_;
    }

    public void setKwDo(TKwDo node)
    {
        if(this._kwDo_ != null)
        {
            this._kwDo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwDo_ = node;
    }

    public PStmtWithElse getStmtWithElse()
    {
        return this._stmtWithElse_;
    }

    public void setStmtWithElse(PStmtWithElse node)
    {
        if(this._stmtWithElse_ != null)
        {
            this._stmtWithElse_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._stmtWithElse_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kwWhile_)
            + toString(this._condition_)
            + toString(this._kwDo_)
            + toString(this._stmtWithElse_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwWhile_ == child)
        {
            this._kwWhile_ = null;
            return;
        }

        if(this._condition_ == child)
        {
            this._condition_ = null;
            return;
        }

        if(this._kwDo_ == child)
        {
            this._kwDo_ = null;
            return;
        }

        if(this._stmtWithElse_ == child)
        {
            this._stmtWithElse_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kwWhile_ == oldChild)
        {
            setKwWhile((TKwWhile) newChild);
            return;
        }

        if(this._condition_ == oldChild)
        {
            setCondition((PCondition) newChild);
            return;
        }

        if(this._kwDo_ == oldChild)
        {
            setKwDo((TKwDo) newChild);
            return;
        }

        if(this._stmtWithElse_ == oldChild)
        {
            setStmtWithElse((PStmtWithElse) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}