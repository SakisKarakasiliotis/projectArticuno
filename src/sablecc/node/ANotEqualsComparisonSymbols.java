/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ANotEqualsComparisonSymbols extends PComparisonSymbols
{
    private TNotEqual _notEqual_;

    public ANotEqualsComparisonSymbols()
    {
        // Constructor
    }

    public ANotEqualsComparisonSymbols(
        @SuppressWarnings("hiding") TNotEqual _notEqual_)
    {
        // Constructor
        setNotEqual(_notEqual_);

    }

    @Override
    public Object clone()
    {
        return new ANotEqualsComparisonSymbols(
            cloneNode(this._notEqual_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANotEqualsComparisonSymbols(this);
    }

    public TNotEqual getNotEqual()
    {
        return this._notEqual_;
    }

    public void setNotEqual(TNotEqual node)
    {
        if(this._notEqual_ != null)
        {
            this._notEqual_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._notEqual_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._notEqual_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._notEqual_ == child)
        {
            this._notEqual_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._notEqual_ == oldChild)
        {
            setNotEqual((TNotEqual) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
