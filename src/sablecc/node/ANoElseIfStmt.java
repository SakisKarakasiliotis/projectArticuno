/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ANoElseIfStmt extends PIfStmt
{
    private TKwIf _kwIf_;
    private PCondition _condition_;
    private TKwThen _kwThen_;
    private PStatement _thenStmt_;

    public ANoElseIfStmt()
    {
        // Constructor
    }

    public ANoElseIfStmt(
        @SuppressWarnings("hiding") TKwIf _kwIf_,
        @SuppressWarnings("hiding") PCondition _condition_,
        @SuppressWarnings("hiding") TKwThen _kwThen_,
        @SuppressWarnings("hiding") PStatement _thenStmt_)
    {
        // Constructor
        setKwIf(_kwIf_);

        setCondition(_condition_);

        setKwThen(_kwThen_);

        setThenStmt(_thenStmt_);

    }

    @Override
    public Object clone()
    {
        return new ANoElseIfStmt(
            cloneNode(this._kwIf_),
            cloneNode(this._condition_),
            cloneNode(this._kwThen_),
            cloneNode(this._thenStmt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANoElseIfStmt(this);
    }

    public TKwIf getKwIf()
    {
        return this._kwIf_;
    }

    public void setKwIf(TKwIf node)
    {
        if(this._kwIf_ != null)
        {
            this._kwIf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwIf_ = node;
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

    public TKwThen getKwThen()
    {
        return this._kwThen_;
    }

    public void setKwThen(TKwThen node)
    {
        if(this._kwThen_ != null)
        {
            this._kwThen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwThen_ = node;
    }

    public PStatement getThenStmt()
    {
        return this._thenStmt_;
    }

    public void setThenStmt(PStatement node)
    {
        if(this._thenStmt_ != null)
        {
            this._thenStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._thenStmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kwIf_)
            + toString(this._condition_)
            + toString(this._kwThen_)
            + toString(this._thenStmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwIf_ == child)
        {
            this._kwIf_ = null;
            return;
        }

        if(this._condition_ == child)
        {
            this._condition_ = null;
            return;
        }

        if(this._kwThen_ == child)
        {
            this._kwThen_ = null;
            return;
        }

        if(this._thenStmt_ == child)
        {
            this._thenStmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kwIf_ == oldChild)
        {
            setKwIf((TKwIf) newChild);
            return;
        }

        if(this._condition_ == oldChild)
        {
            setCondition((PCondition) newChild);
            return;
        }

        if(this._kwThen_ == oldChild)
        {
            setKwThen((TKwThen) newChild);
            return;
        }

        if(this._thenStmt_ == oldChild)
        {
            setThenStmt((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}