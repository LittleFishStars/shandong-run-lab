package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.im.bean.TeamMemberBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemTeamMemberManageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TeamMemberBean f8171a;

    public ChannelItemTeamMemberManageBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f33313a = imageView;
    }

    public static ChannelItemTeamMemberManageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemTeamMemberManageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemTeamMemberManageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_team_member_manage);
    }

    @NonNull
    public static ChannelItemTeamMemberManageBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemTeamMemberManageBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemTeamMemberManageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemTeamMemberManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_team_member_manage, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemTeamMemberManageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemTeamMemberManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_team_member_manage, null, false, obj);
    }

    @Nullable
    public TeamMemberBean f() {
        return this.f8171a;
    }

    public abstract void k(@Nullable TeamMemberBean teamMemberBean);
}
