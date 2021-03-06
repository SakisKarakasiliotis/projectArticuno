/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import java.util.*;
import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ATypeType extends PType
{
    private PDataType _dataType_;
    private final LinkedList<PArraySize> _arraySize_ = new LinkedList<PArraySize>();

    public ATypeType()
    {
        // Constructor
    }

    public ATypeType(
        @SuppressWarnings("hiding") PDataType _dataType_,
        @SuppressWarnings("hiding") List<?> _arraySize_)
    {
        // Constructor
        setDataType(_dataType_);

        setArraySize(_arraySize_);

    }

    @Override
    public Object clone()
    {
        return new ATypeType(
            cloneNode(this._dataType_),
            cloneList(this._arraySize_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATypeType(this);
    }

    public PDataType getDataType()
    {
        return this._dataType_;
    }

    public void setDataType(PDataType node)
    {
        if(this._dataType_ != null)
        {
            this._dataType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dataType_ = node;
    }

    public LinkedList<PArraySize> getArraySize()
    {
        return this._arraySize_;
    }

    public void setArraySize(List<?> list)
    {
        for(PArraySize e : this._arraySize_)
        {
            e.parent(null);
        }
        this._arraySize_.clear();

        for(Object obj_e : list)
        {
            PArraySize e = (PArraySize) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._arraySize_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._dataType_)
            + toString(this._arraySize_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dataType_ == child)
        {
            this._dataType_ = null;
            return;
        }

        if(this._arraySize_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._dataType_ == oldChild)
        {
            setDataType((PDataType) newChild);
            return;
        }

        for(ListIterator<PArraySize> i = this._arraySize_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PArraySize) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
