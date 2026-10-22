package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.dialog.task.DoubleRewardDialog;
import com.huachenjie.home.dialog.task.DoubleRewardVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeDialogDoubleRewardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public DoubleRewardDialog.a f34223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DoubleRewardVM f9345a;

    public HomeDialogDoubleRewardBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static HomeDialogDoubleRewardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeDialogDoubleRewardBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeDialogDoubleRewardBinding) ViewDataBinding.bind(obj, view, R.layout.home_dialog_double_reward);
    }

    @NonNull
    public static HomeDialogDoubleRewardBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeDialogDoubleRewardBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeDialogDoubleRewardBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeDialogDoubleRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_double_reward, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeDialogDoubleRewardBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeDialogDoubleRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_double_reward, null, false, obj);
    }

    @Nullable
    public DoubleRewardDialog.a f() {
        return this.f34223a;
    }

    @Nullable
    public DoubleRewardVM g() {
        return this.f9345a;
    }

    public abstract void l(@Nullable DoubleRewardDialog.a aVar);

    public abstract void m(@Nullable DoubleRewardVM doubleRewardVM);
}
