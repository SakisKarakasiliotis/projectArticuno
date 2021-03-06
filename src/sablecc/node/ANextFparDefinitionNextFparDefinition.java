/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ANextFparDefinitionNextFparDefinition extends PNextFparDefinition
{
    private PFparDefinition _fparDefinition_;

    public ANextFparDefinitionNextFparDefinition()
    {
        // Constructor
    }

    public ANextFparDefinitionNextFparDefinition(
        @SuppressWarnings("hiding") PFparDefinition _fparDefinition_)
    {
        // Constructor
        setFparDefinition(_fparDefinition_);

    }

    @Override
    public Object clone()
    {
        return new ANextFparDefinitionNextFparDefinition(
            cloneNode(this._fparDefinition_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANextFparDefinitionNextFparDefinition(this);
    }

    public PFparDefinition getFparDefinition()
    {
        return this._fparDefinition_;
    }

    public void setFparDefinition(PFparDefinition node)
    {
        if(this._fparDefinition_ != null)
        {
            this._fparDefinition_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fparDefinition_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._fparDefinition_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._fparDefinition_ == child)
        {
            this._fparDefinition_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._fparDefinition_ == oldChild)
        {
            setFparDefinition((PFparDefinition) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
