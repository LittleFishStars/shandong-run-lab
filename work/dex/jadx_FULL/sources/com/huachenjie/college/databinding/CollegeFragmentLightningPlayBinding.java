package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.college.R;
import com.huachenjie.common.base.data_binding.BaseTitleVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeFragmentLightningPlayBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WebContentView f33570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleVM f8392a;

    public CollegeFragmentLightningPlayBinding(Object obj, View view, int i, WebContentView webContentView) {
        super(obj, view, i);
        this.f33570a = webContentView;
    }

    public static CollegeFragmentLightningPlayBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeFragmentLightningPlayBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeFragmentLightningPlayBinding) ViewDataBinding.bind(obj, view, R.layout.college_fragment_lightning_play);
    }

    @NonNull
    public static CollegeFragmentLightningPlayBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeFragmentLightningPlayBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeFragmentLightningPlayBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeFragmentLightningPlayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_fragment_lightning_play, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeFragmentLightningPlayBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeFragmentLightningPlayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_fragment_lightning_play, null, false, obj);
    }

    @Nullable
    public BaseTitleVM f() {
        return this.f8392a;
    }

    public abstract void k(@Nullable BaseTitleVM baseTitleVM);
}
