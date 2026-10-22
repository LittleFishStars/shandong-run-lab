package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunFragmentFreeRecordBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BaseSmartRefreshLayout f11826a;

    public RunFragmentFreeRecordBinding(@NonNull FrameLayout rootView, @NonNull RecyclerView recyclerRecordList, @NonNull BaseSmartRefreshLayout refreshlayoutRecordList) {
        this.f35579a = rootView;
        this.f11825a = recyclerRecordList;
        this.f11826a = refreshlayoutRecordList;
    }

    @NonNull
    public static RunFragmentFreeRecordBinding a(@NonNull View rootView) {
        int i = R.id.recycler_record_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
        if (recyclerView != null) {
            i = R.id.refreshlayout_record_list;
            BaseSmartRefreshLayout baseSmartRefreshLayout = (BaseSmartRefreshLayout) ViewBindings.findChildViewById(rootView, i);
            if (baseSmartRefreshLayout != null) {
                return new RunFragmentFreeRecordBinding((FrameLayout) rootView, recyclerView, baseSmartRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunFragmentFreeRecordBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunFragmentFreeRecordBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_fragment_free_record, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f35579a;
    }
}
