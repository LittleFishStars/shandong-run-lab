package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivitySchoolActivityRunSuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f11549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleVM f11550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SchoolActivitySuccessActivity.a f11552a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11553b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public RunActivitySchoolActivityRunSuccessBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView icon1, NestedScrollView scrollView, LayoutToolbarBindingBinding titleBar, TextView tvDistance, TextView tvGoalName1, TextView tvName, TextView tvTime, ImageView tvTimeIcon, TextView tvTimeTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35491a = icon1;
        this.f11549a = scrollView;
        this.f11551a = titleBar;
        this.f11548a = tvDistance;
        this.f11553b = tvGoalName1;
        this.c = tvName;
        this.d = tvTime;
        this.b = tvTimeIcon;
        this.e = tvTimeTitle;
    }

    public static RunActivitySchoolActivityRunSuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivitySchoolActivityRunSuccessBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivitySchoolActivityRunSuccessBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_school_activity_run_success);
    }

    @NonNull
    public static RunActivitySchoolActivityRunSuccessBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivitySchoolActivityRunSuccessBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivitySchoolActivityRunSuccessBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivitySchoolActivityRunSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_school_activity_run_success, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivitySchoolActivityRunSuccessBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivitySchoolActivityRunSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_school_activity_run_success, null, false, component);
    }

    @Nullable
    public SchoolActivitySuccessActivity.a f() {
        return this.f11552a;
    }

    @Nullable
    public BaseTitleVM g() {
        return this.f11550a;
    }

    public abstract void l(@Nullable SchoolActivitySuccessActivity.a click);

    public abstract void m(@Nullable BaseTitleVM vm);
}
