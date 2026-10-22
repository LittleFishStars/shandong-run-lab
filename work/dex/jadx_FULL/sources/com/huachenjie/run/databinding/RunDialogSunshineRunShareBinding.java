package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.share.SunshineRunShareDialog;
import com.huachenjie.run.page.share.SunshineRunShareVM;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogSunshineRunShareBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunShareDialog.a f11790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunShareVM f11791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f11792a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public RunDialogSunshineRunShareBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clShareContent, AvatarView ivShareAvatar, ImageView ivShareBg, BLRelativeLayout rlShareCard, TextView tvShareCalorie, TextView tvShareDistance, TextView tvShareDistanceLabel, TextView tvShareDuration, TextView tvShareNickName, TextView tvSharePace) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11788a = clShareContent;
        this.f11789a = ivShareAvatar;
        this.f35562a = ivShareBg;
        this.f11792a = rlShareCard;
        this.f11787a = tvShareCalorie;
        this.b = tvShareDistance;
        this.c = tvShareDistanceLabel;
        this.d = tvShareDuration;
        this.e = tvShareNickName;
        this.f = tvSharePace;
    }

    public static RunDialogSunshineRunShareBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogSunshineRunShareBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogSunshineRunShareBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_sunshine_run_share);
    }

    @NonNull
    public static RunDialogSunshineRunShareBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogSunshineRunShareBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogSunshineRunShareBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogSunshineRunShareBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_sunshine_run_share, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogSunshineRunShareBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogSunshineRunShareBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_sunshine_run_share, null, false, component);
    }

    @Nullable
    public SunshineRunShareDialog.a f() {
        return this.f11790a;
    }

    @Nullable
    public SunshineRunShareVM g() {
        return this.f11791a;
    }

    public abstract void l(@Nullable SunshineRunShareDialog.a click);

    public abstract void m(@Nullable SunshineRunShareVM vm);
}
