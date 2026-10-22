package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.ActivityRunBean;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemActivityRunListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ActivityRunBean f11915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f11916a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public RunItemActivityRunListBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivArrow, TextView tvActivityName, TextView tvDateTimeTitle, TextView tvRewardInfoTitle, TextView tvRunPlanNameTitle, TextView tvStatus, BLView vLine) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35607a = ivArrow;
        this.f11914a = tvActivityName;
        this.b = tvDateTimeTitle;
        this.c = tvRewardInfoTitle;
        this.d = tvRunPlanNameTitle;
        this.e = tvStatus;
        this.f11916a = vLine;
    }

    public static RunItemActivityRunListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemActivityRunListBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemActivityRunListBinding) ViewDataBinding.bind(component, view, R.layout.run_item_activity_run_list);
    }

    @NonNull
    public static RunItemActivityRunListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemActivityRunListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemActivityRunListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemActivityRunListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_activity_run_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemActivityRunListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemActivityRunListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_activity_run_list, null, false, component);
    }

    @Nullable
    public ActivityRunBean f() {
        return this.f11915a;
    }

    public abstract void k(@Nullable ActivityRunBean item);
}
