package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.RunIndexActivity;
import com.huachenjie.run.page.run_index.RunIndexVM;
import com.noober.background.view.BLConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityIndexBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunIndexActivity.a f11499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunIndexVM f11500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11501a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11502b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunActivityIndexBinding(Object _bindingComponent, View _root, int _localFieldCount, BLConstraintLayout bottomActionBar, FrameLayout flFd, ImageView ivAlipayBind, ImageView ivGoRun, LayoutToolbarBindingBinding toolBar, TextView tvMenuGuide, TextView tvMenuRule, TextView tvMenuService, TextView tvMenuSetting) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11501a = bottomActionBar;
        this.f35472a = flFd;
        this.f11496a = ivAlipayBind;
        this.b = ivGoRun;
        this.f11498a = toolBar;
        this.f11497a = tvMenuGuide;
        this.f11502b = tvMenuRule;
        this.c = tvMenuService;
        this.d = tvMenuSetting;
    }

    public static RunActivityIndexBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityIndexBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityIndexBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_index);
    }

    @NonNull
    public static RunActivityIndexBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityIndexBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityIndexBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityIndexBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_index, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityIndexBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityIndexBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_index, null, false, component);
    }

    @Nullable
    public RunIndexActivity.a f() {
        return this.f11499a;
    }

    @Nullable
    public RunIndexVM g() {
        return this.f11500a;
    }

    public abstract void l(@Nullable RunIndexActivity.a click);

    public abstract void m(@Nullable RunIndexVM vm);
}
