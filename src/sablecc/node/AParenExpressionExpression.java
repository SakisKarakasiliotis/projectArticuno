/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class AParenExpressionExpression extends PExpression
{
    private TLparen _lparen_;
    private PExpressionB _expressionB_;
    private TRparen _rparen_;

    public AParenExpressionExpression()
    {
        // Constructor
    }

    public AParenExpressionExpression(
        @SuppressWarnings("hiding") TLparen _lparen_,
        @SuppressWarnings("hiding") PExpressionB _expressionB_,
        @SuppressWarnings("hiding") TRparen _rparen_)
    {
        // Constructor
        setLparen(_lparen_);

        setExpressionB(_expressionB_);

        setRparen(_rparen_);

    }

    @Override
    public Object clone()
    {
        return new AParenExpressionExpression(
            cloneNode(this._lparen_),
            cloneNode(this._expressionB_),
            cloneNode(this._rparen_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParenExpressionExpression(this);
    }

    public TLparen getLparen()
    {
        return this._lparen_;
    }

    public void setLparen(TLparen node)
    {
        if(this._lparen_ != null)
        {
            this._lparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lparen_ = node;
    }

    public PExpressionB getExpressionB()
    {
        return this._expressionB_;
    }

    public void setExpressionB(PExpressionB node)
    {
        if(this._expressionB_ != null)
        {
            this._expressionB_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionB_ = node;
    }

    public TRparen getRparen()
    {
        return this._rparen_;
    }

    public void setRparen(TRparen node)
    {
        if(this._rparen_ != null)
        {
            this._rparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rparen_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lparen_)
            + toString(this._expressionB_)
            + toString(this._rparen_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lparen_ == child)
        {
            this._lparen_ = null;
            return;
        }

        if(this._expressionB_ == child)
        {
            this._expressionB_ = null;
            return;
        }

        if(this._rparen_ == child)
        {
            this._rparen_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lparen_ == oldChild)
        {
            setLparen((TLparen) newChild);
            return;
        }

        if(this._expressionB_ == oldChild)
        {
            setExpressionB((PExpressionB) newChild);
            return;
        }

        if(this._rparen_ == oldChild)
        {
            setRparen((TRparen) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
