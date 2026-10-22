package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.channel_main.organize.ChannelMainHotOrganizeAdapter;
import com.huachenjie.channel.page.channel_main.organize.ChannelMainOrganizeFragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelViewChannelMainHotOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f8218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainHotOrganizeAdapter f8219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainOrganizeFragment.a f8220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8221a;

    public ChannelViewChannelMainHotOrganizeBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.f8218a = recyclerView;
        this.f33327a = textView;
    }

    public static ChannelViewChannelMainHotOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelViewChannelMainHotOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelViewChannelMainHotOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_view_channel_main_hot_organize);
    }

    @NonNull
    public static ChannelViewChannelMainHotOrganizeBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelViewChannelMainHotOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelViewChannelMainHotOrganizeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelViewChannelMainHotOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_channel_main_hot_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelViewChannelMainHotOrganizeBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelViewChannelMainHotOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_channel_main_hot_organize, null, false, obj);
    }

    @Nullable
    public ChannelMainHotOrganizeAdapter f() {
        return this.f8219a;
    }

    @Nullable
    public ChannelMainOrganizeFragment.a g() {
        return this.f8220a;
    }

    @Nullable
    public Boolean h() {
        return this.f8221a;
    }

    public abstract void m(@Nullable ChannelMainHotOrganizeAdapter channelMainHotOrganizeAdapter);

    public abstract void n(@Nullable ChannelMainOrganizeFragment.a aVar);

    public abstract void o(@Nullable Boolean bool);
}
