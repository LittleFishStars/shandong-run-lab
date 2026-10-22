package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.school.JoinChannelTipDialog;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogJoinChannelTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public JoinChannelTipDialog.a f14088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f14089a;

    public WorksDialogJoinChannelTipBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivHeader, BLView vCenter) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36868a = ivHeader;
        this.f14089a = vCenter;
    }

    public static WorksDialogJoinChannelTipBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogJoinChannelTipBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogJoinChannelTipBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_join_channel_tip);
    }

    @NonNull
    public static WorksDialogJoinChannelTipBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogJoinChannelTipBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogJoinChannelTipBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogJoinChannelTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_join_channel_tip, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogJoinChannelTipBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogJoinChannelTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_join_channel_tip, null, false, component);
    }

    @Nullable
    public JoinChannelTipDialog.a f() {
        return this.f14088a;
    }

    public abstract void k(@Nullable JoinChannelTipDialog.a click);
}
