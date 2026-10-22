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
import com.huachenjie.run.page.free.CustomCaloriesFragment;
import com.huachenjie.run.page.free.CustomCaloriesVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunFragmentCustomCaloriesBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f11805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CustomCaloriesFragment.a f11807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CustomCaloriesVM f11808a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunFragmentCustomCaloriesBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText edInput, TextView tvInputUnit, TextView tvLeftButton, TextView tvRightButton, TextView tvTitle, View vDivider) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11805a = edInput;
        this.f11806a = tvInputUnit;
        this.b = tvLeftButton;
        this.c = tvRightButton;
        this.d = tvTitle;
        this.f35569a = vDivider;
    }

    public static RunFragmentCustomCaloriesBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunFragmentCustomCaloriesBinding d(@NonNull View view, @Nullable Object component) {
        return (RunFragmentCustomCaloriesBinding) ViewDataBinding.bind(component, view, R.layout.run_fragment_custom_calories);
    }

    @NonNull
    public static RunFragmentCustomCaloriesBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunFragmentCustomCaloriesBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunFragmentCustomCaloriesBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunFragmentCustomCaloriesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_custom_calories, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunFragmentCustomCaloriesBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunFragmentCustomCaloriesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_custom_calories, null, false, component);
    }

    @Nullable
    public CustomCaloriesFragment.a f() {
        return this.f11807a;
    }

    @Nullable
    public CustomCaloriesVM g() {
        return this.f11808a;
    }

    public abstract void l(@Nullable CustomCaloriesFragment.a click);

    public abstract void m(@Nullable CustomCaloriesVM mState);
}
