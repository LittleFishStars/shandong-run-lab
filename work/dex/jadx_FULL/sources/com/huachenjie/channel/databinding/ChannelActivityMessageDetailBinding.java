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
import com.huachenjie.channel.page.message_detail.MessageDetailVM;
import com.huachenjie.common.widget.CommonBanner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityMessageDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MessageDetailVM f7579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonBanner f7580a;

    @NonNull
    public final TextView b;

    public ChannelActivityMessageDetailBinding(Object obj, View view, int i, CommonBanner commonBanner, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7580a = commonBanner;
        this.f33090a = imageView;
        this.f7578a = textView;
        this.b = textView2;
    }

    public static ChannelActivityMessageDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityMessageDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityMessageDetailBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_message_detail);
    }

    @NonNull
    public static ChannelActivityMessageDetailBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityMessageDetailBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityMessageDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityMessageDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_message_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityMessageDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityMessageDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_message_detail, null, false, obj);
    }

    @Nullable
    public MessageDetailVM f() {
        return this.f7579a;
    }

    public abstract void k(@Nullable MessageDetailVM messageDetailVM);
}
