/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ACharacterDataType extends PDataType
{
    private TKwChar _kwChar_;

    public ACharacterDataType()
    {
        // Constructor
    }

    public ACharacterDataType(
        @SuppressWarnings("hiding") TKwChar _kwChar_)
    {
        // Constructor
        setKwChar(_kwChar_);

    }

    @Override
    public Object clone()
    {
        return new ACharacterDataType(
            cloneNode(this._kwChar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACharacterDataType(this);
    }

    public TKwChar getKwChar()
    {
        return this._kwChar_;
    }

    public void setKwChar(TKwChar node)
    {
        if(this._kwChar_ != null)
        {
            this._kwChar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwChar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kwChar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwChar_ == child)
        {
            this._kwChar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kwChar_ == oldChild)
        {
            setKwChar((TKwChar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
