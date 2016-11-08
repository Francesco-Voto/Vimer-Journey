package com.example.francescovoto.vimer_test.ui.common.rv;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ViewHolder<T, V extends ViewDataBinding> extends RecyclerView.ViewHolder {

    V mViewDataBinding;
    public T mItem;

    ViewHolder(final View view) {
        super(view);
        mViewDataBinding = DataBindingUtil.bind(view);
    }

}
