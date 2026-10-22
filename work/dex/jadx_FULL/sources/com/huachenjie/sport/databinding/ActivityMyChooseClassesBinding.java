package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityMyChooseClassesBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseClassesVM f13311a;

    public ActivityMyChooseClassesBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f36418a = frameLayout;
    }

    public static ActivityMyChooseClassesBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMyChooseClassesBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityMyChooseClassesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_my_choose_classes);
    }

    @NonNull
    public static ActivityMyChooseClassesBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityMyChooseClassesBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityMyChooseClassesBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityMyChooseClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_my_choose_classes, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityMyChooseClassesBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityMyChooseClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_my_choose_classes, null, false, obj);
    }

    @Nullable
    public ChooseClassesVM f() {
        return this.f13311a;
    }

    public abstract void k(@Nullable ChooseClassesVM chooseClassesVM);
}
