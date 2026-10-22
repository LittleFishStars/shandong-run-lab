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
import com.huachenjie.channel.bean.ClubMessageBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemOrganizeMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ClubMessageBean f8154a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8155b;

    @NonNull
    public final TextView c;

    public ChannelItemOrganizeMessageBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.f8152a = imageView;
        this.b = imageView2;
        this.f8153a = textView;
        this.f8155b = textView2;
        this.c = textView3;
        this.f33306a = view2;
    }

    public static ChannelItemOrganizeMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemOrganizeMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemOrganizeMessageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_organize_message);
    }

    @NonNull
    public static ChannelItemOrganizeMessageBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemOrganizeMessageBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemOrganizeMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemOrganizeMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_message, null, false, obj);
    }

    @Nullable
    public ClubMessageBean f() {
        return this.f8154a;
    }

    public abstract void k(@Nullable ClubMessageBean clubMessageBean);
}
