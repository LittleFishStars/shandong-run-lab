package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.ruler.VerticalRulerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogMoreDistanceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f35541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final VerticalRulerView f11733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MoreDistanceDialog.a f11734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11735a;

    public RunDialogMoreDistanceBinding(Object _bindingComponent, View _root, int _localFieldCount, CheckBox cbRemember, ImageView ivClose, FrameLayout llContent, VerticalRulerView rulerDistance, BLTextView tvConfirm, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35541a = cbRemember;
        this.f11731a = ivClose;
        this.f11730a = llContent;
        this.f11733a = rulerDistance;
        this.f11735a = tvConfirm;
        this.f11732a = tvTitle;
    }

    public static RunDialogMoreDistanceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogMoreDistanceBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogMoreDistanceBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_more_distance);
    }

    @NonNull
    public static RunDialogMoreDistanceBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogMoreDistanceBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogMoreDistanceBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogMoreDistanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_more_distance, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogMoreDistanceBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogMoreDistanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_more_distance, null, false, component);
    }

    @Nullable
    public MoreDistanceDialog.a f() {
        return this.f11734a;
    }

    public abstract void k(@Nullable MoreDistanceDialog.a click);
}
