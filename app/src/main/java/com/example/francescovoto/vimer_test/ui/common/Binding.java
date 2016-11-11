package com.example.francescovoto.vimer_test.ui.common;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.francescovoto.vimer_test.R;
import com.example.francescovoto.vimer_test.ui.common.rv.RecyclerViewViewModel;


public class Binding {

    @BindingAdapter("recyclerViewViewModel")
    public static void setRecyclerViewViewModel(RecyclerView recyclerView,
                                                RecyclerViewViewModel viewModel) {
        if(viewModel != null)
            viewModel.setRecyclerView(recyclerView);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .crossFade()
                .into(view);
    }

    @BindingAdapter({"text"})
    public static void setText(TextView view, int text) {
        if(text != 0)
            view.setText(text);
    }
}
