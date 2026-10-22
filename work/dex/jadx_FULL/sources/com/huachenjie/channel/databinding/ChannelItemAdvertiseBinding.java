package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemAdvertiseBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AdvertiseBean f7908a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    public ChannelItemAdvertiseBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f33220a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.f7907a = linearLayout;
    }

    public static ChannelItemAdvertiseBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemAdvertiseBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemAdvertiseBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_advertise);
    }

    @NonNull
    public static ChannelItemAdvertiseBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemAdvertiseBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemAdvertiseBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_advertise, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemAdvertiseBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_advertise, null, false, obj);
    }

    @Nullable
    public AdvertiseBean f() {
        return this.f7908a;
    }

    public abstract void k(@Nullable AdvertiseBean advertiseBean);
}
