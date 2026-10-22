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
import com.huachenjie.channel.bean.OrganizeTeamBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyChannelOrganizeChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public OrganizeTeamBean f33282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8069a;

    public ChannelItemMyChannelOrganizeChatBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemMyChannelOrganizeChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyChannelOrganizeChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyChannelOrganizeChatBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_channel_organize_chat);
    }

    @NonNull
    public static ChannelItemMyChannelOrganizeChatBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyChannelOrganizeChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelOrganizeChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyChannelOrganizeChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_organize_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelOrganizeChatBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyChannelOrganizeChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_organize_chat, null, false, obj);
    }

    @Nullable
    public OrganizeTeamBean f() {
        return this.f33282a;
    }

    @Nullable
    public Boolean g() {
        return this.f8069a;
    }

    public abstract void l(@Nullable OrganizeTeamBean organizeTeamBean);

    public abstract void m(@Nullable Boolean bool);
}
