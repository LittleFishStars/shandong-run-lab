package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.college.R;
import com.huachenjie.college.page.recreation.RecreationActivity;
import com.huachenjie.college.page.recreation.RecreationVM;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeActivityRecreationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f33564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f8378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RecreationActivity.ClickProxy f8379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RecreationVM f8380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f8381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f8382a;

    public CollegeActivityRecreationBinding(Object obj, View view, int i, BLLinearLayout bLLinearLayout, BLFrameLayout bLFrameLayout, SlidingTabLayout2 slidingTabLayout2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f8382a = bLLinearLayout;
        this.f8381a = bLFrameLayout;
        this.f8378a = slidingTabLayout2;
        this.f33564a = viewPager2;
    }

    public static CollegeActivityRecreationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeActivityRecreationBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeActivityRecreationBinding) ViewDataBinding.bind(obj, view, R.layout.college_activity_recreation);
    }

    @NonNull
    public static CollegeActivityRecreationBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeActivityRecreationBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeActivityRecreationBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeActivityRecreationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_recreation, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeActivityRecreationBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeActivityRecreationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_recreation, null, false, obj);
    }

    @Nullable
    public RecreationActivity.ClickProxy f() {
        return this.f8379a;
    }

    @Nullable
    public RecreationVM g() {
        return this.f8380a;
    }

    public abstract void l(@Nullable RecreationActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable RecreationVM recreationVM);
}
