package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.PointActivityBean;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeItemPointActivityListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public PointActivityBean f33576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8407a;

    public CollegeItemPointActivityListBinding(Object obj, View view, int i, BLImageView bLImageView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f8406a = bLImageView;
        this.f8407a = bLTextView;
    }

    public static CollegeItemPointActivityListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeItemPointActivityListBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeItemPointActivityListBinding) ViewDataBinding.bind(obj, view, R.layout.college_item_point_activity_list);
    }

    @NonNull
    public static CollegeItemPointActivityListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeItemPointActivityListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeItemPointActivityListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeItemPointActivityListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_point_activity_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeItemPointActivityListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeItemPointActivityListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_point_activity_list, null, false, obj);
    }

    @Nullable
    public PointActivityBean f() {
        return this.f33576a;
    }

    public abstract void k(@Nullable PointActivityBean pointActivityBean);
}
