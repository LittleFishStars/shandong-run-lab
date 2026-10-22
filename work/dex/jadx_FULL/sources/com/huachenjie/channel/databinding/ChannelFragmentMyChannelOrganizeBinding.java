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
import com.huachenjie.channel.page.my_channel.organize.OrganizeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentMyChannelOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public OrganizeVM f33196a;

    public ChannelFragmentMyChannelOrganizeBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelFragmentMyChannelOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentMyChannelOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentMyChannelOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_my_channel_organize);
    }

    @NonNull
    public static ChannelFragmentMyChannelOrganizeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentMyChannelOrganizeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentMyChannelOrganizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentMyChannelOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_my_channel_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentMyChannelOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentMyChannelOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_my_channel_organize, null, false, obj);
    }

    @Nullable
    public OrganizeVM f() {
        return this.f33196a;
    }

    public abstract void k(@Nullable OrganizeVM organizeVM);
}
