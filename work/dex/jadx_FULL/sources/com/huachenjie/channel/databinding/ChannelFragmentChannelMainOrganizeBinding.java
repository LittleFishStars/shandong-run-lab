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
import com.huachenjie.channel.page.channel_main.organize.ChannelMainOrganizeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentChannelMainOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ChannelMainOrganizeVM f33161a;

    public ChannelFragmentChannelMainOrganizeBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelFragmentChannelMainOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentChannelMainOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentChannelMainOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_channel_main_organize);
    }

    @NonNull
    public static ChannelFragmentChannelMainOrganizeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentChannelMainOrganizeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentChannelMainOrganizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentChannelMainOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_channel_main_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentChannelMainOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentChannelMainOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_channel_main_organize, null, false, obj);
    }

    @Nullable
    public ChannelMainOrganizeVM f() {
        return this.f33161a;
    }

    public abstract void k(@Nullable ChannelMainOrganizeVM channelMainOrganizeVM);
}
