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
import com.huachenjie.college.bean.CampusApplicationBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeItemApplicationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public CampusApplicationBean f33572a;

    public CollegeItemApplicationBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CollegeItemApplicationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeItemApplicationBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeItemApplicationBinding) ViewDataBinding.bind(obj, view, R.layout.college_item_application);
    }

    @NonNull
    public static CollegeItemApplicationBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeItemApplicationBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeItemApplicationBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeItemApplicationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_application, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeItemApplicationBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeItemApplicationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_application, null, false, obj);
    }

    @Nullable
    public CampusApplicationBean f() {
        return this.f33572a;
    }

    public abstract void k(@Nullable CampusApplicationBean campusApplicationBean);
}
