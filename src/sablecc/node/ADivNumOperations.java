/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ADivNumOperations extends PNumOperations
{
    private TKwDiv _kwDiv_;

    public ADivNumOperations()
    {
        // Constructor
    }

    public ADivNumOperations(
        @SuppressWarnings("hiding") TKwDiv _kwDiv_)
    {
        // Constructor
        setKwDiv(_kwDiv_);

    }

    @Override
    public Object clone()
    {
        return new ADivNumOperations(
            cloneNode(this._kwDiv_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivNumOperations(this);
    }

    public TKwDiv getKwDiv()
    {
        return this._kwDiv_;
    }

    public void setKwDiv(TKwDiv node)
    {
        if(this._kwDiv_ != null)
        {
            this._kwDiv_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwDiv_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kwDiv_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwDiv_ == child)
        {
            this._kwDiv_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kwDiv_ == oldChild)
        {
            setKwDiv((TKwDiv) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
