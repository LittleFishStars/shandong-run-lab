package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.external.dialog.NotifyFansMenuDialog;
import com.huachenjie.channel.external.dialog.NotifyFansMenuModel;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentNotifyFansMenuBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyFansMenuDialog.a f7864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyFansMenuModel f7865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f7866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7867a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f7868b;

    public ChannelFragmentNotifyFansMenuBinding(Object obj, View view, int i, DrawableCenterButton drawableCenterButton, DrawableCenterButton drawableCenterButton2, AvatarView avatarView, TextView textView, TextView textView2, BLView bLView) {
        super(obj, view, i);
        this.f7866a = drawableCenterButton;
        this.f7868b = drawableCenterButton2;
        this.f7863a = avatarView;
        this.f33203a = textView;
        this.b = textView2;
        this.f7867a = bLView;
    }

    public static ChannelFragmentNotifyFansMenuBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentNotifyFansMenuBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentNotifyFansMenuBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_notify_fans_menu);
    }

    @NonNull
    public static ChannelFragmentNotifyFansMenuBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentNotifyFansMenuBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyFansMenuBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentNotifyFansMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_fans_menu, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyFansMenuBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentNotifyFansMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_fans_menu, null, false, obj);
    }

    @Nullable
    public NotifyFansMenuDialog.a f() {
        return this.f7864a;
    }

    @Nullable
    public NotifyFansMenuModel g() {
        return this.f7865a;
    }

    public abstract void l(@Nullable NotifyFansMenuDialog.a aVar);

    public abstract void m(@Nullable NotifyFansMenuModel notifyFansMenuModel);
}
