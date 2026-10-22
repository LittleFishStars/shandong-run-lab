package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutScrollviewWithRecyclerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f8689a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final LinearLayout c;

    public LayoutScrollviewWithRecyclerBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout llFlowList, @NonNull RecyclerView recyclerFlow, @NonNull LinearLayout rootLayout, @NonNull FrameLayout topLayout) {
        this.f8688a = rootView;
        this.b = llFlowList;
        this.f8689a = recyclerFlow;
        this.c = rootLayout;
        this.f33783a = topLayout;
    }

    @NonNull
    public static LayoutScrollviewWithRecyclerBinding a(@NonNull View rootView) {
        int i = R.id.ll_flow_list;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.recycler_flow;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                LinearLayout linearLayout2 = (LinearLayout) rootView;
                i = R.id.top_layout;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                if (frameLayout != null) {
                    return new LayoutScrollviewWithRecyclerBinding(linearLayout2, linearLayout, recyclerView, linearLayout2, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutScrollviewWithRecyclerBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutScrollviewWithRecyclerBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_scrollview_with_recycler, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f8688a;
    }
}
