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
import com.huachenjie.channel.bean.ClassificationBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemChannelTypeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ClassificationBean f33232a;

    public ChannelItemChannelTypeBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemChannelTypeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemChannelTypeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemChannelTypeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_channel_type);
    }

    @NonNull
    public static ChannelItemChannelTypeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemChannelTypeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemChannelTypeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemChannelTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_channel_type, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemChannelTypeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemChannelTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_channel_type, null, false, obj);
    }

    @Nullable
    public ClassificationBean f() {
        return this.f33232a;
    }

    public abstract void k(@Nullable ClassificationBean classificationBean);
}
