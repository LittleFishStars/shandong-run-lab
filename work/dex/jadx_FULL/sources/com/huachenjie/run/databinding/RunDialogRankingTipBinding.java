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
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogRankingTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f11770a;

    public RunDialogRankingTipBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivClose, TextView tvTitle, View vStatusSpace) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11768a = ivClose;
        this.f11769a = tvTitle;
        this.f35555a = vStatusSpace;
    }

    public static RunDialogRankingTipBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogRankingTipBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogRankingTipBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_ranking_tip);
    }

    @NonNull
    public static RunDialogRankingTipBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogRankingTipBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogRankingTipBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogRankingTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_ranking_tip, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogRankingTipBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogRankingTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_ranking_tip, null, false, component);
    }

    @Nullable
    public BaseVM f() {
        return this.f11770a;
    }

    public abstract void k(@Nullable BaseVM vm);
}
