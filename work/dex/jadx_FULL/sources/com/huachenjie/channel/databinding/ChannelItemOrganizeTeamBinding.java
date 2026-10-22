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
import com.huachenjie.channel.bean.OrganizeTeamBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemOrganizeTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeTeamBean f8161a;

    public ChannelItemOrganizeTeamBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f33308a = imageView;
        this.f8160a = textView;
    }

    public static ChannelItemOrganizeTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemOrganizeTeamBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemOrganizeTeamBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_organize_team);
    }

    @NonNull
    public static ChannelItemOrganizeTeamBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemOrganizeTeamBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeTeamBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemOrganizeTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_team, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeTeamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemOrganizeTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_team, null, false, obj);
    }

    @Nullable
    public OrganizeTeamBean f() {
        return this.f8161a;
    }

    public abstract void k(@Nullable OrganizeTeamBean organizeTeamBean);
}
