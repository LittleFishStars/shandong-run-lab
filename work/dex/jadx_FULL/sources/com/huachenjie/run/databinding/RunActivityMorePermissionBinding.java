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
import com.huachenjie.run.page.MorePermissionActivity;
import com.huachenjie.run.page.MorePermissionVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityMorePermissionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MorePermissionActivity.a f11514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MorePermissionVM f11515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11516a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11517b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f11518b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f11519c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLTextView f11520c;

    @NonNull
    public final TextView d;

    public RunActivityMorePermissionBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btnAutoClosePowerSavingMode, BLTextView btnAutoOpenAccessibility, BLTextView btnAutoOpenBatteryWhite, ImageView dotAccessibility, ImageView dotBattery, ImageView dotPower, TextView tvClosePowerSavingMode, TextView tvNotRemind, TextView tvOpenAccessibility, TextView tvOpenBatteryWhite) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11516a = btnAutoClosePowerSavingMode;
        this.f11518b = btnAutoOpenAccessibility;
        this.f11520c = btnAutoOpenBatteryWhite;
        this.f35480a = dotAccessibility;
        this.b = dotBattery;
        this.c = dotPower;
        this.f11513a = tvClosePowerSavingMode;
        this.f11517b = tvNotRemind;
        this.f11519c = tvOpenAccessibility;
        this.d = tvOpenBatteryWhite;
    }

    public static RunActivityMorePermissionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityMorePermissionBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityMorePermissionBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_more_permission);
    }

    @NonNull
    public static RunActivityMorePermissionBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityMorePermissionBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityMorePermissionBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityMorePermissionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_more_permission, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityMorePermissionBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityMorePermissionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_more_permission, null, false, component);
    }

    @Nullable
    public MorePermissionActivity.a f() {
        return this.f11514a;
    }

    @Nullable
    public MorePermissionVM g() {
        return this.f11515a;
    }

    public abstract void l(@Nullable MorePermissionActivity.a click);

    public abstract void m(@Nullable MorePermissionVM vm);
}
