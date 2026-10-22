package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class FragmentAppealListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BaseSmartRefreshLayout f13418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f13419a;

    public FragmentAppealListBinding(@NonNull ShadowConstraintLayout shadowConstraintLayout, @NonNull RecyclerView recyclerView, @NonNull BaseSmartRefreshLayout baseSmartRefreshLayout, @NonNull TextView textView) {
        this.f13419a = shadowConstraintLayout;
        this.f13417a = recyclerView;
        this.f13418a = baseSmartRefreshLayout;
        this.f36457a = textView;
    }

    @NonNull
    public static FragmentAppealListBinding a(@NonNull View view) {
        int i = R.id.recycler_appeal_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.refreshlayout_appeal_list;
            BaseSmartRefreshLayout baseSmartRefreshLayout = (BaseSmartRefreshLayout) ViewBindings.findChildViewById(view, i);
            if (baseSmartRefreshLayout != null) {
                i = R.id.tv_sport_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FragmentAppealListBinding((ShadowConstraintLayout) view, recyclerView, baseSmartRefreshLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static FragmentAppealListBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentAppealListBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_appeal_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShadowConstraintLayout getRoot() {
        return this.f13419a;
    }
}
