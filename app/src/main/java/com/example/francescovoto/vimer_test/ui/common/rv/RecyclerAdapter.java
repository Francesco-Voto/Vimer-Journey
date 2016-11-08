package com.example.francescovoto.vimer_test.ui.common.rv;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.francescovoto.vimer_test.BR;


public abstract class RecyclerAdapter<T, V extends ViewDataBinding>
        extends RecyclerView.Adapter<ViewHolder<T,V>> implements View.OnClickListener
{
    private static final int ITEM_MODEL = -124;

    @LayoutRes
    private final int layoutId;

    private final ClickHandler<T> clickHandler;
    protected T[] items;
    private int mSize;

    /**
     * @param layoutId: the res of layout for showing single element
     * @param clickHandler: the handler put in place for click event
     */
    public RecyclerAdapter(int layoutId, @Nullable ClickHandler<T> clickHandler) {
        this.layoutId = layoutId;
        this.clickHandler = clickHandler;
    }

    public void setDataSet(T[] items){
        this.items = items;
        if(this.items == null){
            mSize = 0;
        }else {
            this.mSize = items.length;
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder<T,V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder<>
                (LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder<T,V> holder, int position) {
        holder.mViewDataBinding.setVariable(BR.item,items[position]);
        if (clickHandler != null) {
            holder.mViewDataBinding.getRoot().setTag(ITEM_MODEL, items[position]);
            holder.mViewDataBinding.getRoot().setOnClickListener(this);
        }
        holder.mViewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mSize;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onClick(View v) {
        if (clickHandler != null)
            clickHandler.onClick((T) v.getTag(ITEM_MODEL), v);
    }

}
