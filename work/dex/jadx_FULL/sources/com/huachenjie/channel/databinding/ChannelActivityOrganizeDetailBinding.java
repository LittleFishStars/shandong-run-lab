package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.organize_detail.OrganizeDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityOrganizeDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeDetailVM f7649a;

    public ChannelActivityOrganizeDetailBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f33114a = recyclerView;
    }

    public static ChannelActivityOrganizeDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityOrganizeDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityOrganizeDetailBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_organize_detail);
    }

    @NonNull
    public static ChannelActivityOrganizeDetailBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityOrganizeDetailBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityOrganizeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityOrganizeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_detail, null, false, obj);
    }

    @Nullable
    public OrganizeDetailVM f() {
        return this.f7649a;
    }

    public abstract void k(@Nullable OrganizeDetailVM organizeDetailVM);
}
