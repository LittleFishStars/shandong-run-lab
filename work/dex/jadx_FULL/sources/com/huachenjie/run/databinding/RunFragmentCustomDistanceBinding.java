package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.free.CustomDistanceFragment;
import com.huachenjie.run.page.free.CustomDistanceVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunFragmentCustomDistanceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f11815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CustomDistanceFragment.a f11817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CustomDistanceVM f11818a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunFragmentCustomDistanceBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText edInput, TextView tvInputUnit, TextView tvLeftButton, TextView tvRightButton, TextView tvTitle, View vDivider) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11815a = edInput;
        this.f11816a = tvInputUnit;
        this.b = tvLeftButton;
        this.c = tvRightButton;
        this.d = tvTitle;
        this.f35574a = vDivider;
    }

    public static RunFragmentCustomDistanceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunFragmentCustomDistanceBinding d(@NonNull View view, @Nullable Object component) {
        return (RunFragmentCustomDistanceBinding) ViewDataBinding.bind(component, view, R.layout.run_fragment_custom_distance);
    }

    @NonNull
    public static RunFragmentCustomDistanceBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunFragmentCustomDistanceBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunFragmentCustomDistanceBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunFragmentCustomDistanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_custom_distance, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunFragmentCustomDistanceBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunFragmentCustomDistanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_custom_distance, null, false, component);
    }

    @Nullable
    public CustomDistanceFragment.a f() {
        return this.f11817a;
    }

    @Nullable
    public CustomDistanceVM g() {
        return this.f11818a;
    }

    public abstract void l(@Nullable CustomDistanceFragment.a click);

    public abstract void m(@Nullable CustomDistanceVM mState);
}
