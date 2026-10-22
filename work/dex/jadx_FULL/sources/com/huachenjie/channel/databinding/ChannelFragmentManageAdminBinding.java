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
import com.huachenjie.channel.page.manage_channel.admin.ManageAdminVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentManageAdminBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ManageAdminVM f33173a;

    public ChannelFragmentManageAdminBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelFragmentManageAdminBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentManageAdminBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentManageAdminBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_manage_admin);
    }

    @NonNull
    public static ChannelFragmentManageAdminBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentManageAdminBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageAdminBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentManageAdminBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_admin, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageAdminBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentManageAdminBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_admin, null, false, obj);
    }

    @Nullable
    public ManageAdminVM f() {
        return this.f33173a;
    }

    public abstract void k(@Nullable ManageAdminVM manageAdminVM);
}
