package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelLayoutMyChannelHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageButton f8199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f8201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RequestOptions f8202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelDetail f8203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelFragment.ClickProxy f8204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8205a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLImageView f8206b;

    @NonNull
    public final BLImageView c;

    @NonNull
    public final BLImageView d;

    public ChannelLayoutMyChannelHeaderBinding(Object obj, View view, int i, ImageButton imageButton, CardView cardView, BLImageView bLImageView, BLImageView bLImageView2, BLImageView bLImageView3, BLImageView bLImageView4, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f8199a = imageButton;
        this.f8201a = cardView;
        this.f8205a = bLImageView;
        this.f8206b = bLImageView2;
        this.c = bLImageView3;
        this.d = bLImageView4;
        this.f8200a = textView;
        this.b = textView2;
        this.f33321a = view2;
    }

    public static ChannelLayoutMyChannelHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelLayoutMyChannelHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelLayoutMyChannelHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.channel_layout_my_channel_header);
    }

    @NonNull
    public static ChannelLayoutMyChannelHeaderBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelLayoutMyChannelHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelLayoutMyChannelHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelLayoutMyChannelHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_layout_my_channel_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelLayoutMyChannelHeaderBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelLayoutMyChannelHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_layout_my_channel_header, null, false, obj);
    }

    @Nullable
    public MyChannelDetail f() {
        return this.f8203a;
    }

    @Nullable
    public RequestOptions g() {
        return this.f8202a;
    }

    @Nullable
    public MyChannelFragment.ClickProxy h() {
        return this.f8204a;
    }

    public abstract void m(@Nullable MyChannelDetail myChannelDetail);

    public abstract void n(@Nullable RequestOptions requestOptions);

    public abstract void o(@Nullable MyChannelFragment.ClickProxy clickProxy);
}
