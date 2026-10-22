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
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.channel_main.ChannelMainActivity;
import com.huachenjie.channel.page.channel_main.ChannelMainVM;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelLayoutChannelMainHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f8184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainActivity.a f8185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainVM f8186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonBanner f8187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f8188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8189a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8190b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLImageView f8191b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLImageView f8192c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final BLImageView f8193d;

    public ChannelLayoutChannelMainHeaderBinding(Object obj, View view, int i, CommonBanner commonBanner, DrawableCenterButton drawableCenterButton, BLImageView bLImageView, ImageView imageView, BLImageView bLImageView2, BLImageView bLImageView3, BLImageView bLImageView4, TextView textView, ExpandableTextView expandableTextView, TextView textView2, TextView textView3, TextView textView4, View view2, View view3) {
        super(obj, view, i);
        this.f8187a = commonBanner;
        this.f8188a = drawableCenterButton;
        this.f8189a = bLImageView;
        this.f8182a = imageView;
        this.f8191b = bLImageView2;
        this.f8192c = bLImageView3;
        this.f8193d = bLImageView4;
        this.f8183a = textView;
        this.f8184a = expandableTextView;
        this.f8190b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.f33317a = view2;
        this.b = view3;
    }

    public static ChannelLayoutChannelMainHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelLayoutChannelMainHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelLayoutChannelMainHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.channel_layout_channel_main_header);
    }

    @NonNull
    public static ChannelLayoutChannelMainHeaderBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelLayoutChannelMainHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelLayoutChannelMainHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelLayoutChannelMainHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_layout_channel_main_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelLayoutChannelMainHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelLayoutChannelMainHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_layout_channel_main_header, null, false, obj);
    }

    @Nullable
    public ChannelMainActivity.a f() {
        return this.f8185a;
    }

    @Nullable
    public ChannelMainVM g() {
        return this.f8186a;
    }

    public abstract void l(@Nullable ChannelMainActivity.a aVar);

    public abstract void m(@Nullable ChannelMainVM channelMainVM);
}
