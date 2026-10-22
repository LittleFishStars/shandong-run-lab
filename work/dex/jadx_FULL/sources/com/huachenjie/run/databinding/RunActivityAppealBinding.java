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
import com.huachenjie.run.page.appeal.AppealActivity;
import com.huachenjie.run.page.appeal.AppealVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityAppealBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f35448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AppealActivity.a f11425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AppealVM f11426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11427a;

    @NonNull
    public final TextView b;

    public RunActivityAppealBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btnSubmit, EditText editAppeal, TextView tvAppealCount, TextView tvAppealTip) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11427a = btnSubmit;
        this.f35448a = editAppeal;
        this.f11424a = tvAppealCount;
        this.b = tvAppealTip;
    }

    public static RunActivityAppealBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityAppealBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityAppealBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_appeal);
    }

    @NonNull
    public static RunActivityAppealBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityAppealBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityAppealBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityAppealBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_appeal, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityAppealBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityAppealBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_appeal, null, false, component);
    }

    @Nullable
    public AppealActivity.a f() {
        return this.f11425a;
    }

    @Nullable
    public AppealVM g() {
        return this.f11426a;
    }

    public abstract void l(@Nullable AppealActivity.a click);

    public abstract void m(@Nullable AppealVM vm);
}
