package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.common.base.data_binding.BaseTitleVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeActivityLightningPlayBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleVM f8366a;

    public CollegeActivityLightningPlayBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f33559a = frameLayout;
    }

    public static CollegeActivityLightningPlayBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeActivityLightningPlayBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeActivityLightningPlayBinding) ViewDataBinding.bind(obj, view, R.layout.college_activity_lightning_play);
    }

    @NonNull
    public static CollegeActivityLightningPlayBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeActivityLightningPlayBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeActivityLightningPlayBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeActivityLightningPlayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_lightning_play, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeActivityLightningPlayBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeActivityLightningPlayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_lightning_play, null, false, obj);
    }

    @Nullable
    public BaseTitleVM f() {
        return this.f8366a;
    }

    public abstract void k(@Nullable BaseTitleVM baseTitleVM);
}
