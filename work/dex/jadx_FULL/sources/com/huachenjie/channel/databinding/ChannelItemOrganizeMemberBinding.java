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
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeTeamUserBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemOrganizeMemberBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeTeamUserBean f8141a;

    public ChannelItemOrganizeMemberBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f33302a = textView;
    }

    public static ChannelItemOrganizeMemberBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemOrganizeMemberBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemOrganizeMemberBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_organize_member);
    }

    @NonNull
    public static ChannelItemOrganizeMemberBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemOrganizeMemberBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeMemberBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemOrganizeMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_member, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeMemberBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemOrganizeMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize_member, null, false, obj);
    }

    @Nullable
    public OrganizeTeamUserBean f() {
        return this.f8141a;
    }

    public abstract void k(@Nullable OrganizeTeamUserBean organizeTeamUserBean);
}
