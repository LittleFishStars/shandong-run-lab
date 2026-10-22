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
import com.huachenjie.channel.page.notify.NotifyVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityNotifyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public NotifyVM f33096a;

    public ChannelActivityNotifyBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelActivityNotifyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityNotifyBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityNotifyBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_notify);
    }

    @NonNull
    public static ChannelActivityNotifyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityNotifyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityNotifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityNotifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify, null, false, obj);
    }

    @Nullable
    public NotifyVM f() {
        return this.f33096a;
    }

    public abstract void k(@Nullable NotifyVM notifyVM);
}
