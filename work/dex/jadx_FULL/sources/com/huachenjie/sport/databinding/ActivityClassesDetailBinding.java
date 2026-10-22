package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.ClassesDetailActivity;
import com.huachenjie.sport.page.mine.choose_classes.ClassesDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityClassesDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ClassesDetailActivity.a f36383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ClassesDetailVM f13176a;

    public ActivityClassesDetailBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityClassesDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityClassesDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityClassesDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_classes_detail);
    }

    @NonNull
    public static ActivityClassesDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityClassesDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityClassesDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityClassesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_classes_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityClassesDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityClassesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_classes_detail, null, false, obj);
    }

    @Nullable
    public ClassesDetailActivity.a f() {
        return this.f36383a;
    }

    @Nullable
    public ClassesDetailVM g() {
        return this.f13176a;
    }

    public abstract void l(@Nullable ClassesDetailActivity.a aVar);

    public abstract void m(@Nullable ClassesDetailVM classesDetailVM);
}
