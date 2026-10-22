package com.huachenjie.works.databinding;

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
import com.huachenjie.works.R;
import com.huachenjie.works.page.share.ShareWorksDialog;
import com.huachenjie.works.page.share.ShareWorksVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogShareWorkBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShareWorksDialog.a f14114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShareWorksVM f14115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14116a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14117b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f14118c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f14119d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f14120e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f14121f;

    @NonNull
    public final ImageView g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final TextView f14122g;

    @NonNull
    public final ImageView h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @NonNull
    public final TextView f14123h;

    public WorksDialogShareWorkBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivSharePoster, ImageView ivShareToFriend, ImageView ivShareToMiniProgram, ImageView ivShareToMoments, ImageView ivShareToQq, ImageView ivShareToSina, ImageView ivShareToTeam, ImageView ivShareToWechat, BLTextView tvCancel, TextView tvSharePoster, TextView tvShareToFriend, TextView tvShareToMiniProgram, TextView tvShareToMoments, TextView tvShareToQq, TextView tvShareToSina, TextView tvShareToTeam, TextView tvShareToWechat) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36880a = ivSharePoster;
        this.b = ivShareToFriend;
        this.c = ivShareToMiniProgram;
        this.d = ivShareToMoments;
        this.e = ivShareToQq;
        this.f = ivShareToSina;
        this.g = ivShareToTeam;
        this.h = ivShareToWechat;
        this.f14116a = tvCancel;
        this.f14113a = tvSharePoster;
        this.f14117b = tvShareToFriend;
        this.f14118c = tvShareToMiniProgram;
        this.f14119d = tvShareToMoments;
        this.f14120e = tvShareToQq;
        this.f14121f = tvShareToSina;
        this.f14122g = tvShareToTeam;
        this.f14123h = tvShareToWechat;
    }

    public static WorksDialogShareWorkBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogShareWorkBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogShareWorkBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_share_work);
    }

    @NonNull
    public static WorksDialogShareWorkBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogShareWorkBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogShareWorkBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogShareWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_share_work, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogShareWorkBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogShareWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_share_work, null, false, component);
    }

    @Nullable
    public ShareWorksDialog.a f() {
        return this.f14114a;
    }

    @Nullable
    public ShareWorksVM g() {
        return this.f14115a;
    }

    public abstract void l(@Nullable ShareWorksDialog.a click);

    public abstract void m(@Nullable ShareWorksVM vm);
}
