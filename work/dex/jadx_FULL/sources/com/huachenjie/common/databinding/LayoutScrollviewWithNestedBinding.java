package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.UnTouchNestedScrollView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutScrollviewWithNestedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UnTouchNestedScrollView f8686a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8687b;

    public LayoutScrollviewWithNestedBinding(@NonNull RelativeLayout rootView, @NonNull FrameLayout aboveTopLayout, @NonNull LinearLayout llFlowList, @NonNull RelativeLayout rootLayout, @NonNull UnTouchNestedScrollView scrollviewInner, @NonNull FrameLayout topLayout) {
        this.f8685a = rootView;
        this.f33782a = aboveTopLayout;
        this.f8684a = llFlowList;
        this.f8687b = rootLayout;
        this.f8686a = scrollviewInner;
        this.b = topLayout;
    }

    @NonNull
    public static LayoutScrollviewWithNestedBinding a(@NonNull View rootView) {
        int i = R.id.above_top_layout;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.ll_flow_list;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                i = R.id.scrollview_inner;
                UnTouchNestedScrollView unTouchNestedScrollView = (UnTouchNestedScrollView) ViewBindings.findChildViewById(rootView, i);
                if (unTouchNestedScrollView != null) {
                    i = R.id.top_layout;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                    if (frameLayout2 != null) {
                        return new LayoutScrollviewWithNestedBinding(relativeLayout, frameLayout, linearLayout, relativeLayout, unTouchNestedScrollView, frameLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutScrollviewWithNestedBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutScrollviewWithNestedBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_scrollview_with_nested, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f8685a;
    }
}
