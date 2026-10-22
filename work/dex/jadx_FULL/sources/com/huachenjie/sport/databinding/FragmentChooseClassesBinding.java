package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentChooseClassesBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final StateLayout f36471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseClassesVM f13465a;

    public FragmentChooseClassesBinding(Object obj, View view, int i, StateLayout stateLayout) {
        super(obj, view, i);
        this.f36471a = stateLayout;
    }

    public static FragmentChooseClassesBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentChooseClassesBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentChooseClassesBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_choose_classes);
    }

    @NonNull
    public static FragmentChooseClassesBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentChooseClassesBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentChooseClassesBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentChooseClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_choose_classes, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentChooseClassesBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentChooseClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_choose_classes, null, false, obj);
    }

    @Nullable
    public ChooseClassesVM f() {
        return this.f13465a;
    }

    public abstract void k(@Nullable ChooseClassesVM chooseClassesVM);
}
