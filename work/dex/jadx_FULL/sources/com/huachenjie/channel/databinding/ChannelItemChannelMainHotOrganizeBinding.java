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
import com.huachenjie.channel.bean.OrganizeBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemChannelMainHotOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public OrganizeBean f33228a;

    public ChannelItemChannelMainHotOrganizeBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemChannelMainHotOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemChannelMainHotOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemChannelMainHotOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_channel_main_hot_organize);
    }

    @NonNull
    public static ChannelItemChannelMainHotOrganizeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemChannelMainHotOrganizeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemChannelMainHotOrganizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemChannelMainHotOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_channel_main_hot_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemChannelMainHotOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemChannelMainHotOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_channel_main_hot_organize, null, false, obj);
    }

    @Nullable
    public OrganizeBean f() {
        return this.f33228a;
    }

    public abstract void k(@Nullable OrganizeBean organizeBean);
}
