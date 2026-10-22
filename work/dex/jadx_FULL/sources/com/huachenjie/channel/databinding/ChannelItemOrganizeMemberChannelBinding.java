package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemOrganizeMemberChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final AvatarView f33304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMemberBean f8146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8147a;

    public ChannelItemOrganizeMemberChannelBinding(Object obj, View view, int i, AvatarView avatarView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f33304a = avatarView;
        this.f8147a = bLTextView;
    }

    public static ChannelItemOrganizeMemberChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemOrganizeMemberChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemOrganizeMemberChannelBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_organize_member_channel);
    }

    @NonNull
    public static ChannelItemOrganizeMemberChannelBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemOrganizeMemberChannelBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeMemberChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemOrganizeMemberChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_member_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeMemberChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemOrganizeMemberChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_member_channel, null, false, obj);
    }

    @Nullable
    public ChannelMemberBean f() {
        return this.f8146a;
    }

    public abstract void k(@Nullable ChannelMemberBean channelMemberBean);
}
