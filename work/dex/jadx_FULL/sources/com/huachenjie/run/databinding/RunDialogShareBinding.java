package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.page.share.RunShareDialog;
import com.noober.background.view.BLTextView;
import com.shizhefei.view.largeimage.LargeImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogShareBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public BaseViewModel f35559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutShareActionPanelBinding f11780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunShareDialog.a f11781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LargeImageView f11783a;

    public RunDialogShareBinding(Object _bindingComponent, View _root, int _localFieldCount, LargeImageView imgScreenshot, RunLayoutShareActionPanelBinding llAction, BLTextView tvSlideTip) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11783a = imgScreenshot;
        this.f11780a = llAction;
        this.f11782a = tvSlideTip;
    }

    public static RunDialogShareBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogShareBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogShareBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_share);
    }

    @NonNull
    public static RunDialogShareBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogShareBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogShareBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogShareBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_share, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogShareBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogShareBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_share, null, false, component);
    }

    @Nullable
    public RunShareDialog.a f() {
        return this.f11781a;
    }

    @Nullable
    public BaseViewModel g() {
        return this.f35559a;
    }

    public abstract void l(@Nullable RunShareDialog.a click);

    public abstract void m(@Nullable BaseViewModel vm);
}
