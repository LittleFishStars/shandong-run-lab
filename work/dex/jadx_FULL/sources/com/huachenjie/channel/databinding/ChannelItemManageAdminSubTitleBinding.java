package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.zj.adlib.SubAdminTitle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageAdminSubTitleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SubAdminTitle f33257a;

    public ChannelItemManageAdminSubTitleBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemManageAdminSubTitleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageAdminSubTitleBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageAdminSubTitleBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_admin_sub_title);
    }

    @NonNull
    public static ChannelItemManageAdminSubTitleBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageAdminSubTitleBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageAdminSubTitleBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageAdminSubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_admin_sub_title, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageAdminSubTitleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageAdminSubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_admin_sub_title, null, false, obj);
    }

    @Nullable
    public SubAdminTitle f() {
        return this.f33257a;
    }

    public abstract void k(@Nullable SubAdminTitle subAdminTitle);
}
