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
import com.huachenjie.channel.page.all_organize.AllOrganizeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityAllOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AllOrganizeVM f33034a;

    public ChannelActivityAllOrganizeBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelActivityAllOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityAllOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityAllOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_all_organize);
    }

    @NonNull
    public static ChannelActivityAllOrganizeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityAllOrganizeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAllOrganizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityAllOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_all_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAllOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityAllOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_all_organize, null, false, obj);
    }

    @Nullable
    public AllOrganizeVM f() {
        return this.f33034a;
    }

    public abstract void k(@Nullable AllOrganizeVM allOrganizeVM);
}
