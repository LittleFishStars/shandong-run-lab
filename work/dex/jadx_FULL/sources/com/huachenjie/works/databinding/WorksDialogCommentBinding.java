package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseViewModel f14045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f14047a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    public WorksDialogCommentBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardView, FrameLayout flComment, ImageView ivAt, ImageView ivClose, ImageView ivEmoji, ImageView ivGoods, ImageView ivPic, BLLinearLayout llCommentView, BLRelativeLayout rlContent) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14044a = cardView;
        this.f36847a = flComment;
        this.f14043a = ivAt;
        this.b = ivClose;
        this.c = ivEmoji;
        this.d = ivGoods;
        this.e = ivPic;
        this.f14046a = llCommentView;
        this.f14047a = rlContent;
    }

    public static WorksDialogCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogCommentBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogCommentBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_comment);
    }

    @NonNull
    public static WorksDialogCommentBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogCommentBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogCommentBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_comment, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogCommentBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_comment, null, false, component);
    }

    @Nullable
    public BaseViewModel f() {
        return this.f14045a;
    }

    public abstract void k(@Nullable BaseViewModel vm);
}
