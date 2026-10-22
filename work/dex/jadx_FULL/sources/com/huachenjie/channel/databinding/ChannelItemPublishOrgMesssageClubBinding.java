package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemPublishOrgMesssageClubBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public OrganizeBean f33310a;

    public ChannelItemPublishOrgMesssageClubBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemPublishOrgMesssageClubBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemPublishOrgMesssageClubBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemPublishOrgMesssageClubBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_publish_org_messsage_club);
    }

    @NonNull
    public static ChannelItemPublishOrgMesssageClubBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemPublishOrgMesssageClubBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemPublishOrgMesssageClubBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemPublishOrgMesssageClubBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_publish_org_messsage_club, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemPublishOrgMesssageClubBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemPublishOrgMesssageClubBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_publish_org_messsage_club, null, false, obj);
    }

    @Nullable
    public OrganizeBean f() {
        return this.f33310a;
    }

    public abstract void k(@Nullable OrganizeBean organizeBean);
}
