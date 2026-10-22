package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.college.page.hw_health.HWHealthVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeActivityHwHealthBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HWHealthVM f8336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f8337a;

    public CollegeActivityHwHealthBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView) {
        super(obj, view, i);
        this.f8337a = layoutToolbarBindingBinding;
        this.f33554a = textView;
    }

    public static CollegeActivityHwHealthBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeActivityHwHealthBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeActivityHwHealthBinding) ViewDataBinding.bind(obj, view, R.layout.college_activity_hw_health);
    }

    @NonNull
    public static CollegeActivityHwHealthBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeActivityHwHealthBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeActivityHwHealthBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeActivityHwHealthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_hw_health, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeActivityHwHealthBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeActivityHwHealthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_hw_health, null, false, obj);
    }

    @Nullable
    public HWHealthVM f() {
        return this.f8336a;
    }

    public abstract void k(@Nullable HWHealthVM hWHealthVM);
}
