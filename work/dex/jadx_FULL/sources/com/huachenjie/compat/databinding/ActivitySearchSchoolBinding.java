package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout;
import com.huachenjie.compat.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class ActivitySearchSchoolBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34048a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BaseSmartRefreshLayout f9147a;

    public ActivitySearchSchoolBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull BaseSmartRefreshLayout baseSmartRefreshLayout) {
        this.f9145a = linearLayout;
        this.f34048a = editText;
        this.f9144a = imageView;
        this.f9146a = recyclerView;
        this.f9147a = baseSmartRefreshLayout;
    }

    @NonNull
    public static ActivitySearchSchoolBinding a(@NonNull View view) {
        int i = R.id.edit_search;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.iv_cancel;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.recycler_school_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.refreshlayout_school_list;
                    BaseSmartRefreshLayout baseSmartRefreshLayout = (BaseSmartRefreshLayout) ViewBindings.findChildViewById(view, i);
                    if (baseSmartRefreshLayout != null) {
                        return new ActivitySearchSchoolBinding((LinearLayout) view, editText, imageView, recyclerView, baseSmartRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivitySearchSchoolBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySearchSchoolBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_search_school, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9145a;
    }
}
