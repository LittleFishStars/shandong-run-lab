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
import com.huachenjie.channel.bean.ChannelAdminBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageAdminUserBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f8014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelAdminBean f8015a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8016a;

    @NonNull
    public final TextView b;

    public ChannelItemManageAdminUserBinding(Object obj, View view, int i, AvatarView avatarView, BLTextView bLTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8014a = avatarView;
        this.f8016a = bLTextView;
        this.f33260a = textView;
        this.b = textView2;
    }

    public static ChannelItemManageAdminUserBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageAdminUserBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageAdminUserBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_admin_user);
    }

    @NonNull
    public static ChannelItemManageAdminUserBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageAdminUserBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageAdminUserBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageAdminUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_admin_user, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageAdminUserBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageAdminUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_admin_user, null, false, obj);
    }

    @Nullable
    public ChannelAdminBean f() {
        return this.f8015a;
    }

    public abstract void k(@Nullable ChannelAdminBean channelAdminBean);
}
