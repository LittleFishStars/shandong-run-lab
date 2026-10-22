package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.NotifyBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemNotifyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyBean f8102a;

    public ChannelItemNotifyBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f33292a = imageView;
        this.f8101a = textView;
    }

    public static ChannelItemNotifyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemNotifyBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemNotifyBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_notify);
    }

    @NonNull
    public static ChannelItemNotifyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemNotifyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemNotifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemNotifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify, null, false, obj);
    }

    @Nullable
    public NotifyBean f() {
        return this.f8102a;
    }

    public abstract void k(@Nullable NotifyBean notifyBean);
}
