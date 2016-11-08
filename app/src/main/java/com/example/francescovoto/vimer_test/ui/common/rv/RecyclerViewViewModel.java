package com.example.francescovoto.vimer_test.ui.common.rv;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.example.francescovoto.vimer_test.ui.common.viewmodel.ViewModel;

import org.parceler.Parcel;

public abstract class RecyclerViewViewModel extends ViewModel {

    private RecyclerView.LayoutManager layoutManager;
    private Parcelable savedLayoutManagerState;

    public RecyclerViewViewModel() {

    }

    @Override
    public void onCreate(@Nullable State savedInstanceState, @Nullable Bundle extras) {
        if (savedInstanceState instanceof RecyclerViewViewModelState) {
            savedLayoutManagerState =
                    ((RecyclerViewViewModelState) savedInstanceState).layoutManagerState;
        }
    }

    protected abstract RecyclerAdapter getAdapter();

    protected abstract RecyclerView.LayoutManager createLayoutManager(Context context);

    public void setRecyclerView(RecyclerView mRecyclerView) {
        layoutManager = createLayoutManager(mRecyclerView.getContext());
        if (savedLayoutManagerState != null) {
            layoutManager.onRestoreInstanceState(savedLayoutManagerState);
            savedLayoutManagerState = null;
        }
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(getAdapter());
    }

    @Parcel
    public static class RecyclerViewViewModelState extends ViewModel.State {

        public Parcelable layoutManagerState;

        public RecyclerViewViewModelState() {
        }

        protected RecyclerViewViewModelState(RecyclerViewViewModel viewModel) {
            super();
            if (viewModel.layoutManager != null)
                layoutManagerState = viewModel.layoutManager.onSaveInstanceState();
        }
    }
}


