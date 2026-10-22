package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelHomeItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemHomeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelHomeItemBean f7984a;

    public ChannelItemHomeBinding(Object obj, View view, int i, View view2, ImageView imageView) {
        super(obj, view, i);
        this.f33249a = view2;
        this.f7983a = imageView;
    }

    public static ChannelItemHomeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemHomeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemHomeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_home);
    }

    @NonNull
    public static ChannelItemHomeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemHomeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemHomeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_home, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemHomeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_home, null, false, obj);
    }

    @Nullable
    public ChannelHomeItemBean f() {
        return this.f7984a;
    }

    public abstract void k(@Nullable ChannelHomeItemBean channelHomeItemBean);
}
